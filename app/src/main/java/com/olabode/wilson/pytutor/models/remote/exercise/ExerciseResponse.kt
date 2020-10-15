package com.olabode.wilson.pytutor.models.remote.exercise

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */
data class ExerciseResponse(
        val id: String,
        val title: String,
        val difficulty: Int = DIFFICULTY.EASY.ordinal,
        val question: String,
        val solution: String
) {
    constructor() : this("", "", DIFFICULTY.EASY.ordinal, "", "")
}

enum class DIFFICULTY {
    EASY, MEDIUM, CHALLENGING
}