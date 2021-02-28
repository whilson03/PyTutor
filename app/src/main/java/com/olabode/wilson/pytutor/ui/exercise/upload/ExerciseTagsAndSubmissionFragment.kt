package com.olabode.wilson.pytutor.ui.exercise.upload

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentExerciseTagsAndSubmissionBinding
import com.olabode.wilson.pytutor.extensions.hide
import com.olabode.wilson.pytutor.extensions.show
import com.olabode.wilson.pytutor.extensions.showPersistentSnackBar
import com.olabode.wilson.pytutor.models.Exercise
import com.olabode.wilson.pytutor.ui.base.BaseFragment
import com.olabode.wilson.pytutor.utils.Messages
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseTagsAndSubmissionFragment : BaseFragment<FragmentExerciseTagsAndSubmissionBinding, ExerciseUploadViewModel>() {

    private val args: ExerciseTagsAndSubmissionFragmentArgs by navArgs()

    override val viewModel: ExerciseUploadViewModel by viewModels()

    override fun getViewBinding(
            inflater: LayoutInflater,
            container: ViewGroup?
    ): FragmentExerciseTagsAndSubmissionBinding = FragmentExerciseTagsAndSubmissionBinding
            .inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showTags()

        binding.submit.setOnClickListener {

        }
    }

    private fun showTags() {
        viewModel.getTags().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Loading -> {
                    binding.mainPage.hide()
                    binding.progressBar.show()

                }
                is DataState.Success -> {
                    binding.progressBar.hide()
                    addTagChips(binding.tags, result.data.map { it.title })
                }
                is DataState.Error -> {
                    binding.progressBar.hide()
                    binding.mainPage.hide()
                }
            }
        })
    }

    private fun submit(exercise: Exercise) {
        viewModel.uploadExercise(exercise).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Loading -> {
                    binding.progressBar.show()
                }
                is DataState.Success -> {
                    binding.progressBar.hide()
                }
                is DataState.Error -> {
                    binding.progressBar.hide()
                    binding.root.showPersistentSnackBar(Messages.UPLOAD_FAILED_MESSAGE, getString(R.string.retry)) {
                        submit(exercise)
                    }
                }
            }
        })
    }


    private fun addTagChips(chipGroup: ChipGroup, items: List<String>) {
        items.forEach {
            val chip = Chip(requireContext())
            chip.text = it
            chipGroup.addView(chip)
        }
    }
}