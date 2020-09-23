package com.olabode.wilson.pytutor.ui.auth.verification

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentVerifyPasswordBinding
import com.olabode.wilson.pytutor.extensions.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerifyPasswordFragment : Fragment(R.layout.fragment_verify_password) {
    private val binding by viewBinding(FragmentVerifyPasswordBinding::bind)

    private val viewModel: EmailVerificationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backToLogin.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}