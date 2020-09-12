package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.models.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.Question
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
                                null,
                                LessonTypes.TEXT.ordinal
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
                                question = "Who created Python?",
                                options = mapOf(
                                        "1" to "Guido Van Rossum",
                                        "2" to "James Gosling",
                                        "3" to "Dennis Ritchie"
                                ),
                                answerKey = "1"
                        ),

                        "2" to Question(
                                question = "Which of these is not a feature of Python?",
                                options = mapOf(
                                        "1" to "Readability",
                                        "2" to "Difficult to learn",
                                        "3" to "Cross platform"
                                ),
                                answerKey = "2"
                        ),
                        "3" to Question(
                                question = "Can Python be used to develop games?",
                                options = mapOf(
                                        "1" to "True",
                                        "2" to "False",
                                        "3" to "Not sure"
                                ),
                                answerKey = "1"
                        ),

                        "4" to Question(
                                question = "Python is a compiled language.",
                                options = mapOf(
                                        "1" to "True",
                                        "2" to "False",
                                        "3" to "Not sure"
                                ),
                                answerKey = "2"
                        ),
                        "5" to Question(
                                question = "In which of these fields can Python be used?",
                                options = mapOf(
                                        "1" to "Scripting, Data science",
                                        "2" to "Web development, GUI",
                                        "3" to "All of the above"
                                ),
                                answerKey = "3"
                        )
                ),
                type = LessonResponseType.QUESTION.ordinal
        )
)