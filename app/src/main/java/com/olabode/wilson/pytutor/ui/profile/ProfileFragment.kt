package com.olabode.wilson.pytutor.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import coil.api.load
import coil.transform.CircleCropTransformation
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentProfileBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.models.user.User
import com.olabode.wilson.pytutor.utils.AuthResult
import com.olabode.wilson.pytutor.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel: ProfileViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userDetails.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Success -> {
                    setUpProfile(result.data)
                }
            }
        })


        binding.signOut.setOnClickListener {
            //  logOut()
        }

        binding.navigateToRate.setOnClickListener {

        }

        binding.navigatePrivacy.setOnClickListener {

        }

        binding.achievement.setOnClickListener {

        }

        binding.editProfile.setOnClickListener {

        }

    }

    private fun setUpProfile(user: User) {
        binding.username.text = user.fullName
        binding.profileIcon.load(user.imageUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_profile_placeholder)
            transformations(CircleCropTransformation())
            error(R.drawable.ic_profile_placeholder)
        }
    }


    private fun logOut() {
        viewModel.signOut().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is AuthResult.Success -> {

                }

                is AuthResult.Failed -> {

                }

                is AuthResult.Loading -> {

                }
            }

        })
    }
}