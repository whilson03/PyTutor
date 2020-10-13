package com.olabode.wilson.pytutor.models.remote.exercise

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */
data class ExerciseResponse (
    val id: String,
    val title: String,
    val difficulty: String,
    val question: String,
    val solution: String
)