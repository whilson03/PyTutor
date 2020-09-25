package com.olabode.wilson.pytutor.ui.home

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.api.load
import coil.transform.CircleCropTransformation
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentHomeBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.ui.profile.ProfileViewModel
import com.olabode.wilson.pytutor.utils.DataState
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
                    binding.nameField.visibility = View.VISIBLE
                    setupUserDetails(result.data)
                }
                is DataState.Error -> {
                    binding.nameField.visibility = View.INVISIBLE
                    Toast.makeText(requireContext(), "Failed To Retrieve User Details", Toast.LENGTH_SHORT).show()
                }
            }

        })

        binding.cardOne.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections
                    .actionHomeFragmentToTutorialTopicsFragment())
        }

        binding.cardTwo.setOnClickListener {

        }
    }


    private fun setupUserDetails(user: User) {
        binding.nameField.text = user.fullName
        binding.profileIcon.load(user.imageUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_profile_placeholder)
            transformations(CircleCropTransformation())
            error(R.drawable.ic_profile_placeholder)
        }

        val userProgress = getUserProgress(user).toInt()
        binding.percentText.text = getString(R.string.progress_level, userProgress, "%")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.progressBar.setProgress(userProgress, true)
        } else {
            binding.progressBar.progress = userProgress
        }
    }

    private fun getUserProgress(user: User): Float {
        // Convert completed lessons to percentage
        return 100 / 18f * user.completedCourses.size
    }
}

