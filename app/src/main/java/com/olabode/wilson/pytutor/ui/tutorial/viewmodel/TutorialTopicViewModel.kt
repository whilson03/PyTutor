package com.olabode.wilson.pytutor.ui.tutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import com.olabode.wilson.pytutor.repository.main.user.UserRepository
import timber.log.Timber

/**
 *   Created by OLABODE WILSON on 9/10/20.
 */
class TutorialTopicViewModel @ViewModelInject constructor(
        tutorialRepository: TutorialRepository,
        userRepository: UserRepository)
    : ViewModel() {

    val retrievedTopics = tutorialRepository.retrieveTopicsFromRemote(userRepository.getUserId()).asLiveData()

    val topics = tutorialRepository.getAllCachedTopics().asLiveData()


    override fun onCleared() {
        super.onCleared()
        Timber.d("cleared")
    }
}