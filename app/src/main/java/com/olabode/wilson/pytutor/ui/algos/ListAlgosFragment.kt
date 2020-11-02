package com.olabode.wilson.pytutor.ui.algos

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentListAlgosBinding
import com.olabode.wilson.pytutor.extensions.hide
import com.olabode.wilson.pytutor.extensions.show
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.extensions.navigateSafe
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListAlgosFragment : Fragment(R.layout.fragment_list_algos) {

    private val binding by viewBinding(FragmentListAlgosBinding::bind)
    private lateinit var adapter: AlgorithmListAdapter
    private val viewModel: AlgorithmsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AlgorithmListAdapter { algorithm ->
            navigateSafe(ListAlgosFragmentDirections
                .actionListAlgosFragmentToAlgorithmFragment(algorithm, algorithm.title))
        }
        binding.algoList.adapter = adapter

        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.algorithms.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Loading -> {
                    binding.progressBar.show()
                    binding.noInternetState.root.hide()
                }

                is DataState.Success -> {
                    binding.progressBar.hide()
                    binding.mainPage.show()
                    binding.noInternetState.root.hide()
                    adapter.submitList(result.data)
                }

                is DataState.Error -> {
                    binding.progressBar.hide()
                    binding.noInternetState.root.show()
                    binding.mainPage.hide()
                }
            }
        })
    }
}