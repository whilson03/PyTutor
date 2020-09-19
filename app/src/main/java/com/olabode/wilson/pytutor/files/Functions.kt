package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 * Created by Ogheneruona Onobrakpeya on 9/15/20.
 */

val functions = listOf(
        LessonResponse("",
                1,
                lessons = mapOf(
                        "1" to Tutorial(
                                1,
                                "",
                                "A function is a block of code which only runs when it is called. \n" +
                                        "It is used to perform related actions.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Tutorial(
                                2,
                                "",
                                "Functions are a convenient way to divide your code into useful blocks.\n" +
                                        "This allows you to make it more readable, reusable, and also save time.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Tutorial(
                                3,
                                "",
                                "You can pass data, known as parameters, into a function.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Tutorial(
                                4,
                                "",
                                "Creating a Function",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "5" to Tutorial(
                                5,
                                "",
                                "In Python, functions are declared with the \"def\" keyword.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "6" to Tutorial(
                                6,
                                "",
                                "This is then followed by the name of the function.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "7" to Tutorial(
                                7,
                                "",
                                "Next, the parameters of the function are declared in parentheses.\n" +
                                        "These parameters are variables that will be used in the function scope.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "8" to Tutorial(
                                8,
                                "",
                                "Finally the body of the function is written after a colon and indentation.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "9" to Tutorial(
                                9,
                                "",
                                "",
                                CodeSnippet("Syntax of a Function", "def functionName(parameters[optional]):\n" +
                                        "    # function", ""),
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
                                "Why Use Functions",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                2,
                                "",
                                "Functions are very important concepts in programming.\n" +
                                        "As previously mentioned they help in ease of reusability and readability and extensibility.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                3,
                                "",
                                "",
                                CodeSnippet("Take the following code:", "name = \"John\"\n" +
                                        "print(\"Hello \" + name)\n" +
                                        "print(\"How was your day?\")\n" +
                                        "\n" +
                                        "name = \"Tom\"\n" +
                                        "print(\"Hello \" + name)\n" +
                                        "print(\"How was your day?\")\n" +
                                        "\n" +
                                        "name = \"Janet\"\n" +
                                        "print(\"Hello \" + name)\n" +
                                        "print(\"How was your day?\")", "This program prints a personalized greeting message for each name."),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                4,
                                "",
                                "",
                                CodeSnippet("Output", "Hello John\n" +
                                        "How was your day?\n" +
                                        "Hello Tom\n" +
                                        "How was your day?\n" +
                                        "Hello Janet\n" +
                                        "How was your day?", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                5,
                                "",
                                "You may notice that the print statements are repeated often.\n" +
                                        "While this may not be much of an issue in a smaller program, it quickly becomes a hassle when trying to deal with more names.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                6,
                                "",
                                "",
                                CodeSnippet("Functions make this quite easier.", "def greet(name):\n" +
                                        "    print(\"Hello \" + name)\n" +
                                        "    print(\"How was your day?\")\n" +
                                        "\n" +
                                        "greet(\"John\")\n" +
                                        "greet(\"Tom\")\n" +
                                        "greet(\"Janet\")", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                7,
                                "",
                                "",
                                CodeSnippet("Output", "Hello John\n" +
                                        "How was your day?\n" +
                                        "Hello Tom\n" +
                                        "How was your day?\n" +
                                        "Hello Janet\n" +
                                        "How was your day?", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "8" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                8,
                                "",
                                "Now we have the greeting messages in a function which can be called with any name.\n" +
                                        "Adding more names to this program will just be a trivial matter of calling the function.\n",
                                null,
                                LessonTypes.TEXT.ordinal
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
                                "Return Values from a Function",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                2,
                                "",
                                "A function can also return data as a result.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                3,
                                "",
                                "",
                                CodeSnippet("Take a function to return the sum of two numbers.", "def sumNums(num1, num2):\n" +
                                        "    return num1 + num2\n" +
                                        "\n" +
                                        "num1 = 5\n" +
                                        "num2 = 6\n" +
                                        "numSum = sumNums(num1, num2)\n" +
                                        "\n" +
                                        "print(\"The sum of \" + str(num1) + \" and \" + str(num2) + \" is \" + str(numSum))", "The sum of both numbers are computed and returned in the body of the function."),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                4,
                                "",
                                "",
                                CodeSnippet("Output", "The sum of 5 and 6 is 11", ""),
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
                                "The Pass Statement",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                2,
                                "",
                                "The \"Pass\" keyword is used when an expression is required but you do not want to execute any command.\n" +
                                        "It is usually used with functions, conditions and loops.\n" +
                                        "This can be for various reasons such as creating a scope for future purposes or needing an empty condition block.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                3,
                                "",
                                "",
                                CodeSnippet("Example", "def testFunc():\n" +
                                        "     pass\n" +
                                        "\n" +
                                        "testFunc()", "This program has a blank output as nothing is done in the function body."),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                4,
                                "",
                                "",
                                CodeSnippet("With conditions:", "if 4 > 3:\n" +
                                        "    pass\n" +
                                        "\n" +
                                        "else:\n" +
                                        "    print(\"4 is less than 3\")\n" +
                                        "\n" +
                                        "print(\"done\")", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                                5,
                                "",
                                "",
                                CodeSnippet("Output", "done", "Likewise, nothing is executed in the if block."),
                                LessonTypes.CODE.ordinal
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
                                question = "What is not a purpose of functions?",
                                options = mapOf(
                                        "1" to "Reusability",
                                        "2" to "Instability",
                                        "3" to "Extensibility"
                                ),
                                answerKey = "2"
                        ),

                        "2" to Question(
                                question = "What keyword is used to pass out a value from a function?",
                                options = mapOf(
                                        "1" to "return",
                                        "2" to "pass",
                                        "3" to "output"
                                ),
                                answerKey = "1"
                        ),

                        "3" to Question(
                                question = "What keyword is used to declare Python functions?",
                                options = mapOf(
                                        "1" to "func",
                                        "2" to "fun",
                                        "3" to "def"
                                ),
                                answerKey = "3"
                        )
                ),
                type = LessonResponseType.QUESTION.ordinal
        )
)