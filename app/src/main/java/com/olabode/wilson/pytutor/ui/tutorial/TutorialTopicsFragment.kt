package com.olabode.wilson.pytutor.ui.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.olabode.wilson.pytutor.databinding.FragmentTutorialTopicsBinding
import com.olabode.wilson.pytutor.models.tutorial.TopicResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TutorialTopicsFragment : Fragment() {

    private var _binding: FragmentTutorialTopicsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TutorialTopicAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentTutorialTopicsBinding.inflate(inflater, container, false)
        adapter = TutorialTopicAdapter { topic ->

        }
        binding.topicsRecycler.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.submitList(dummyList())
    }

    private fun dummyList(): List<TopicResponse> =
            listOf(
                    TopicResponse(
                            1,
                            "Variables",
                            "learn how to creates  variables",
                            8,
                            "we",
                            isLocked = false,
                            isCompleted = false
                    ),
                    TopicResponse(
                            1,
                            "Lists",
                            "learn how to creates  Lists",
                            8,
                            "wrtye",
                            isLocked = false,
                            isCompleted = false
                    ),
                    TopicResponse(
                            1,
                            "Dictionary",
                            "learn how to creates  Dictionaries",
                            8,
                            "weetrry",
                            isLocked = false,
                            isCompleted = false
                    )
            )

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}