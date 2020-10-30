package com.olabode.wilson.pytutor.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentHomeBinding
import com.olabode.wilson.pytutor.extensions.hide
import com.olabode.wilson.pytutor.extensions.show
import com.olabode.wilson.pytutor.extensions.showUserProgress
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.ui.profile.ProfileViewModel
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: ProfileViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        binding.cardOne.setOnClickListener {
            findNavController().navigate(
                    HomeFragmentDirections
                            .actionHomeFragmentToTutorialTopicsFragment()
            )
        }

        binding.cardTwo.setOnClickListener {
            findNavController().navigate(
                    HomeFragmentDirections
                            .actionHomeFragmentToListAlgosFragment()
            )
        }

        binding.cardThree.setOnClickListener {
            findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToExerciseListFragment()
            )
        }

        binding.cardFour.setOnClickListener {
            findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToInterpreterFragment()
            )
        }
    }

    private fun setupUserDetails(user: User) {
        binding.nameField.text = user.fullName
        binding.profileIcon.load(user.imageUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_profile_placeholder)
            transformations(RoundedCornersTransformation(25f))
            error(R.drawable.ic_profile_placeholder)
        }

        val userProgress = user.getUserProgress()
        binding.percentText.text = getString(R.string.progress_level, userProgress, "%")
        binding.progressBar.showUserProgress(userProgress)
    }
}

