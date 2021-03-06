package com.olabode.wilson.pytutor.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentHomeBinding
import com.olabode.wilson.pytutor.extensions.hide
import com.olabode.wilson.pytutor.extensions.navigateSafe
import com.olabode.wilson.pytutor.extensions.show
import com.olabode.wilson.pytutor.extensions.showUserProgress
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.ui.base.BaseFragment
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun getViewBinding(
            inflater: LayoutInflater,
            container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        excludeLollipopInterpreter()

        viewModel.userDetails.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Success -> {
                    binding.nameField.show()
                    setupUserDetails(result.data)
                }
                is DataState.Error -> {
                    binding.nameField.hide()
                    Toast.makeText(
                            requireContext(),
                            getString(R.string.cannot_retrieve_user),
                            Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                }
            }

        })

        binding.tutorialSection.setOnClickListener {
            navigateSafe(HomeFragmentDirections.actionHomeFragmentToTutorialTopicsFragment())
        }

        binding.algorithmSection.setOnClickListener {
            navigateSafe(HomeFragmentDirections.actionHomeFragmentToListAlgosFragment())
        }

        binding.exercisesSection.setOnClickListener {
            navigateSafe(HomeFragmentDirections.actionHomeFragmentToExerciseListFragment())
        }

        binding.codeSection.setOnClickListener {
            navigateSafe(HomeFragmentDirections.actionHomeFragmentToInterpreterFragment())
        }
    }

    private fun setupUserDetails(user: User) {
        binding.nameField.text = user.fullName
        binding.profileIcon.load(user.imageUrl) {
            crossfade(false)
            placeholder(R.drawable.ic_profile_placeholder)
            transformations(RoundedCornersTransformation(25f))
            error(R.drawable.ic_profile_placeholder)
        }

        val userProgress = user.getUserProgress()
        binding.percentText.text = getString(R.string.progress_level, userProgress, "%")
        binding.progressBar.showUserProgress(userProgress)

        if (userProgress == 100) {
            binding.keepLearningMessage.text = getString(R.string.congratulations)
            binding.progressMessage.text = getString(R.string.all_lessons_completed)
        }
    }

    private fun excludeLollipopInterpreter() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            binding.codeSection.hide()
        }
    }
}

