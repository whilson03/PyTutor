package com.olabode.wilson.pytutor.ui.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.auth.AuthRepository
import com.olabode.wilson.pytutor.utils.AuthResult
import com.olabode.wilson.pytutor.utils.Event

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
class AuthViewModel @ViewModelInject constructor(
        private val authRepository: AuthRepository
) : ViewModel() {


    // snack bar event
    private val _showSnackBar = MutableLiveData<Event<String>>()
    val showSnackBar: LiveData<Event<String>>
        get() = _showSnackBar


    fun snackBarMessage(message: String) {
        _showSnackBar.value =
                Event(message)
    }


    fun loginUser(
            email: String,
            password: String
    ): LiveData<AuthResult<String>> {
        return authRepository.loginUser(email, password).asLiveData()
    }

    fun registerNewUser(
            fullName: String,
            email: String,
            password: String,
            confirmPassword: String
    ): LiveData<AuthResult<String>> {
        return authRepository.registerNewUser(fullName, email, password, confirmPassword).asLiveData()
    }

}