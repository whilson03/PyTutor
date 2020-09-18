package com.olabode.wilson.pytutor.ui.tutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import timber.log.Timber

/**
 *   Created by OLABODE WILSON on 9/10/20.
 */
class TutorialTopicViewModel @ViewModelInject constructor(
        tutorialRepository: TutorialRepository)
    : ViewModel() {

    val topics = tutorialRepository.getAllTopics().asLiveData()

    override fun onCleared() {
        super.onCleared()
        Timber.d("cleared")
    }
}