package com.olabode.wilson.pytutor.ui.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.olabode.wilson.pytutor.repository.auth.AuthRepository
import com.olabode.wilson.pytutor.repository.main.user.UserRepository

/**
 *   Created by OLABODE WILSON on 9/21/20.
 */

class SplashViewModel @ViewModelInject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    val userStatus = userRepository.checkLoginStatus()
}