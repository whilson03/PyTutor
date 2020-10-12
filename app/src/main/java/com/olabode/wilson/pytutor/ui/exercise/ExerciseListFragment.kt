package com.olabode.wilson.pytutor.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentExerciseListBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.Exercise

/**
 * Created by Ogheneruona Onobrakpeya on 10/10/20.
 */
class ExerciseListFragment : Fragment(R.layout.fragment_exercise_list) {
    private val binding by viewBinding(FragmentExerciseListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.isVisible = false

        val exerciseListAdapter = ExerciseListAdapter {exercise ->
            findNavController().
            navigate(ExerciseListFragmentDirections.actionExerciseListFragmentToExerciseFragment(exercise))
        }

        binding.exerciseListRecycler.adapter = exerciseListAdapter
        binding.exerciseListRecycler.isVisible = true
        exerciseListAdapter.submitList(getDummyList())
        binding.toolbar.setNavigationOnClickListener {findNavController().navigateUp()}
    }

    fun getDummyList() : List<Exercise> {
        return listOf(
                Exercise("1", "Adding", "Easy", "Add These", "Add Add"),
                Exercise("1", "Subtracting", "Medium", "Subtract These", "Add Add"),
                Exercise("1", "Dividing", "Hard", "Divide These", "Add Add")
        )
    }
}