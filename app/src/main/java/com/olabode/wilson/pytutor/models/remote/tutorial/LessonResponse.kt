package com.olabode.wilson.pytutor.models.remote.tutorial

import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */


data class LessonResponse(
        val topicId: String = "",
        val page: Int,
        val lessons: Map<String, Tutorial>? = null,
        val question: Map<String, Question>? = null,
        val type: Int = LessonResponseType.LESSON.ordinal

) {

    constructor() : this(
            "", 0, null, null, LessonResponseType.LESSON.ordinal
    )
}


enum class LessonResponseType {
    LESSON, QUESTION
}
