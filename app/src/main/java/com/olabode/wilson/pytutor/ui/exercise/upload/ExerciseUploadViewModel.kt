package com.olabode.wilson.pytutor.ui.exercise.upload

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.models.Exercise
import com.olabode.wilson.pytutor.models.Tag
import com.olabode.wilson.pytutor.repository.main.exercise.ExerciseRepository
import com.olabode.wilson.pytutor.repository.main.tag.TagRepository
import com.olabode.wilson.pytutor.utils.states.DataState

/**
 *   Created by OLABODE WILSON on 2/5/21.
 */
class ExerciseUploadViewModel @ViewModelInject constructor(
        private val exerciseRepository: ExerciseRepository,
        private val tagRepository: TagRepository
) : ViewModel() {


    fun getTags(): LiveData<DataState<List<Tag>>> {
        return tagRepository.getAllTags().asLiveData()
    }

    fun uploadExercise(exercise: Exercise): LiveData<DataState<String>> {
        return exerciseRepository.uploadExercise(exercise).asLiveData()
    }
}