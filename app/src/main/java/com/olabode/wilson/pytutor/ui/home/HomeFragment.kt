package com.olabode.wilson.pytutor.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.api.load
import coil.transform.CircleCropTransformation
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentHomeBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userDetails.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Success -> setupUserDetails(result.data)
                is DataState.Error -> {
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
        }
    }
}

