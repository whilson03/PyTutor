package com.olabode.wilson.pytutor.models.remote.tutorial

import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial

/**
 *   Created by OLABODE WILSON on 9/8/20.
 */


data class LessonResponse(
        var topicId: String = "",
        var page: Int,
        var lessons: Map<String, Tutorial>? = null,
        var question: Map<String, Question>? = null,
        var type: Int = LessonResponseType.LESSON.ordinal

) {

    constructor() : this(
            "", 0, null, null, LessonResponseType.LESSON.ordinal
    )
}


enum class LessonResponseType {
    LESSON, QUESTION
}
