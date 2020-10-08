package com.olabode.wilson.pytutor.ui.auth.login

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.olabode.wilson.pytutor.AuthNavigationDirections
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.UICommunicator
import com.olabode.wilson.pytutor.databinding.FragmentLoginBinding
import com.olabode.wilson.pytutor.extensions.disableClick
import com.olabode.wilson.pytutor.extensions.enableClick
import com.olabode.wilson.pytutor.extensions.hide
import com.olabode.wilson.pytutor.extensions.show
import com.olabode.wilson.pytutor.extensions.viewBinding
import com.olabode.wilson.pytutor.ui.auth.AuthUtils
import com.olabode.wilson.pytutor.ui.auth.AuthViewModel
import com.olabode.wilson.pytutor.ui.auth.ValidationStates
import com.olabode.wilson.pytutor.utils.EventObserver
import com.olabode.wilson.pytutor.utils.states.AuthResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val authViewModel: AuthViewModel by activityViewModels()
    private val binding by viewBinding(FragmentLoginBinding::bind)
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

        authViewModel.showSnackBar.observe(viewLifecycleOwner, EventObserver {
            Snackbar.make(binding.coordinatorLayout, it, Snackbar.LENGTH_LONG).show()
        })

        binding.createAccount.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections
                    .actionLoginFragmentToSignUpFragment2()
            )
        }

        binding.signIn.setOnClickListener {
            uiCommunicator.hideSoftKeyBoard()
            val email = binding.emailField.text.toString().trim()
            val password = binding.passwordField.text.toString().trim()

            when (val result = AuthUtils.validateLoginDetails(email, password)) {
                is ValidationStates.Success -> {
                    performLogin(email, password)
                }
                is ValidationStates.Error -> {
                    authViewModel.snackBarMessage(result.message)
                }
            }
        }

        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToResetPasswordFragment())
        }
    }

    private fun performLogin(email: String, password: String) {
        authViewModel.loginUser(email, password).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is AuthResult.Loading -> {
                    binding.signIn.disableClick()
                    binding.progressLayout.root.show()
                }

                is AuthResult.Failed -> {
                    authViewModel.snackBarMessage(result.data)
                    binding.signIn.enableClick()
                    binding.progressLayout.root.hide()
                }

                is AuthResult.Success -> {
                    binding.progressLayout.root.hide()
                    authViewModel.snackBarMessage(result.data)
                    findNavController().navigate(AuthNavigationDirections.actionGlobalHomeFragment())
                }

                is AuthResult.UnAuthenticated -> {
                    findNavController()
                        .navigate(
                            LoginFragmentDirections
                                .actionLoginFragmentToVerifyPasswordFragment()
                        )
                }
            }
        })
    }
}