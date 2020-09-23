package com.olabode.wilson.pytutor.ui.profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.main.user.UserRepository

/**
 * Created by Ogheneruona Onobrakpeya on 9/23/20.
 */

class ProfileViewModel @ViewModelInject constructor(
        private val userRepository: UserRepository
) : ViewModel() {
    val userDetails = userRepository
            .getLoggedInUserDetails(userRepository.getUserId())
            .asLiveData()
}