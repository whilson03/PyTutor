package com.olabode.wilson.pytutor.ui.auth.signup

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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
import com.olabode.wilson.pytutor.ui.auth.AuthViewModel
import com.olabode.wilson.pytutor.utils.EventObserver
import com.olabode.wilson.pytutor.utils.Messages
import com.olabode.wilson.pytutor.utils.states.AuthResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val authViewModel: AuthViewModel by activityViewModels()
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
            uiCommunicator.hideSoftKeyBoard()
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
                    binding.progressBar.root.show()
                    binding.signIn.disableClick()
                }

                is AuthResult.Failed -> {
                    authViewModel.snackBarMessage(result.data)
                    binding.progressBar.root.hide()
                    binding.signIn.enableClick()
                }

                is AuthResult.Success -> {
                    binding.progressBar.root.show()
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