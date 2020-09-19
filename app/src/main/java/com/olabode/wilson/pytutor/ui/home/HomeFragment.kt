package com.olabode.wilson.pytutor.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentHomeBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.utils.AuthResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAuthState()

        binding.cardOne.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections
                    .actionHomeFragmentToTutorialTopicsFragment())
        }

        binding.cardTwo.setOnClickListener {

        }
    }


    private fun observeAuthState() {
        viewModel.userStatus.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is AuthResult.Failed -> {
                    findNavController()
                            .navigate(HomeFragmentDirections.actionHomeFragmentToAuthNavigation())
                }
            }
        })
    }
}

