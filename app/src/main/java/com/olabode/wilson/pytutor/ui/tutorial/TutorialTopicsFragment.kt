package com.olabode.wilson.pytutor.ui.tutorial

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentTutorialTopicsBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.tutorial.TopicResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TutorialTopicsFragment : Fragment(R.layout.fragment_tutorial_topics) {


    private val binding by viewBinding(FragmentTutorialTopicsBinding::bind)

    private lateinit var adapter: TutorialTopicAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TutorialTopicAdapter { topic ->
            findNavController().navigate(TutorialTopicsFragmentDirections
                    .actionTutorialTopicsFragmentToViewTutorialsFragment(topic.Title, topic))
        }
        binding.topicsRecycler.adapter = adapter
        adapter.submitList(dummyList())
    }

    private fun dummyList(): List<TopicResponse> =
            listOf(
                    TopicResponse(
                            1,
                            "Variables",
                            "learn how to creates  variables",
                            5,
                            "we",
                            isLocked = false,
                            isCompleted = false
                    ),
                    TopicResponse(
                            1,
                            "Lists",
                            "learn how to creates  Lists",
                            7,
                            "wrtye",
                            isLocked = false,
                            isCompleted = false
                    ),
                    TopicResponse(
                            1,
                            "Dictionary",
                            "learn how to creates  Dictionaries",
                            7,
                            "weetrry",
                            isLocked = false,
                            isCompleted = false
                    )
            )

}