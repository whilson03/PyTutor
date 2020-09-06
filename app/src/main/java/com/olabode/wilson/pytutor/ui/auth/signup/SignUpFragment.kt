package com.olabode.wilson.pytutor.ui.auth.signup

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.databinding.FragmentSignUpBinding
import com.olabode.wilson.pytutor.ui.auth.AuthViewModel
import com.olabode.wilson.pytutor.utils.AuthResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val authViewModel: AuthViewModel by activityViewModels()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

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
                Toast.makeText(requireContext(), "All Field Must be Filled", Toast.LENGTH_SHORT).show()
            }
        }

        binding.backToLogin.setOnClickListener {
            findNavController().navigateUp()
        }
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
                    Toast.makeText(requireContext(), result.data, Toast.LENGTH_SHORT).show()
                    binding.progressBar.isVisible = false
                    binding.signIn.isClickable = true
                }

                is AuthResult.Success -> {
                    binding.progressBar.isVisible = false
                    binding.signIn.isClickable = true
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
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