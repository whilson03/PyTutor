package com.olabode.wilson.pytutor.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentExerciseListBinding
import com.olabode.wilson.pytutor.extensions.hide
import com.olabode.wilson.pytutor.extensions.show
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.files.exercises.listOfExercises
import com.olabode.wilson.pytutor.mappers.exercise.ExerciseNetworkMapper
import com.olabode.wilson.pytutor.models.Exercise
import com.olabode.wilson.pytutor.utils.navigateSafe
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ogheneruona Onobrakpeya on 10/10/20.
 */

@AndroidEntryPoint
class ExerciseListFragment : Fragment(R.layout.fragment_exercise_list) {
    private val binding by viewBinding(FragmentExerciseListBinding::bind)
    private val viewModel: ExercisesViewModel by viewModels()
    private lateinit var adapter: ExerciseListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ExerciseListAdapter { exercise ->
            navigateSafe(ExerciseListFragmentDirections
                    .actionExerciseListFragmentToExerciseFragment(exercise))
        }

        binding.exerciseListRecycler.adapter = adapter
        binding.progressBar.isVisible = false
        binding.exerciseListRecycler.isVisible = true
        adapter.submitList(getDummyList())
        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
//        setupObserver()
    }

    private fun setupObserver() {
        viewModel.exercises.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Loading -> {
                    binding.progressBar.show()
                    binding.noInternetState.root.hide()
                }

                is DataState.Success -> {
                    binding.progressBar.hide()
                    binding.mainPage.show()
                    binding.noInternetState.root.hide()
                    adapter.submitList(result.data)
                }

                is DataState.Error -> {
                    binding.progressBar.hide()
                    binding.noInternetState.root.show()
                    binding.mainPage.hide()
                }
            }
        })
    }

    private fun getDummyList(): List<Exercise> {
        val exerciseNetworkMapper = ExerciseNetworkMapper()
        return listOfExercises().map { (exerciseNetworkMapper.mapFromEntity(it)) }
    }
}