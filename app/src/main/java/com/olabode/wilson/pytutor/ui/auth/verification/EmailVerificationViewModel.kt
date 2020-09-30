package com.olabode.wilson.pytutor.ui.auth.verification

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.auth.AuthRepository
import com.olabode.wilson.pytutor.utils.DataState

/**
 *   Created by OLABODE WILSON on 9/23/20.
 */
class EmailVerificationViewModel @ViewModelInject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    fun resendVerificationLink(email: String, password: String): LiveData<DataState<String>> {
        return authRepository.sendEmailVerificationLink(email, password).asLiveData()
    }
}