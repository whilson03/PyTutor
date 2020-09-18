package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/13/20.
 */


val numbers = listOf(
        LessonResponse(
                1,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "Number data types store numeric values. Number objects are created when you assign a " +
                                        "value to them.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example 1: ",
                                        code = "number1 = 90 #int (signed integers)\n" +
                                                "number2 = 23.8 #(floating point real values)\n" +
                                                "number3 = 2 + 5j #complex (complex numbers)",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "Python supports three different numerical types: ",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "int (signed integers)",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "float (floating point real values)",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),
                        "6" to Lesson(
                                6,
                                "",
                                "complex (complex numbers)",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),
                        "7" to Lesson(
                                7,
                                "",
                                "",
                                CodeSnippet(
                                        header = "You can delete a single object or multiple objects by using the del statement.",
                                        code = "del number1\ndel number2, number2",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        )
                )
        ),


        LessonResponse(
                2,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "Arithmetic Operators: ",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "Arithmetic Operations are a common task in our everyday life, its also a common task in programming.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "Lets create two variables to illustrate these operators",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet(
                                        header = "",
                                        code = "number1 = 5\n" +
                                                "number2 = 2",
                                        footer = "we would be using these variables to illustrate all the Arithmetic Operators" +
                                                "in Python."
                                ),
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
                                "+ Addition :\nAdds values on either side of the operator.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Addition: \n the `+` symbol is used to perform addition ",
                                        code = "print(number1 + number2)",
                                        footer = "Adds number1 and number2, displays the result to the console."
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output",
                                        code = "7",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                " - Subtraction :\nSubtracts right hand operand from left hand " +
                                        "operand.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Subtraction: \n the `-` symbol is used to perform subtraction ",
                                        code = "print(number1 - number2)",
                                        footer = "Subtracts number2 from number1, displays the result to the console."
                                ),
                                LessonTypes.CODE.ordinal
                        ),
                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output",
                                        code = "3",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        )

                )
        ),

        LessonResponse(
                4,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "* Multiplication :\nMultiplies values on either side of the operator",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Multiplication: \n the asterisk ` * ` symbol is used to perform addition ",
                                        code = "print(number1 * number2)",
                                        footer = "Multiplies number1 and number2, displays the result to the console."
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output",
                                        code = "10",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "/ Division :\nDivides left hand operand by right hand " +
                                        "operand",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Division: \n the forward slash `/ ` symbol is used to perform division ",
                                        code = "print(number1 / number2)",
                                        footer = "Divides number1 by number2, displays the result to the console."
                                ),
                                LessonTypes.CODE.ordinal
                        ),
                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output",
                                        code = "2.5",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        )

                )
        ),
        LessonResponse(
                5,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "% Modulus :\nDivides left hand operand by right hand operand and returns remainder",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Modulus: \n the percent `%` symbol is used to perform Modulus operation ",
                                        code = "print(number1 % number2) #5 % 2",
                                        footer = "Divides number1 by number2 and returns only the remainder of the division, displays the result to the console."
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output",
                                        code = "1",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "** Exponent :\nPerforms exponential (power) calculation on " +
                                        "operators",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Exponent: \n two asterisks `**` symbol is used to perform Exponential Operations ",
                                        code = "print(number1 ** number2) # 5 ** 2",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),
                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output",
                                        code = "25",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        )
                )
        ),
        LessonResponse(
                6,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "// Floor Division :\nDivides left hand operand by right hand operand and returns the quotient.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Floor Division: \n the percent `//` symbol is used to perform Floor Division. ",
                                        code = "print(number1 // number2) #5 // 2",
                                        footer = "Divides number1 by number2 and returns only the quotient of the division, displays the result to the console."
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output",
                                        code = "2",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        )
                )
        ),

        LessonResponse(
                7,
                lessons = null,
                question = mapOf(
                        "1" to Question(
                                question = "How many numeric types does python support?",
                                options = mapOf(
                                        "1" to "4",
                                        "2" to "2",
                                        "3" to "3"
                                ),
                                answerKey = "3"
                        ),

                        "2" to Question(
                                question = "which combination is Arithmetic Operators is wrong?",
                                options = mapOf(
                                        "1" to "+, =, $ , -",
                                        "2" to "+, -, %",
                                        "3" to "*, +, //"
                                ),
                                answerKey = "1"
                        ),
                        "3" to Question(
                                question = "Which operator returns the remainder of the division?",
                                options = mapOf(
                                        "1" to "+",
                                        "2" to "*",
                                        "3" to "%"
                                ),
                                answerKey = "3"
                        )
                ),
                type = LessonResponseType.QUESTION.ordinal
        )
)