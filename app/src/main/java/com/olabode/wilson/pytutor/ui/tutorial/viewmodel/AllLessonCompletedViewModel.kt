package com.olabode.wilson.pytutor.ui.tutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.main.user.UserRepository
import com.olabode.wilson.pytutor.utils.states.DataState

/**
 *   Created by OLABODE WILSON on 11/6/20.
 */
class AllLessonCompletedViewModel @ViewModelInject constructor(
        private val userRepository: UserRepository
) : ViewModel() {
    fun onLastTopicCompleted(
            topicId: String,
            rating: Float,
            nextTopicId: String?
    ): LiveData<DataState<String>> {
        return userRepository.updateCourse(topicId, rating, nextTopicId).asLiveData()
    }

}