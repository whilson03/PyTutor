package com.olabode.wilson.pytutor.models.tutorial

import android.os.Parcelable
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import kotlinx.android.parcel.Parcelize

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */

@Parcelize
data class Lesson(
    val topicId: String,
    val page: Int,
    val lessons: Map<String, Tutorial>? = null,
    val question: Map<String, Question>? = null,
    val type: Int = LessonResponseType.LESSON.ordinal
) : Parcelable