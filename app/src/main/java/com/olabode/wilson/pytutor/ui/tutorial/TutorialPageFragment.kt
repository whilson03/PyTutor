package com.olabode.wilson.pytutor.ui.tutorial

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentTutorialPageBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.tutorial.LessonResponse
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonAdapter
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "param1"

@AndroidEntryPoint
class TutorialPageFragment : Fragment(R.layout.fragment_tutorial_page) {
    private var param1: LessonResponse? = null

    companion object {

        @JvmStatic
        fun newInstance(param1: LessonResponse) =
                TutorialPageFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(ARG_PARAM1, param1)
                    }
                }
    }

    private val binding by viewBinding(FragmentTutorialPageBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1)
        }

        val adapter = LessonAdapter()
        binding.lessonsRecycler.adapter = adapter
        adapter.submitList(param1!!.lessons!!.values.toList())
    }
}