package com.olabode.wilson.pytutor.files.lessons

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/10/20.
 */

val introduction = listOf(
    LessonResponse(
        "IJECZPSWPRCDWYVfkRCc",
        1,
        lessons = mapOf(
            "1" to Tutorial(
                1,
                "",
                "Python is a general-purpose interpreted, interactive, object-oriented, and high-level scripting programming language.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to Tutorial(
                2,
                "",
                "It was created by Guido van Rossum during 1985 – 1990.",
                null,
                LessonTypes.TEXT.ordinal

            ),

            "3" to Tutorial(
                3,
                "",
                "Python is named after a TV Show called ‘Monty Python’s Flying Circus’.",
                null,
                LessonTypes.TEXT.ordinal

            ),

            "4" to Tutorial(
                4,
                "",
                "Some features of Python includes :",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "5" to Tutorial(
                5,
                "",
                "Readable: Python is a very readable language.",
                null,
                LessonTypes.BULLET.ordinal
            )
        ),
        question = null,
        type = LessonResponseType.LESSON.ordinal
    ),

    LessonResponse(
        "IJECZPSWPRCDWYVfkRCc",
        2,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "Cross platform: Python is available and can run on various operating systems such as Mac, Windows, Linux, Unix etc.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Open Source: Python is a open source programming language.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "Easy-to-learn: Python has few keywords, simple structure, and a clearly defined syntax.\n" +
                    "This allows the student to pick up the language quickly.\n",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "Extendable: You can add low-level modules to the Python interpreter.\n" +
                    "These modules enable programmers to add to or customize their tools to be more efficient.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "Apart from the above-mentioned features, Python has a big list of good features.",
                null,
                LessonTypes.TEXT.ordinal
            )
        )
    ),

    LessonResponse(
        "IJECZPSWPRCDWYVfkRCc",
        3,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "Some uses of Python includes: ",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Web development: Web frameworks like Django and Flask are based on Python. They help you write server side code which helps you manage database, write \n" +
                    " backend programming logic, mapping urls etc.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "Desktop GUI: Python can be used to program desktop applications. It provides the Tkinter library that can be used to develop user interfaces." +
                    " There are some other useful toolkits such as Kivy, PYQT that can be used to create applications on several platforms.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "Scripting: Scripting is writing small programs to automate simple tasks such as sending automated response emails etc." +
                    " Such type of applications can also be written in Python programming language.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "Machine Learning and Artificial Intelligence: Machine learning is a way to write a logic so that a machine can learn and solve a particular problem on its own. " +
                    " Libraries such as  Pandas, Scikit-Learn, NumPy are used for developing AI based applications in Python.",
                null,
                LessonTypes.BULLET.ordinal
            )
        ),
        question = null,
        type = LessonResponseType.LESSON.ordinal
    ),

    LessonResponse(
        "IJECZPSWPRCDWYVfkRCc",
        4,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "Data Science and Data Analysis: Python can be used to study the data, extract relevant information from datasets and perform various operations or take certain decisions based on the extracted data.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Game Development: Python is also used in the development of interactive games." +
                    "Libraries such as PySoy which is a 3D game engine supporting Python 3, PyGame which provides functionality and a library for game development." +
                    "Some games built in Python are Civilization-IV, Battlefield 2, The Sims 4, Vega Strike, Mount & Blade etc.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "Web Scraping Applications: Python can be used to extract a large amount of data from websites which can then be helpful in various real-world processes such as price comparison, job listings, research and development and much more. ",
                null,
                LessonTypes.BULLET.ordinal
            )
        )
    ),

    LessonResponse(
        "IJECZPSWPRCDWYVfkRCc",
        5,
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
                    "2" to "Difficulty to learn",
                    "3" to "Cross-platform"
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