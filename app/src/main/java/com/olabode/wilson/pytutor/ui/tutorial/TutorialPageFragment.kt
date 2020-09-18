package com.olabode.wilson.pytutor.ui.tutorial

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentTutorialPageBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonAdapter
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_RESPONSE = "lessonResponse"

@AndroidEntryPoint
class TutorialPageFragment : Fragment(R.layout.fragment_tutorial_page) {
    private lateinit var lessonResponse: LessonResponse

    companion object {

        @JvmStatic
        fun newInstance(lessonResponse: LessonResponse) =
                TutorialPageFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(ARG_RESPONSE, lessonResponse)
                    }
                }
    }

    private val binding by viewBinding(FragmentTutorialPageBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            lessonResponse = it.getParcelable(ARG_RESPONSE)!!
        }

        val adapter = LessonAdapter()
        binding.lessonsRecycler.adapter = adapter
        adapter.submitList(lessonResponse.lessons!!.values.toList())
    }
}