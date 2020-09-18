package com.olabode.wilson.pytutor.ui.tutorial

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentTutorialTopicsBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.ui.tutorial.adapters.TutorialTopicAdapter
import com.olabode.wilson.pytutor.ui.tutorial.viewmodel.TutorialTopicViewModel
import com.olabode.wilson.pytutor.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TutorialTopicsFragment : Fragment(R.layout.fragment_tutorial_topics) {


    private val binding by viewBinding(FragmentTutorialTopicsBinding::bind)
    private val viewModel: TutorialTopicViewModel by viewModels()

    private lateinit var adapter: TutorialTopicAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TutorialTopicAdapter { topic ->
            findNavController().navigate(TutorialTopicsFragmentDirections
                    .actionTutorialTopicsFragmentToViewTutorialsFragment(title = topic.title, topic = topic))
        }
        binding.topicsRecycler.adapter = adapter

        viewModel.topics.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Success -> {
                    binding.progressBar.isVisible = false
                    adapter.submitList(result.data.sortedBy { it.orderKey })
                }
                is DataState.Error -> {
                    binding.progressBar.isVisible = false
                    Timber.d(result.message)
                    Toast.makeText(requireContext(), result.message, Toast.LENGTH_SHORT).show()
                }

                is DataState.Loading -> {
                    binding.progressBar.isVisible = true
                }
            }
        })
    }
}