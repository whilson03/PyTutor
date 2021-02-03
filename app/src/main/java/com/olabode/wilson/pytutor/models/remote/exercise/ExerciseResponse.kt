package com.olabode.wilson.pytutor.models.remote.exercise

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */
data class ExerciseResponse(
        var id: String = "",
        val title: String,
        val difficulty: Int = DIFFICULTY.EASY.ordinal,
        val question: String,
        val solution: String,
        val postedBy: String = "Pytutor",
        val tags: Map<Int, String> = mapOf(),
        @ServerTimestamp
        val datePosted: Date? = null
) {
    constructor() : this(
            "",
            "",
            DIFFICULTY.EASY.ordinal,
            "",
            "",
            "Pytutor",
            mapOf(),
            null
    )
}

enum class DIFFICULTY {
    EASY, MEDIUM, HARD
}
