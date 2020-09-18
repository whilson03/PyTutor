package com.olabode.wilson.pytutor.models.cache.tutorial

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.models.tutorial.Question

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

@Entity(tableName = "LessonResponse")
data class Lesson(
        @ColumnInfo(name = "page")
        val page: Int,

        @ColumnInfo(name = "lessons")
        val lessons: Map<String, Lesson>? = null,

        @ColumnInfo(name = "questions")
        val question: Map<String, Question>? = null,

        @ColumnInfo(name = "type")
        val type: Int = LessonResponseType.LESSON.ordinal
)