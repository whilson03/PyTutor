package com.olabode.wilson.pytutor.ui.auth.signup

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.UICommunicator
import com.olabode.wilson.pytutor.databinding.FragmentSignUpBinding
import com.olabode.wilson.pytutor.extensions.disableClick
import com.olabode.wilson.pytutor.extensions.enableClick
import com.olabode.wilson.pytutor.extensions.hide
import com.olabode.wilson.pytutor.extensions.show
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.ui.auth.AuthUtils
import com.olabode.wilson.pytutor.ui.auth.SignUpViewModel
import com.olabode.wilson.pytutor.ui.auth.ValidationStates
import com.olabode.wilson.pytutor.utils.EventObserver
import com.olabode.wilson.pytutor.utils.states.AuthResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val signUpViewModel: SignUpViewModel by viewModels()
    private val binding by viewBinding(FragmentSignUpBinding::bind)
    private lateinit var uiCommunicator: UICommunicator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is UICommunicator) {
            uiCommunicator = context
        } else {
            throw RuntimeException("$context must implement UICommunicator")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signIn.setOnClickListener {
            uiCommunicator.hideSoftKeyBoard()
            val name = binding.nameField.text.toString().trim()
            val email = binding.emailField.text.toString().trim()
            val password = binding.passwordField.text.toString().trim()
            val confirmPassword = binding.confirmPasswordField.text.toString().trim()

            val result = AuthUtils.validateRegistrationDetails(
                fullName = name,
                email = email,
                password = password,
                confirmPassword = confirmPassword
            )
            when (result) {
                is ValidationStates.Success -> {
                    performRegistration(name, email, password, confirmPassword)
                }
                is ValidationStates.Error -> {
                    signUpViewModel.snackBarMessage(result.message)
                }
            }
        }

        binding.backToLogin.setOnClickListener {
            uiCommunicator.hideSoftKeyBoard()
            findNavController().navigateUp()
        }

        signUpViewModel.showSnackBar.observe(viewLifecycleOwner, EventObserver {
            Snackbar.make(binding.coordinatorLayout, it, Snackbar.LENGTH_LONG).show()
        })
    }

    private fun performRegistration(
        fullName: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        signUpViewModel.registerNewUser(
            fullName,
            email,
            password,
            confirmPassword
        ).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is AuthResult.Loading -> {
                    binding.progressBarLayout.root.show()
                    binding.signIn.disableClick()
                }

                is AuthResult.Failed -> {
                    signUpViewModel.snackBarMessage(result.data)
                    binding.progressBarLayout.root.hide()
                    binding.signIn.enableClick()
                }

                is AuthResult.Success -> {
                    binding.progressBarLayout.root.hide()
                    signUpViewModel.snackBarMessage(result.data)
                }
            }
        })
    }
}