package com.olabode.wilson.pytutor.ui.tutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import com.olabode.wilson.pytutor.utils.DataState
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

    fun getLessons(topicId: String): LiveData<DataState<List<LessonResponse>>> {
        return tutorialRepository.getLessonsForTopic(topicId).asLiveData()
    }


    override fun onCleared() {
        super.onCleared()
        Timber.d("TUTORIAL VIEWMODEL CLEARED")
    }
}