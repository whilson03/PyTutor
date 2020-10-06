package com.olabode.wilson.pytutor.ui.auth.resetpassword

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.auth.AuthRepository
import com.olabode.wilson.pytutor.utils.states.DataState

/**
 *   Created by OLABODE WILSON on 9/23/20.
 */
class ResetPasswordViewModel @ViewModelInject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    fun resetPassword(email: String): LiveData<DataState<String>> {
        return authRepository.sendPasswordResetLink(email).asLiveData()
    }
}