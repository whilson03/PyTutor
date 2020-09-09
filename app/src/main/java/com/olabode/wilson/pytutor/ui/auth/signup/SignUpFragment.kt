package com.olabode.wilson.pytutor.ui.auth.signup

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentSignUpBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.ui.auth.AuthViewModel
import com.olabode.wilson.pytutor.utils.AuthResult
import com.olabode.wilson.pytutor.utils.EventObserver
import com.olabode.wilson.pytutor.utils.Messages
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val authViewModel: AuthViewModel by activityViewModels()
    private val binding by viewBinding(FragmentSignUpBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signIn.setOnClickListener {
            if (validateDetails()) {
                performRegistration(
                        binding.nameField.text.toString().trim(),
                        binding.emailField.text.toString().trim(),
                        binding.passwordField.text.toString().trim(),
                        binding.confirmPasswordField.text.toString().trim()
                )
            } else {
                authViewModel.snackBarMessage(Messages.ALERT_BLANK_FIELDS)
            }
        }

        binding.backToLogin.setOnClickListener {
            findNavController().navigateUp()
        }

        authViewModel.showSnackBar.observe(viewLifecycleOwner, EventObserver {
            Snackbar.make(binding.coordinatorLayout, it, Snackbar.LENGTH_LONG).show()
        })
    }


    private fun performRegistration(
            fullName: String,
            email: String,
            password: String,
            confirmPassword: String
    ) {
        authViewModel.registerNewUser(
                fullName,
                email,
                password,
                confirmPassword
        ).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is AuthResult.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.signIn.isClickable = false
                }

                is AuthResult.Failed -> {
                    authViewModel.snackBarMessage(result.data)
                    binding.progressBar.isVisible = false
                    binding.signIn.isClickable = true
                }

                is AuthResult.Success -> {
                    binding.progressBar.isVisible = false
                    binding.signIn.isClickable = true
                    authViewModel.snackBarMessage(result.data)
                }
            }
        })

    }


    private fun validateDetails(): Boolean {
        return !(TextUtils.isEmpty(binding.nameField.text.toString().trim())
                || TextUtils.isEmpty(binding.passwordField.text.toString().trim())
                || TextUtils.isEmpty(binding.confirmPasswordField.text.toString().trim())
                || TextUtils.isEmpty(binding.emailField.text.toString().trim()))
    }
}