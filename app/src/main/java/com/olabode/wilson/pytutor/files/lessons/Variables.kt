package com.olabode.wilson.pytutor.files.lessons

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/12/20.
 */

val variables = listOf(
    LessonResponse(
        "",
        1,
        lessons = mapOf(
            "1" to Tutorial(
                1,
                "",
                "Variables are reserved memory locations to store values.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to Tutorial(
                2,
                "",
                "When a variable is created, you reserve some space in the memory.",
                null,
                LessonTypes.TEXT.ordinal

            ),

            "3" to Tutorial(
                3,
                "",
                "The Datatype of the variable determines how much memory  is allocated.",
                null,
                LessonTypes.TEXT.ordinal

            ),

            "4" to Tutorial(
                4,
                "",
                "Python variables do not need explicit declaration to reserve memory space.The declaration happens automatically when you assign a value to a variable.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "5" to Tutorial(
                5,
                "",
                "The ' = ' Assignment operator is used to assign values to variables.",
                null,
                LessonTypes.BULLET.ordinal
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
                "They also provide a way of labeling data with a descriptive name, so our programs can be understood more clearly by the reader and ourselves.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Their sole purpose is to label and store data in memory. This data can then be used throughout your program.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    header = "Example :1",
                    code = "name = \"Olabode\"",
                    footer = "In the above example we created a variable called name and assigned a String value 'Olabode'."
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "",
                CodeSnippet(
                    header = "Example 2: Assigning values to variables",
                    footer = "NB: The ' = ' Assignment operator is used to assign values to variables.",
                    code = "evenNo = 8\n" +
                        "weight = 26.6\n" +
                        "\n" +
                        "print(evenNo)\n" +
                        "print(weight)"
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    footer = "",
                    code = "8\n26.6"
                ),
                LessonTypes.CODE.ordinal
            )
        )
    ),

    LessonResponse(
        "",
        3,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "",
                CodeSnippet(
                    header = "Example 3: Python allows you to assign a single value to several variables simultaneously.\n" +
                        "Python allows you to assign a single value to several variables simultaneously.",
                    code = "a = b = c = 1\nprint(a)\nprint(b)\nprint(c)",
                    footer = "Here, an integer object is created with the value 1, and all the three variables are assigned to the same memory location."
                ),
                LessonTypes.CODE.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Output:",
                    code = "1\n2\n3\n",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    header = "Example 4 : Assign multiple objects to multiple variables.",
                    code = "name , age = \"Ruona\", 43\n" +
                        "\n" +
                        "print(name)\n" +
                        "print(age)",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "Ruona\n43",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            )
        ),
        question = null,
        type = LessonResponseType.LESSON.ordinal
    ),

    LessonResponse(
        "",
        4,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "",
                CodeSnippet(
                    header = "Example 5: Reassigning variables",
                    code = "name = \"Jack\"\n" +
                        "\n" +
                        "print(name)\n" +
                        "\n" +
                        "name = \"Smith\"\n" +
                        "\n" +
                        "print(name)",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "Jack\nSmith",
                    footer = "In the above example we assigned 'Jack' to variable `name`.Then changed the value to 'Smith'."
                ),
                LessonTypes.CODE.ordinal
            )
        )
    ),

    LessonResponse(
        "",
        5,
        lessons = null,
        question = mapOf(
            "1" to Question(
                question = "Whats the output?\n" +
                    "count = 4\n" +
                    "count = count + 2\n" +
                    "\n" +
                    "print(count)",
                options = mapOf(
                    "1" to "6",
                    "2" to "2",
                    "3" to "Error"
                ),
                answerKey = "1"
            ),

            "2" to Question(
                question = "Whats the output of `c`?\n" +
                    "\n" +
                    "a , b , c = 3 \n" +
                    "\n" +
                    "a = c + b\n" +
                    "\n" +
                    "c = c - 1\n" +
                    "\n" +
                    "print(c)",
                options = mapOf(
                    "1" to "1",
                    "2" to "6",
                    "3" to "2"
                ),
                answerKey = "3"
            ),
            "3" to Question(
                question = "\n" +
                    "Is this a valid assignment statement? \n" +
                    "\n" +
                    "a , b ,c = 4, 5 ,7",
                options = mapOf(
                    "1" to "True",
                    "2" to "False",
                    "3" to "Not sure"
                ),
                answerKey = "1"
            ),

            "4" to Question(
                question = "Why will this Statement show an Error?\n" +
                    "\n" +
                    "name ,age, height = \"Tom\", \"5\"",
                options = mapOf(
                    "1" to "Its a valid statement, No Error.",
                    "2" to "No value assigned to height.",
                    "3" to "\"5\" is assigned to `age`"
                ),
                answerKey = "2"
            )
        ),
        type = LessonResponseType.QUESTION.ordinal
    )
)