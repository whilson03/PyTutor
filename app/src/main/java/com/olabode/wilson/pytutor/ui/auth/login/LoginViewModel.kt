package com.olabode.wilson.pytutor.ui.auth.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.auth.AuthRepository
import com.olabode.wilson.pytutor.utils.Event
import com.olabode.wilson.pytutor.utils.states.AuthResult

/**
 *   Created by OLABODE WILSON on 10/8/20.
 */
class LoginViewModel @ViewModelInject constructor(
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
}