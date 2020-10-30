package com.olabode.wilson.pytutor.files.lessons

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/15/20.
 */

val for_loop = listOf(
    LessonResponse(
        "",
        1,
        lessons = mapOf(
            "1" to Tutorial(
                1,
                "",
                "A loop statement allows us to execute a statement or group of statements multiple times",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to Tutorial(
                2,
                "",
                "The for loop in Python is used to iterate over a sequence (list, tuple, string) or other iterable objects.\n" +
                    "Iterating over a sequence is called traversal.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to Tutorial(
                3,
                "",
                "Syntax: \n" +
                    "\n" +
                    "for var in sequence:\n" +
                    "\t# Body of for loop\n" +
                    "\tstatement1\n" +
                    "\tstatementN\n",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "4" to Tutorial(
                4,
                "",
                "`var` is a temporary variable that takes the value of the item inside the sequence on each iteration.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "5" to Tutorial(
                5,
                "",
                "whatever statements are in the BODY of the for loop are executed until the loop reaches the last item in the sequence.",
                null,
                LessonTypes.BULLET.ordinal
            ),
            "6" to Tutorial(
                6,
                "",
                "NB: The body of the for-loop is indented.This is because python uses indentation to specify blocks rather than {} curly braces used " +
                    "by most languages .\n" +
                    "i.e the indented block is to be executed in the for-loop.",
                null,
                LessonTypes.BULLET.ordinal
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
                CodeSnippet(
                    header = "Example:",
                    code = "language = \"Python\"\n" +
                        "\n" +
                        "for i in language:\n" +
                        "    print(letter)",
                    footer = "Iterating over a string."
                ),
                LessonTypes.CODE.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "P\n" +
                        "y\n" +
                        "t\n" +
                        "h\n" +
                        "o\n" +
                        "n",
                    footer = "N.B: `i` takes the value of each letter in the String `Python` on each iteration until it reaches the last item.\n" +
                        "i.e : no more letters to iterate over."
                ),
                LessonTypes.CODE.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    header = "Example :",
                    code = "numbers = [1, 2, 3, 4]\n" +
                        "for number in numbers:\n" +
                        "    print('current number is: ', number)",
                    footer = "Iterating over a list."
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "current number is: 1\n" +
                        "current number is: 2\n" +
                        "current number is: 3\n" +
                        "current number is: 4\n",
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
        3,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "`range() function`",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "range(startValue, stopValue)\n" +
                    "\n" +
                    "The built-in function range() is the right function to iterate over a sequence of numbers.\n" +
                    "It generates an iterator to progress integers starting with `startValue` up to `stopValue - 1`.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "range(startValue, stopValue ,stepSize)\n" +
                    "It generates a arithmetic progress starting from the `startValue` up to the `stopValue - 1` taking certain number of steps.\n" +
                    "An optional step can be provided,the default value is 1.",
                null,
                LessonTypes.BULLET.ordinal
            ),
            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "`range(stopValue)`\n" +
                    "The range function can also  be provided just one value, This value is used as the `stopValue`.\n" +
                    "It generate sequences from 0 up to `stopValue - 1`.",
                null,
                LessonTypes.BULLET.ordinal
            )
        )
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
                    header = "Example:",
                    code = "for num in range(0,4):\n" +
                        "    print(num)",
                    footer = "specifying start and stop values"
                ),
                LessonTypes.CODE.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "0\n" +
                        "1\n" +
                        "2\n" +
                        "3",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "for num in range(4):\n" +
                        "    print(num)",
                    footer = "Only stopValue is provided"
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "0\n" +
                        "1\n" +
                        "2\n" +
                        "3",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    header = "Example",
                    code = "for num in range(0,8,2):\n" +
                        "    print(num)",
                    footer = "`start, stop and step` is provided"
                ),
                LessonTypes.CODE.ordinal
            ),
            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "0\n" +
                        "2\n" +
                        "4\n" +
                        "6\n",
                    footer = "NB: It skips 2 values each time."
                ),
                LessonTypes.CODE.ordinal
            )
        )
    ),

    LessonResponse(
        "",
        5,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "Iterate through a list using indexes: ",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "names = ['tom', 'will', 'toby']\n" +
                        "\n" +
                        "# iterate over the list using index\n" +
                        "for i in range(len(names)):\n" +
                        "\tprint(\"I am\", names[i])",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "I am tom\n" +
                        "I am will\n" +
                        "I am toby\n",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "`for loop with else :`",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "If the `else` statement is used with a for loop, the else block is executed only if for\n" +
                    "loops terminates normally (and not by encountering break statement.",
                null,
                LessonTypes.TEXT.ordinal
            ),
            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "",
                CodeSnippet(
                    header = "Example:",
                    code = "num = [0, 1, 2]\n" +
                        "\n" +
                        "for i in digits:\n" +
                        "    print(i)\n" +
                        "else:\n" +
                        "    print(\"No numbers left.\")",
                    footer = "we will discuss `break` statement later"
                ),
                LessonTypes.CODE.ordinal
            ),
            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "",
                CodeSnippet(
                    header = "Output:",
                    code = "0\n" +
                        "1\n" +
                        "2\n" +
                        "No numbers left.",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            )
        )
    ),

    LessonResponse(
        "",
        6,
        lessons = null,
        question = mapOf(
            "1" to Question(
                question = "whats the output?\n" +
                    "for num in range(4,0,-1):\n" +
                    "    print(num, end=' ')",
                options = mapOf(
                    "1" to "4 3 2 1",
                    "2" to "4 3 2 1 0",
                    "3" to "3 2 1 0"
                ),
                answerKey = "1"
            ),

            "2" to Question(
                question = "whats the output?\n" +
                    "count = 0\n" +
                    "\n" +
                    "for num in range(4):\n" +
                    "    count = count + num\n" +
                    "\n" +
                    "print(count)",
                options = mapOf(
                    "1" to "4",
                    "2" to "8",
                    "3" to "6"
                ),
                answerKey = "3"
            ),
            "3" to Question(
                question = "A for-loop can be used to Iterate over a Tuple",
                options = mapOf(
                    "1" to "True",
                    "2" to "False",
                    "3" to "Sometimes"
                ),
                answerKey = "1"
            ),

            "4" to Question(
                question = "xlist = [\"aa\", \"bb\", \"cc\"]\n" +
                    "    for i in [2, 1, 0]:\n" +
                    "        print(xlist[i], end=\" \")",
                options = mapOf(
                    "1" to "aa bb cc",
                    "2" to "cc bb aa",
                    "3" to "Error"
                ),
                answerKey = "2"
            )
        ),
        type = LessonResponseType.QUESTION.ordinal
    )
)