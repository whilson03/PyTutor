package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/16/20.
 */

val while_loop = listOf(
        LessonResponse(
                1,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "A while loop statement in Python programming language repeatedly executes a target\n" +
                                        "statement as long as a given condition is true.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Syntax: ",
                                        code = "while expression:\n" +
                                                "    statement(s)",
                                        footer = "This is the syntax of a while loop in the Python programming language"
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "In a while loop, test expression is checked first. The body of the loop is executed only if the `expression` evaluates to True.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "The `while` loop stops execution once the `expression` evaluates to False",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "N.B:\n" +
                                        "In Python, the body of the while loop is determined through indentation.\n" +
                                        "The body starts with indentation and the first unindented line marks the end.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),
                        "6" to Lesson(
                                6,
                                "",
                                "The condition may be any expression, and true is any non-zero value.",
                                null,
                                LessonTypes.BULLET.ordinal
                        )
                )
        ),

        LessonResponse(
                2,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "N.B:\nThe body of a while loop will never get executed if the `expression` for the loop evaluates to  False.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example: ",
                                        code = "count = 0\n" +
                                                "while (count < 4):\n" +
                                                "    # Body of while loop\n" +
                                                "    print ('The count is:', count)\n" +
                                                "    count = count + 1\n" +
                                                "\n" +
                                                "# end of while loop\n" +
                                                "print (\"Good bye!\")",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet(
                                        header = "",
                                        code = "The count is: 0\n" +
                                                "The count is: 1\n" +
                                                "The count is: 2\n" +
                                                "The count is: 3\n" +
                                                "Loop Ended!",
                                        footer = "The block here, consisting of the print and increment statements, is executed repeatedly\n" +
                                                "until count is no longer less than 4. With each iteration, the current value of the index\n" +
                                                "count is displayed and then increased by 1."
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "The Infinite Loop",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "A loop becomes infinite loop if a condition never becomes FALSE.",
                                null,
                                LessonTypes.BULLET.ordinal
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
                                "You must be cautious when using while loops because of the possibility that this condition never resolves to a FALSE value",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "This results in a loop that never ends.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example:",
                                        code = "count = 2\n" +
                                                "while count < 5:\n" +
                                                "    print('less than 5')",
                                        footer = "The following code will produce an infinite loop because 2 will always be less than 5, there is no" +
                                                " statement in the body of the loop to increment the count variable till its no longer less than 5"
                                ),
                                LessonTypes.CODE.ordinal
                        ),
                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output:",
                                        code = "less than 5\n" +
                                                "less than 5\n" +
                                                "less than 5\n" +
                                                "less than 5\n" +
                                                "less than 5\n" +
                                                "less than 5\n" +
                                                "less than 5\n" +
                                                "less than 5",
                                        footer = "This loop can only be terminated by using CTRL+C"
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
                                "`while` with `else`:",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "Same as with for loops, while loops can also have an optional else block.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "The else part is executed if the condition in the while loop evaluates to False.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),
                        "4" to Lesson(
                                4,
                                "",
                                "The while loop can be terminated with a break statement. In such cases, the else part is ignored.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),
                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example: ",
                                        code = "fruits = ['apple', 'mango', 'grape']\n" +
                                                "\n" +
                                                "index = 0\n" +
                                                "while index < len(fruits):\n" +
                                                "    print(fruits[index])\n" +
                                                "    index = index + 1\n" +
                                                "\n" +
                                                "else:\n" +
                                                "    print('No more fruits')",
                                        footer = "This can easily be achieved using a `for loop`"
                                ),
                                LessonTypes.CODE.ordinal
                        ),
                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output: ",
                                        code = "apple\n" +
                                                "mango\n" +
                                                "grape\n" +
                                                "No more fruits",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        )
                )
        ),
        LessonResponse(
                5,
                lessons = null,
                question = mapOf(
                        "1" to Question(
                                question = "How many times does the body of this while loop get executed?\n" +
                                        "total = 0\n" +
                                        "while total < 10:\n" +
                                        "    total  = 1\n" +
                                        "    print(total)",
                                options = mapOf(
                                        "1" to "10 times",
                                        "2" to "Infinitely",
                                        "3" to "Never Executes"
                                ),
                                answerKey = "2"
                        ),

                        "2" to Question(
                                question = "This program evaluates to an Infinite-loop, why?\n" +
                                        "total = 0\n" +
                                        "while total <= 3:\n" +
                                        "    total  = total * 8\n" +
                                        "    print(total)",
                                options = mapOf(
                                        "1" to "total * 8 is always 0 which is less than 3",
                                        "2" to "Its not an infinite loop",
                                        "3" to "The expression is never `True`"
                                ),
                                answerKey = "1"
                        ),
                        "3" to Question(
                                question = "How many times will the body of this loop get Executed?\n" +
                                        "count = 1\n" +
                                        "\n" +
                                        "while count >= 5:\n" +
                                        "    print(count)\n" +
                                        "    count = count + 2",
                                options = mapOf(
                                        "1" to "Never",
                                        "2" to "5 times",
                                        "3" to "2 times"
                                ),
                                answerKey = "1"
                        )
                ),
                type = LessonResponseType.QUESTION.ordinal
        )
)