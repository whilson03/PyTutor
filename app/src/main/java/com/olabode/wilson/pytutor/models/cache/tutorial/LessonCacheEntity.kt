package com.olabode.wilson.pytutor.models.cache.tutorial

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

@Entity(tableName = "lesson_table")
data class LessonCacheEntity(

    @PrimaryKey(autoGenerate = true)
    val lessonId: Long,

    @ColumnInfo(name = "topic_id")
    val topicId: String,

    @ColumnInfo(name = "page")
    val page: Int,

    @ColumnInfo(name = "lessons")
    val lessons: Map<String, Tutorial>? = null,

    @ColumnInfo(name = "questions")
    val question: Map<String, Question>? = null,

    @ColumnInfo(name = "type")
    val type: Int = LessonResponseType.LESSON.ordinal
)
