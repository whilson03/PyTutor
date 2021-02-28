package com.olabode.wilson.pytutor.ui.exercise.upload

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentAddExerciseQuestionBinding
import com.olabode.wilson.pytutor.extensions.getInput
import com.olabode.wilson.pytutor.extensions.noEmptyField
import com.olabode.wilson.pytutor.extensions.snack
import com.olabode.wilson.pytutor.utils.Messages


class ExerciseQuestionFragment : Fragment() {

    private var _binding: FragmentAddExerciseQuestionBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        _binding = FragmentAddExerciseQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        binding.next.setOnClickListener {
            with(binding) {
                if (noEmptyField(nameField, questionField)) {
                    findNavController()
                            .navigate(ExerciseQuestionFragmentDirections
                                    .actionExerciseQuestionFragmentToUploadExerciseSolutionFragment(
                                    title = nameField.getInput(), question = questionField.getInput()
                            ))
                } else {
                    binding.root.snack(Messages.BLANK_FIELDS_IN_FORM)
                }
            }

        }
    }

}