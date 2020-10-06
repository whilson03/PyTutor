package com.olabode.wilson.pytutor.ui.tutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import com.olabode.wilson.pytutor.utils.Event
import com.olabode.wilson.pytutor.utils.LoadingState
import com.olabode.wilson.pytutor.utils.states.DataState
import timber.log.Timber

/**
 *   Created by OLABODE WILSON on 9/10/20.
 */
class TutorialLessonViewModel @ViewModelInject constructor(
    private val tutorialRepository: TutorialRepository
) : ViewModel() {

    init {
        Timber.d("TUTORIAL VIEWMODEL CREATED")
    }

    private val _showProgressBar = MutableLiveData<Event<LoadingState>>()
    val showProgressBar: LiveData<Event<LoadingState>>
        get() = _showProgressBar

    private val _showPopUpWithMessage = MutableLiveData<Event<String>>()
    val showPopUpWithMessage: LiveData<Event<String>>
        get() = _showPopUpWithMessage

    fun postPopUpMessage(message: String) {
        _showPopUpWithMessage.value = Event(message)
    }

    fun updateProgressBar(state: LoadingState) {
        _showProgressBar.value = Event(state)
    }

    fun getLessons(topicId: String): LiveData<DataState<List<Lesson>>> {
        return tutorialRepository.getLessonsForTopic(topicId).asLiveData()
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("TUTORIAL VIEWMODEL CLEARED")
    }
}