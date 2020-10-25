package com.olabode.wilson.pytutor.models.remote.exercise

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */
data class ExerciseResponse(
        val id: String = "",
        val title: String,
        val category: Int = CATEGORY.BASICS.ordinal,
        val question: String,
        val solution: String
) {
    constructor() : this("", "", CATEGORY.BASICS.ordinal, "", "")
}

enum class CATEGORY {
    BASICS, FLOW_CONTROL, FUNCTIONS, DATA_STRUCTURES
}