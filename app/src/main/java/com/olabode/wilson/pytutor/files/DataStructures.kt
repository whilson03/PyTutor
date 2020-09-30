package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 * Created by Ogheneruona Onobrakpeya on 9/11/20.
 */

val dataStructures = listOf(
    LessonResponse(
        "",
        1,
        lessons = mapOf(
            "1" to Tutorial(
                1,
                "",
                "In programming, data structures are containers which help us to group related data together in a meaningful way.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to Tutorial(
                2,
                "",
                "They are a means of organizing data for efficient usage.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to Tutorial(
                3,
                "",
                "Python has a multitude of data structures with the major ones being lists, tuples, dictionaries and sets.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "4" to Tutorial(
                4,
                "",
                "Other examples of data structures include stacks, queues, trees and heaps.",
                null,
                LessonTypes.TEXT.ordinal
            )
        ),
        question = null,
        type = LessonResponseType.LESSON.ordinal
    ),
    LessonResponse(
        "",
        2,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "Uses of Data Structures:",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Data Structures allow programmers in managing data in the most efficient manners.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "They allow programmers to effectively make use of algorithms.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "They allow efficient use of memory and other resources.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "They are very useful when working with a huge dataset.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "Data structures are reusable.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "They allow multiple solutions for a particular problem.",
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
        lessons = null,
        question = mapOf(
            "1" to Question(
                question = "Which of these is not a data structure?",
                options = mapOf(
                    "1" to "List",
                    "2" to "Loop",
                    "3" to "Set"
                ),
                answerKey = "2"
            ),

            "2" to Question(
                question = "What is an advantage of data structures?",
                options = mapOf(
                    "1" to "Slowness",
                    "2" to "Lack of organization",
                    "3" to "Reusability"
                ),
                answerKey = "3"
            ),

            "3" to Question(
                question = "Which of these is a data structure?",
                options = mapOf(
                    "1" to "bubble",
                    "2" to "heap",
                    "3" to "thread"
                ),
                answerKey = "2"
            )
        ),
        type = LessonResponseType.QUESTION.ordinal
    )
)