package com.olabode.wilson.pytutor.repository.main.exercise

import com.olabode.wilson.pytutor.models.Exercise
import com.olabode.wilson.pytutor.utils.states.DataState
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */

interface ExerciseRepository {
    fun fetchExercises(): Flow<DataState<List<Exercise>>>

    fun refresh(): Unit

}