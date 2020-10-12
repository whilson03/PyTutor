package com.olabode.wilson.pytutor.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentExerciseContentBinding
import com.olabode.wilson.pytutor.extensions.viewBinding

/**
 * Created by Ogheneruona Onobrakpeya on 10/10/20.
 */
class ExerciseFragment: Fragment(R.layout.fragment_exercise_content) {
    private val binding by viewBinding(FragmentExerciseContentBinding::bind)
    private val args: ExerciseFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exercise = args.exercise
        binding.toolbar.title = exercise.title
        binding.questionText.text = exercise.question
        binding.solutionView.setCode(
            formattedSourceCode = exercise.solution,
            language = "py",
            showLineNumbers = true
        )

        binding.showSolutionButton.setOnClickListener {
            binding.solutionView.isVisible = !binding.solutionView.isVisible
        }

        binding.toolbar.setNavigationOnClickListener {findNavController().navigateUp()}
    }
}