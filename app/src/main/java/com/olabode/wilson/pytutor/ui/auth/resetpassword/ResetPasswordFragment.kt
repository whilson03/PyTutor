package com.olabode.wilson.pytutor.ui.auth.resetpassword

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.UICommunicator
import com.olabode.wilson.pytutor.databinding.FragmentResetPasswordBinding
import com.olabode.wilson.pytutor.extensions.*
import com.olabode.wilson.pytutor.utils.states.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : Fragment(R.layout.fragment_reset_password) {
    private val binding by viewBinding(FragmentResetPasswordBinding::bind)
    private val viewModel: ResetPasswordViewModel by viewModels()
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

        binding.backToLogin.setOnClickListener {
            uiCommunicator.hideSoftKeyBoard()
            findNavController().navigateUp()
        }

        binding.resetPassword.setOnClickListener {
            uiCommunicator.hideSoftKeyBoard()
            val email = binding.emailField.text.toString().trim()
            if (!TextUtils.isEmpty(email)) {
                resetPassword(email)
            }
        }
    }

    private fun resetPassword(email: String) {
        viewModel.resetPassword(email).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is DataState.Loading -> {
                    binding.progressBarLayout.root.show()
                    binding.resetPassword.disableClick()
                }

                is DataState.Success -> {
                    binding.progressBarLayout.root.hide()
                    binding.resetPassword.enableClick()
                    uiCommunicator.onNewSnackBarMessage(result.data)
                    findNavController().navigateUp()
                }

                is DataState.Error -> {
                    binding.progressBarLayout.root.hide()
                    binding.resetPassword.enableClick()
                    showSnackBar(result.message)
                }
            }
        })
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(binding.coordinatorLayout, message, Snackbar.LENGTH_SHORT).show()
    }
}