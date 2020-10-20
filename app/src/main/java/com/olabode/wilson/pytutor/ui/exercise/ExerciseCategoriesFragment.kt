package com.olabode.wilson.pytutor.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentExerciseCategoriesBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ogheneruona Onobrakpeya on 10/20/20.
 */

@AndroidEntryPoint
class ExerciseCategoriesFragment : Fragment(R.layout.fragment_exercise_categories) {
    private val binding by viewBinding(FragmentExerciseCategoriesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
    }
}