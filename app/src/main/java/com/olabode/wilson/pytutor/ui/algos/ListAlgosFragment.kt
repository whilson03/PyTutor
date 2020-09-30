package com.olabode.wilson.pytutor.ui.algos

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentListAlgosBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListAlgosFragment : Fragment(R.layout.fragment_list_algos) {

    private val binding by viewBinding(FragmentListAlgosBinding::bind)
    private lateinit var adapter: AlgorithmListAdapter
    private val viewModel: AlgorithmsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AlgorithmListAdapter { algorithm ->
            findNavController().navigate(
                ListAlgosFragmentDirections
                    .actionListAlgosFragmentToAlgorithmFragment(algorithm, algorithm.title)
            )
        }
        binding.algoList.adapter = adapter

        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.algorithms.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.noInternetState.root.isVisible = false
                }

                is DataState.Success -> {
                    binding.progressBar.isVisible = false
                    binding.mainPage.isVisible = true
                    binding.noInternetState.root.isVisible = false
                    adapter.submitList(result.data)
                }

                is DataState.Error -> {
                    binding.progressBar.isVisible = false
                    binding.noInternetState.root.isVisible = true
                    binding.mainPage.isVisible = false
                }
            }
        })
    }
}