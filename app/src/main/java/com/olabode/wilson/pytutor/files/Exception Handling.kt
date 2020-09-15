package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.tutorial.*
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 * Created by Ogheneruona Onobrakpeya on 9/14/20.
 */

val exception_handling = listOf(
        LessonResponse(
                1,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "Exceptions are undesirable events which, contrary to errors, can be handled.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "Examples of Python exceptions are:",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "ZeroDivisionError: Raised when a value is divided by zero.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "NameError: Raised when a variable name is not defined.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "ModuleNotFoundError: Raised when a module designated for importing does not exist.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "Exception handling is very useful in controlling the flow of a program.\n" +
                                        "It also has the advantage of displaying user-friendly error messages, rather than the Python defaults.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "7" to Lesson(
                                7,
                                "",
                                "Handling exceptions is achieved which the use of \"try-except\" blocks.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "8" to Lesson(
                                8,
                                "",
                                "",
                                CodeSnippet("Syntax", "try:\n" +
                                        "\t\texpression\n" +
                                        "\texcept(exception_name[optional]):\n" +
                                        "\t\t// handle exception", ""),
                                LessonTypes.CODE.ordinal
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
                                "The expression which is excepted to contain an exception is placed in the \"try\" block.\n" +
                                        "The \"except\" block is executed if an exception is indeed caught in the try block.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet("Without exception handling", "num = 3\n" +
                                        "den = 0\n" +
                                        "print(num/den)", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet("Output", "ZeroDivisionError: division by zero", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet("With exception handling", "num = 3\n" +
                                        "den = 0\n" +
                                        "\n" +
                                        "try:\n" +
                                        "    print(num/den)\n" +
                                        "except(ZeroDivisionError):\n" +
                                        "    print(\"Division by zero not pos", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet("Output", "Division by zero not possible", "This form is more meaningful to the user."),
                                LessonTypes.CODE.ordinal
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
                                "There is an optional \"finally\" block for exception handling. \n" +
                                        "The \"finally\" block always runs after a \"try-except\" block, not matter the outcome.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet("", "import sys \n" +
                                        "num = 3\n" +
                                        "den = 0\n" +
                                        "\n" +
                                        "try:\n" +
                                        "    print(num/den)\n" +
                                        "except(ZeroDivisionError):\n" +
                                        "    print(\"Division by zero not possible\")\n" +
                                        "    sys.exit()\n" +
                                        "finally:\n" +
                                        "    print(\"Finally\")", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet("Output", "Division by zero not possible\n" +
                                        "Finally",""),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "Although sys.exit() was called in the \"except\" block, the \"finally\" block was executed before the program quit running.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "If no exception name is specified in the \"except\" block parameter, all exceptions will be caught.",
                                null,
                                LessonTypes.TEXT.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
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
                                answerKey = "1"
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
                                answerKey = "3"
                        )
                ),
                type = LessonResponseType.QUESTION.ordinal
        )
)