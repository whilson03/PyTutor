package com.olabode.wilson.pytutor.ui.tutorial

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentTutorialPageBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonAdapter
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_RESPONSE = "lessonResponse"

@AndroidEntryPoint
class TutorialPageFragment : Fragment(R.layout.fragment_tutorial_page) {
    private lateinit var lesson: Lesson

    companion object {

        @JvmStatic
        fun newInstance(lesson: Lesson) =
            TutorialPageFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_RESPONSE, lesson)
                }
            }
    }

    private val binding by viewBinding(FragmentTutorialPageBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            lesson = it.getParcelable(ARG_RESPONSE)!!
        }

        val adapter = LessonAdapter()
        binding.lessonsRecycler.adapter = adapter
        adapter.submitList(lesson.lessons!!.values.toList().sortedBy { it.orderKey })
    }
}