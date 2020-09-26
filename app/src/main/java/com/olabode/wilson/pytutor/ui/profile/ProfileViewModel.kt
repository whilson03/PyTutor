package com.olabode.wilson.pytutor.ui.profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.olabode.wilson.pytutor.repository.auth.AuthRepository
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import com.olabode.wilson.pytutor.repository.main.user.UserRepository
import kotlinx.coroutines.launch

/**
 * Created by Ogheneruona Onobrakpeya on 9/23/20.
 */

class ProfileViewModel @ViewModelInject constructor(
        private val userRepository: UserRepository,
        private val authRepository: AuthRepository,
        private val tutorialRepository: TutorialRepository
) : ViewModel() {
    val userDetails = userRepository
            .getLoggedInUserDetails(userRepository.getUserId())
            .asLiveData()

    val authState = userRepository.checkLoginStatus()

    fun signOut() {
        viewModelScope.launch {
            tutorialRepository.clearTopics()
        }

        authRepository.logOut()

    }
}