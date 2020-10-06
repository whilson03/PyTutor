package com.olabode.wilson.pytutor.ui.tutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.repository.main.tutorial.TutorialRepository
import com.olabode.wilson.pytutor.repository.main.user.UserRepository
import com.olabode.wilson.pytutor.utils.states.DataState

/**
 *   Created by OLABODE WILSON on 9/22/20.
 */
class CompletedLessonViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository,
    private val tutorialRepository: TutorialRepository
) : ViewModel() {

    fun getNextTopic(orderKey: Int): LiveData<DataState<Topic>> {
        return tutorialRepository.getNextTopic(orderKey.plus(1)).asLiveData()
    }

    fun onCourseCompleted(
        topicId: String,
        rating: Float,
        orderKey: Int
    ): LiveData<DataState<String>> {
        return userRepository.updateCourse(topicId, rating, orderKey).asLiveData()
    }
}