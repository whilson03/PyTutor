package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.models.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/10/20.
 */


//fun uploadLesson(id: String) {
//    val ref = FirebaseFirestore.getInstance()
//            .collection(RemoteDatabaseKeys.NODE_TUTORIALS)
//            .document(RemoteDatabaseKeys.DOC_LESSONS)
//            .collection(id)
//    CoroutineScope(Dispatchers.IO).launch {
//        ref.add(introduction[0])
//    }
//}


val introduction = listOf(
        LessonResponse(
                1,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "Python is a general-purpose interpreted, interactive, object-oriented, and high-level scripting programming language.\n" +
                                        "It was created by Guido van Rossum during 1985 – 1990.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "Python is named after a TV Show called ‘Monty Python’s Flying Circus’.\n" +
                                        "\n" +
                                        "Some features of python includes :",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "1. Readable: Python is a very readable language.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "2. Cross platform: Python is available and can run on various operating systems such as Mac, Windows, Linux, Unix etc.\n" +
                                        " This makes it a cross platform and portable language.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "3. Open Source: Python is a open source programming language.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "4. Easy-to-learn: Python has few keywords, simple structure, and a clearly defined syntax.\n" +
                                        " This allows the student to pick up the language quickly.\n",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "7" to Lesson(
                                7,
                                "",
                                "5. Extendable: You can add low-level modules to the Python interpreter.\n" +
                                        " These modules enable programmers to add to or customize their tools to be more efficient.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "8" to Lesson(
                                8,
                                "",
                                "Apart from the above-mentioned features, Python has a big list of good features.",
                                null,
                                LessonTypes.TEXT.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),
        LessonResponse(
                2,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "Some uses of python includes: ",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "1. Web development: Web frameworks like Django and Flask are based on Python. They help you write server side code which helps you manage database, write \n" +
                                        " backend programming logic, mapping urls etc.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "2. Desktop GUI: Python can be used to program desktop applications. It provides the Tkinter library that can be used to develop user interfaces." +
                                        " There are some other useful toolkits such as Kivy, PYQT that can be used to create applications on several platforms.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "3. Scripting: Scripting is writing small programs to automate simple tasks such as sending automated response emails etc." +
                                        " Such type of applications can also be written in Python programming language.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "4. Machine Learning and Artificial Intelligence: Machine learning is a way to write a logic so that a machine can learn and solve a particular problem on its own. " +
                                        " Libraries such as  Pandas, Scikit-Learn, NumPy are used for developing AI based applications in Python.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "5. Data Science and Data Analysis: Python can be used to study the data, extract relevant information from datasets and perform various operations or take certain decisions based on the extracted data.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "7" to Lesson(
                                7,
                                "",
                                "6. Game Development: Python is also used in the development of interactive games." +
                                        " Libraries such as PySoy which is a 3D game engine supporting Python 3, PyGame which provides functionality and a library for game development." +
                                        " Some games built in python are Civilization-IV, Battlefield 2, The Sims 4, Vega Strike, Mount & Blade etc.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "8" to Lesson(
                                8,
                                "",
                                "7. Web Scraping Applications: Python can be used to extract a large amount of data from websites which can then be helpful in various real-world processes such as price comparison, job listings, research and development and much more. ",
                                null,
                                LessonTypes.TEXT.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),

        LessonResponse(
                3,
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