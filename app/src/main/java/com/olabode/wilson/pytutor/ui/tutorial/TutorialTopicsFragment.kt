package com.olabode.wilson.pytutor.ui.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentTutorialTopicsBinding
import com.olabode.wilson.pytutor.ui.tutorial.adapters.TutorialTopicAdapter
import com.olabode.wilson.pytutor.ui.tutorial.viewmodel.TutorialTopicViewModel
import com.olabode.wilson.pytutor.utils.EventObserver
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TutorialTopicsFragment : Fragment(R.layout.fragment_tutorial_topics) {

    private var _binding: FragmentTutorialTopicsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TutorialTopicViewModel by viewModels()
    private lateinit var adapter: TutorialTopicAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTutorialTopicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.topicsRecycler.adapter = null
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TutorialTopicAdapter { topic, message ->
            topic?.let {
                findNavController().navigate(
                    TutorialTopicsFragmentDirections
                        .actionTutorialTopicsFragmentToViewTutorialsFragment(
                            title = topic.title,
                            topic = topic
                        )
                )
            }

            message?.let { viewModel.showSnackBar(it) }

        }
        binding.topicsRecycler.adapter = adapter

        initTopics()

        viewModel.showSnackBar.observe(viewLifecycleOwner, EventObserver {
            showSnackBar(it, binding.coordinatorLayout)
        })

        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
    }

    private fun showSnackBar(message: String, view: View) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun showPersistentSnackBar(message: String, view: View, action: () -> Unit) {
        Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
            .setAction(getString(R.string.retry)) {
                action.invoke()
            }.show()
    }

    private fun initTopics() {
        viewModel.fetchTopics().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Success -> {
                    binding.mainPage.isVisible = true
                    binding.noInternetState.root.isVisible = false
                    binding.progressBar.isVisible = false
                }
                is DataState.Error -> {
                    binding.mainPage.isVisible = false
                    binding.progressBar.isVisible = false
                    binding.noInternetState.root.isVisible = true
                    showPersistentSnackBar(result.message, binding.coordinatorLayout) {
                        initTopics()
                    }
                }

                is DataState.Loading -> {
                    binding.noInternetState.root.isVisible = false
                    binding.progressBar.isVisible = true
                }
            }
        })

        viewModel.topics.observe(viewLifecycleOwner, Observer { topics ->
            topics?.let {
                adapter.submitList(topics.sortedBy { it.orderKey })
            }
        })
    }
}