package com.olabode.wilson.pytutor.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.auth.AuthRepository
import com.olabode.wilson.pytutor.repository.main.user.UserRepository

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
class HomeViewModel @ViewModelInject constructor(
        private val userRepository: UserRepository,
        private val authRepository: AuthRepository
) : ViewModel() {
    val userDetails = userRepository
            .getLoggedInUserDetails(authRepository.currentUserId())
            .asLiveData()
}