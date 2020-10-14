package com.olabode.wilson.pytutor.ui.exercise

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.olabode.wilson.pytutor.repository.main.exercise.ExerciseRepository

/**
 * Created by Ogheneruona Onobrakpeya on 10/14/20.
 */

class ExercisesViewModel @ViewModelInject constructor(
    private val exerciseRepository: ExerciseRepository
) : ViewModel() {

    val exercises = exerciseRepository
        .fetchExercises()
        .asLiveData()
}