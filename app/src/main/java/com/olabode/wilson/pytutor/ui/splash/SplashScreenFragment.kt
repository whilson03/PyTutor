package com.olabode.wilson.pytutor.ui.splash

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentSplashScreenBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.utils.Constants
import com.olabode.wilson.pytutor.utils.states.AuthResult
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {

    @Inject
    lateinit var preferences: SharedPreferences
    private val binding by viewBinding(FragmentSplashScreenBinding::bind)
    private val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            context?.let {
                setupUI()
            }
        }, 2500)
    }

    private fun observeAuthState() {
        viewModel.userStatus.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is AuthResult.Failed -> {
                    findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToAuthNavigation())
                }

                is AuthResult.Success -> {
                    findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToHomeFragment())
                }
            }
        })
    }

    private fun setupUI() {
        if (preferences.getBoolean(Constants.IS_FIRST_TIME_USER_KEY, true)) {
            findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToOnBoardingFragment())
        } else {
            observeAuthState()
        }
    }
}