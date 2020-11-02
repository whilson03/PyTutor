package com.olabode.wilson.pytutor.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.main.user.UserRepository

/**
 *   Created by OLABODE WILSON on 11/2/20.
 */

class HomeViewModel @ViewModelInject constructor(userRepository: UserRepository) : ViewModel() {
    val userDetails = userRepository
            .getLoggedInUserDetails(userRepository.getUserId())
            .asLiveData()
}