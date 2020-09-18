package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */

@Entity(tableName = "LessonResponse")
@Parcelize
data class LessonResponse(
        @ColumnInfo(name = "page")
        val page: Int,

        @ColumnInfo(name = "lessons")
        val lessons: Map<String, Lesson>? = null,

        @ColumnInfo(name = "questions")
        val question: Map<String, Question>? = null,

        @ColumnInfo(name = "type")
        val type: Int = LessonResponseType.LESSON.ordinal

) : Parcelable {

    constructor() : this(
            0, null, null, LessonResponseType.LESSON.ordinal
    )
}


enum class LessonResponseType {
    LESSON, QUESTION
}
