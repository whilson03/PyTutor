package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.tutorial.*
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/12/20.
 */


val template = listOf(
        LessonResponse(
                1,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
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
                2,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
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
                3,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                null,
                                LessonTypes.BULLET.ordinal
                        )
                )
        ),

        LessonResponse(
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