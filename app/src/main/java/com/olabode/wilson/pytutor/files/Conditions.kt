package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 * Created by Ogheneruona Onobrakpeya on 9/17/20.
 */

val conditions = listOf(
        LessonResponse("",
                1,
                lessons = mapOf(
                        "1" to Tutorial(
                                1,
                                "",
                                "In programming, conditions are very useful concepts to control a program flow.\n" +
                                        "All conditions resolve to boolean (true and false) values.  ",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Tutorial(
                                2,
                                "",
                                "What are Boolean Values?",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Tutorial(
                                3,
                                "",
                                "Booleans are another data type in Python like numbers and strings.\n" +
                                        "A boolean can only be either true or false.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Tutorial(
                                4,
                                "",
                                "",
                                CodeSnippet("", "print(type(True))\n" +
                                        "print(type(False))", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to Tutorial(
                                5,
                                "",
                                "",
                                CodeSnippet("Output", "<type 'bool'>\n" +
                                        "<type 'bool'>", "Both have the type \"bool\"."),
                                LessonTypes.CODE.ordinal
                        ),

                        "6" to Tutorial(
                                6,
                                "",
                                "Boolean Expressions",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "7" to Tutorial(
                                7,
                                "",
                                "Boolean expressions are expressions that evaluate to a Boolean value.\n" +
                                        "They usually involve a comparison operator. ",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "8" to Tutorial(
                                8,
                                "",
                                "",
                                CodeSnippet("Take the following code:", "result = 4 > 2\n" +
                                        "print(result)", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "9" to Tutorial(
                                9,
                                "",
                                "",
                                CodeSnippet("Output", "True", "Since 4 is indeed greater than 2, the expression was resolved to \"True\"."),
                                LessonTypes.CODE.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),

        LessonResponse("",
                2,
                lessons = mapOf(
                        "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                1,
                                "",
                                "If Statements",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                2,
                                "",
                                "If Statements are used to execute a block of code only if the expression in the parameter resolves to \"True\".",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                3,
                                "",
                                "",
                                CodeSnippet("Syntax", "if expression:\n" +
                                        "    # do something", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                4,
                                "",
                                "",
                                CodeSnippet("Example", "num1 = 4\n" +
                                        "num2 = 2\n" +
                                        "\n" +
                                        "if num1 > num2:\n" +
                                        "    print(\"num1 is greater than num2\")\n" +
                                        "\n" +
                                        "print(\"done\")", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                5,
                                "",
                                "",
                                CodeSnippet("Output", "num1 is greater than num2\n" +
                                        "done", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                6,
                                "",
                                "",
                                CodeSnippet("Now try it with a false statement.", "num1 = 4\n" +
                                        "num2 = 2\n" +
                                        "\n" +
                                        "if num1 < num2:\n" +
                                        "    print(\"num1 is greater than num2\")\n" +
                                        "\n" +
                                        "print(\"done\")", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                7,
                                "",
                                "",
                                CodeSnippet("Output", "done", "The body of the if block wasn't executed because the condition is false."),
                                LessonTypes.CODE.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),

        LessonResponse("",
                3,
                lessons = mapOf(
                        "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                1,
                                "",
                                "Else Statements",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                2,
                                "",
                                "Else statements are used as complements to ifs.\n" +
                                        "If the condition of the if-block is false, the corresponding else block will be executed instead.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                3,
                                "",
                                "",
                                CodeSnippet("", "num1 = 4\n" +
                                        "num2 = 2\n" +
                                        "\n" +
                                        "if num1 < num2:\n" +
                                        "    print(\"num1 is greater than num2\")\n" +
                                        "\n" +
                                        "else:\n" +
                                        "    print(\"num1 is not greater than num2\")\n" +
                                        "\n" +
                                        "print(\"done\")", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                4,
                                "",
                                "",
                                CodeSnippet("Output", "num1 is not greater than num2\n" +
                                        "done", "The else block was executed here over the if."),
                                LessonTypes.CODE.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),

        LessonResponse("",
                4,
                lessons = mapOf(
                        "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                1,
                                "",
                                "Elif Statements",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                2,
                                "",
                                "Elif statements provide a means to check for other conditions.\n" +
                                        "They are usually used between the initial \"if\" and final \"else\" blocks.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                3,
                                "",
                                "",
                                CodeSnippet("", "num1 = 4\n" +
                                        "num2 = 4\n" +
                                        "\n" +
                                        "if num1 < num2:\n" +
                                        "    print(\"num1 is greater than num2\")\n" +
                                        "\n" +
                                        "elif num2 == num2:\n" +
                                        "    print(\"num1 is equal to num2\")\n" +
                                        "\n" +
                                        "else:\n" +
                                        "    print(\"num1 is not greater than num2\")\n" +
                                        "\n" +
                                        "print(\"done\")", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                4,
                                "",
                                "",
                                CodeSnippet("Output", "num1 is equal to num2\n" +
                                        "done", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                5,
                                "",
                                "The flow of condition scopes essentially falls through from the first if block and checking the remaining elif blocks for a satisfied condition.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                6,
                                "",
                                "If a condition is satisfied, the scope is immediately broken out of.\n" +
                                        "Otherwise, if no condition is satisfied, the closing else block is instead executed if it is available.",
                                null,
                                LessonTypes.TEXT.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),

        LessonResponse("",
                5,
                lessons = null,
                question = mapOf(
                        "1" to Question(
                                question = "What will be the output of:\n" +
                                        "name = \"Debbie\"\n" +
                                        "\n" +
                                        "if len(name) > 5:\n" +
                                        "    print(\"Name check passed\")\n" +
                                        "\n" +
                                        "else:\n" +
                                        "    print(\"Name check failed\")",
                                options = mapOf(
                                        "1" to "Name check failed",
                                        "2" to "Undefined",
                                        "3" to "Name check passed"
                                ),
                                answerKey = "3"
                        ),

                        "2" to Question(
                                question = "Conditions can consist of blocks such as if, else and...",
                                options = mapOf(
                                        "1" to "elif",
                                        "2" to "else if",
                                        "3" to "when"
                                ),
                                answerKey = "1"
                        ),
                        "3" to Question(
                                question = "Conditions resolve to",
                                options = mapOf(
                                        "1" to "booleans",
                                        "2" to "integers",
                                        "3" to "strings"
                                ),
                                answerKey = "1"
                        )
                ),
                type = LessonResponseType.QUESTION.ordinal
        )
)