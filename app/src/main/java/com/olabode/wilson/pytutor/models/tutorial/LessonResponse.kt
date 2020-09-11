package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */

@Parcelize
data class LessonResponse(
        val page: Int,
        val lessons: Map<String, Lesson>? = null,
        val question: Map<String, Question>? = null,
        val type: Int = LessonResponseType.LESSON.ordinal

) : Parcelable {

    constructor() : this(
            0, null, null, LessonResponseType.LESSON.ordinal
    )
}


enum class LessonResponseType {
    LESSON, QUESTION
}
