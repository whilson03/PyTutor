package com.olabode.wilson.pytutor.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.olabode.wilson.pytutor.repository.main.UserRepository

/**
 *   Created by OLABODE WILSON on 9/6/20.
 */
class HomeViewModel @ViewModelInject constructor(
        private val userRepository: UserRepository
) : ViewModel() {
    val userStatus = userRepository.checkLoginStatus()
}