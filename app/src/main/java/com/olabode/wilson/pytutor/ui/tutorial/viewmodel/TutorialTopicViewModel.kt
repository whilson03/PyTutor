package com.olabode.wilson.pytutor.ui.tutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import com.olabode.wilson.pytutor.repository.main.user.UserRepository
import com.olabode.wilson.pytutor.utils.DataState
import com.olabode.wilson.pytutor.utils.Event

/**
 *   Created by OLABODE WILSON on 9/10/20.
 */
class TutorialTopicViewModel @ViewModelInject constructor(
    private val tutorialRepository: TutorialRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    val topics = tutorialRepository.getAllCachedTopics().asLiveData()

    // snack bar event
    private val _showSnackBar = MutableLiveData<Event<String>>()
    val showSnackBar: LiveData<Event<String>>
        get() = _showSnackBar

    fun showSnackBar(message: String) {
        _showSnackBar.value = Event(message)
    }

    fun fetchTopics(): LiveData<DataState<List<Topic>>> {
        return tutorialRepository.retrieveTopicsFromRemote(userRepository.getUserId()).asLiveData()
    }
}