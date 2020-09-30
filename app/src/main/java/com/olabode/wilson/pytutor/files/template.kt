package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/12/20.
 */

val template = listOf(
    LessonResponse(
        "",
        1,
        lessons = mapOf(
            "1" to Tutorial(
                1,
                "",
                "`Break Statement`",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to Tutorial(
                2,
                "",
                "",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to Tutorial(
                3,
                "",
                "",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "4" to Tutorial(
                4,
                "",
                "",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "5" to Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    header = "",
                    footer = "",
                    code = ""
                ),
                LessonTypes.CODE.ordinal
            )
        )
    ),

    LessonResponse(
        "",
        2,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                null,
                LessonTypes.BULLET.ordinal
            )
        ),
        question = null,
        type = LessonResponseType.LESSON.ordinal
    ),

    LessonResponse(
        "",
        3,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                null,
                LessonTypes.BULLET.ordinal
            )
        )
    ),

    LessonResponse(
        "",
        4,
        lessons = null,
        question = mapOf(
            "1" to Question(
                question = "",
                options = mapOf(
                    "1" to "",
                    "2" to "",
                    "3" to ""
                ),
                answerKey = ""
            ),

            "2" to Question(
                question = "",
                options = mapOf(
                    "1" to "",
                    "2" to "",
                    "3" to ""
                ),
                answerKey = ""
            ),
            "3" to Question(
                question = "",
                options = mapOf(
                    "1" to "",
                    "2" to "",
                    "3" to ""
                ),
                answerKey = ""
            ),

            "4" to Question(
                question = "",
                options = mapOf(
                    "1" to "",
                    "2" to "",
                    "3" to ""
                ),
                answerKey = "2"
            ),
            "5" to Question(
                question = "",
                options = mapOf(
                    "1" to "",
                    "2" to "",
                    "3" to ""
                ),
                answerKey = ""
            )
        ),
        type = LessonResponseType.QUESTION.ordinal
    )
)