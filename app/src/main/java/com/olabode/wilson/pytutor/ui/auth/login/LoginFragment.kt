package com.olabode.wilson.pytutor.ui.auth.login

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentLoginBinding
import com.olabode.wilson.pytutor.ui.auth.AuthViewModel
import com.olabode.wilson.pytutor.utils.AuthResult
import com.olabode.wilson.pytutor.utils.EventObserver
import com.olabode.wilson.pytutor.utils.Messages
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val authViewModel: AuthViewModel by activityViewModels()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel.showSnackBar.observe(viewLifecycleOwner, EventObserver {
            Snackbar.make(binding.coordinatorLayout, it, Snackbar.LENGTH_LONG).show()
        })

        binding.createAccount.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections
                    .actionLoginFragmentToSignUpFragment2())
        }

        binding.signIn.setOnClickListener {
            if (validateDetails()) {
                performLogin(
                        binding.emailField.text.toString().trim(),
                        binding.passwordField.text.toString().trim()
                )
            } else {
                authViewModel.snackBarMessage(Messages.ALERT_BLANK_FIELDS)
            }
        }
    }


    private fun performLogin(email: String, password: String) {
        val navController = findNavController()

        authViewModel.loginUser(email, password).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is AuthResult.Loading -> {
                    binding.signIn.isClickable = false
                    binding.progressBar.isVisible = true
                }

                is AuthResult.Failed -> {
                    authViewModel.snackBarMessage(result.data)
                    binding.signIn.isClickable = true
                    binding.progressBar.isVisible = false
                }

                is AuthResult.Success -> {
                    binding.signIn.isClickable = true
                    binding.progressBar.isVisible = false
                    authViewModel.snackBarMessage(result.data)
                    val startDestination = navController.graph.startDestination
                    val navOptions = NavOptions.Builder()
                            .setPopUpTo(R.id.mobile_navigation_xml, true)
                            .build()
                    navController.navigate(startDestination, null, navOptions)
                }
            }
        })
    }


    private fun validateDetails(): Boolean {
        return !(TextUtils.isEmpty(binding.passwordField.text.toString().trim())
                || TextUtils.isEmpty(binding.emailField.text.toString().trim()))
    }

}