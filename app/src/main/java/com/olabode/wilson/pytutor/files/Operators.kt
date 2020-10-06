package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/13/20.
 */

val operators = listOf(
    LessonResponse(
        "",
        1,
        lessons = mapOf(
            "1" to Tutorial(
                1,
                "",
                "In the previous chapters we talked about the Assignment Operator, Arithmetic Operators and their uses.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to Tutorial(
                2,
                "",
                "In this Chapter you will learn other operators : ",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to Tutorial(
                3,
                "",
                "Logical Operators",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "4" to Tutorial(
                4,
                "",
                "Comparison Operators",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "5" to Tutorial(
                5,
                "",
                "Membership Operators",
                null,
                LessonTypes.BULLET.ordinal
            ),
            "6" to Tutorial(
                6,
                "",
                "Identity Operators",
                null,
                LessonTypes.BULLET.ordinal
            ),
            "7" to Tutorial(
                7,
                "",
                "Comparison Operators: ",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "8" to Tutorial(
                8,
                "",
                "These operators compare the values on either side of them and decide the relation among " +
                    "them.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "9" to Tutorial(
                9,
                "",
                "Lets create two variables to illustrate these operators",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "10" to Tutorial(
                10,
                "",
                "",
                CodeSnippet(
                    header = "",
                    code = "number1 = 5\n" +
                        "number2 = 2",
                    footer = "we would be using these variables to illustrate all the  Operators"
                ),
                LessonTypes.CODE.ordinal
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
                "Equal Operator ` == ` :\nIf the values of two operands are equal, then the condition " +
                    "becomes true.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "print(number1 == number2)",
                    footer = "Checks if number1 and number2 are equal."
                ),
                LessonTypes.CODE.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "False",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "not equal ` != ` : \nIf values of two operands are not equal, then condition " +
                    "becomes true..",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "print(number1 != number2)",
                    footer = "Checks if number1 and number2 are not equal."
                ),
                LessonTypes.CODE.ordinal
            ),
            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "True",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "greater than ` > `: \nIf the value of left operand is greater than the value of right" +
                    "operand, then condition becomes true.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "8" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                8,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "print(number1 > number2)",
                    footer = "Checks if number1 greater number2."
                ),
                LessonTypes.CODE.ordinal
            ),
            "9" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                9,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "True",
                    footer = ""
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
                "Less than Operator ` < ` :\nIf the value of left operand is less than the value of right " +
                    "operand, then condition becomes true.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "print(number1 < number2)",
                    footer = "Checks if number1 is less than number2."
                ),
                LessonTypes.CODE.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "False",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "greater than or equal ` >= ` : \nIf the value of left operand is greater than or equal to the " +
                    "value of right operand, then condition becomes true.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "print(number1 >= number2)",
                    footer = "Checks if number1 is greater number2 or is equal to it."
                ),
                LessonTypes.CODE.ordinal
            ),
            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "True",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "greater than ` <= `: \nIf the value of left operand is less than or equal to the value " +
                    "of right operand, then condition becomes true.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "8" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                8,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "print(number1 <= number2)",
                    footer = "Checks if number1 is lesser than number2 or equal to it."
                ),
                LessonTypes.CODE.ordinal
            ),
            "9" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                9,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "False",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
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
                "Logical Operators: ",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Python supports the following Logical operators.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "Logical AND ` and `\nIf both the operands are true then condition becomes true",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "Example: ",
                CodeSnippet(
                    header = "",
                    code = "x = True\ny = False\nprint(x and y)",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "False",
                    footer = "Both operands are not `True` i.e `and` will evaluate to `False`"
                ),
                LessonTypes.CODE.ordinal
            ),
            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "Logical OR ` or `\nIf any of the operands is `True` then `or` will evaluate to `True`",
                null,
                LessonTypes.BULLET.ordinal
            ),
            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "Example: ",
                CodeSnippet(
                    header = "",
                    code = "x = True\ny = False\nprint(x or y)",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "8" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                8,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "True",
                    footer = "One operands is  `True` i.e `or` will evaluate to True"
                ),
                LessonTypes.CODE.ordinal
            ),

            "9" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                9,
                "",
                "Logical NOT ` not `\nUsed to reverse the logical state of its operand.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "10" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                10,
                "",
                "Example: ",
                CodeSnippet(
                    header = "",
                    code = "x = True\nprint(not x)",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "11" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                11,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "False",
                    footer = "Reversed variable x value from `True` to `False`"
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
                "Membership Operators: ",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Membership Operators are used to check whether a sequence contains a certain value.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "` in ` is a membership operator.\nTrue if value/variable is found in the sequence",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "Example: ",
                CodeSnippet(
                    header = "",
                    code = "name = \"Python\"\n" +
                        "print(\"y\" in name)\n",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "True",
                    footer = "\"y\" is a member of the string"
                ),
                LessonTypes.CODE.ordinal
            ),
            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "` not in `\nTrue if value/variable is not found in the sequence",
                null,
                LessonTypes.BULLET.ordinal
            ),
            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "Example: ",
                CodeSnippet(
                    header = "",
                    code = "name = \"Python\"\n" +
                        "print(\"j\" in name)",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "8" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                8,
                "",
                "",
                CodeSnippet(
                    header = "Output",
                    code = "True",
                    footer = "\"j\" is not a member of the sequence."
                ),
                LessonTypes.CODE.ordinal
            ),

            "9" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                9,
                "",
                "Identity Operators: ",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "10" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                10,
                "",
                "Identity operators compare the memory locations of two objects.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "11" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                11,
                "",
                "There are two Identity operators.",
                null,
                LessonTypes.TEXT.ordinal
            )
        )
    ),
    LessonResponse(
        "",
        6,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "` is `\nEvaluates to true if the variables on " +
                    "either side of the operator point to the " +
                    "same object and false otherwise. ",
                null,
                LessonTypes.BULLET.ordinal

            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "x = 2\n" +
                        "y = 2\n" +
                        "\n" +
                        "print(x is y)",
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
                    code = "True",
                    footer = "x and y are integers of the same values, so they are equal as well as identical."
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "` is not `\nEvaluates to false if the variables on " +
                    "either side of the operator point to the " +
                    "same object and true otherwise.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "x = 8\n" +
                        "\n" +
                        "print( type(x) is not float)",
                    footer = "N.B : type() method returns class type of the argument(object) passed as parameter"
                ),
                LessonTypes.CODE.ordinal
            ),
            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "True",
                    footer = "Evaluates to ` True ` because ` x ` is an integer and not a float."
                ),
                LessonTypes.CODE.ordinal
            )
        )
    ),
    LessonResponse(
        "",
        7,
        lessons = null,
        question = mapOf(
            "1" to Question(
                question = "which is an identity Operator ?",
                options = mapOf(
                    "1" to "is",
                    "2" to "not",
                    "3" to "in"
                ),
                answerKey = "1"
            ),

            "2" to Question(
                question = "\n" +
                    "Whats the output ?\n" +
                    "\n" +
                    "number =  4 % 2\n" +
                    "\n" +
                    "isEven = number == 0\n" +
                    "\n" +
                    "print(isEven)",
                options = mapOf(
                    "1" to "True",
                    "2" to "False",
                    "3" to "Error"
                ),
                answerKey = "1"
            )
        ),
        type = LessonResponseType.QUESTION.ordinal
    )
)