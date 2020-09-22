package com.olabode.wilson.pytutor.ui.tutorial.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.main.user.UserRepository
import com.olabode.wilson.pytutor.utils.DataState

/**
 *   Created by OLABODE WILSON on 9/22/20.
 */
class CompletedLessonViewModel @ViewModelInject constructor(
        private val userRepository: UserRepository
) : ViewModel() {

    fun onCourseCompleted(topicId: String, rating: Float): LiveData<DataState<String>> {
        return userRepository.updateCourse(topicId, rating).asLiveData()
    }
}