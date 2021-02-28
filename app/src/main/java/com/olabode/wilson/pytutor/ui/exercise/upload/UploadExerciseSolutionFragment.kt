package com.olabode.wilson.pytutor.ui.exercise.upload

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.olabode.wilson.pytutor.databinding.FragmentUploadExerciseSolutionBinding
import com.olabode.wilson.pytutor.extensions.getInput
import com.olabode.wilson.pytutor.extensions.noEmptyField
import com.olabode.wilson.pytutor.extensions.snack
import com.olabode.wilson.pytutor.utils.Messages


class UploadExerciseSolutionFragment : Fragment() {

    private var _binding: FragmentUploadExerciseSolutionBinding? = null
    private val binding get() = _binding!!

    private val args: UploadExerciseSolutionFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentUploadExerciseSolutionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.next.setOnClickListener {
            if (noEmptyField(binding.editor)) {
                it.findNavController().navigate(UploadExerciseSolutionFragmentDirections
                        .actionUploadExerciseSolutionFragmentToExerciseTagsAndSubmissionFragment(
                                title = args.title, question = args.question, code = binding.editor.getInput()
                        ))
            } else {
                binding.root.snack(Messages.BLANK_FIELDS_IN_FORM)
            }

        }
    }
}