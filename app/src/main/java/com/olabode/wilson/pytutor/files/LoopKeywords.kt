package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.tutorial.*
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/16/20.
 */

val loop_keywords = listOf(
        LessonResponse(
                1,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "`Pass Statement`",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "In Python, pass is a null statement. The interpreter does not ignore a pass statement," +
                                        " but nothing happens and the statement results into no operation.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example",
                                        code = "mList = [1, 2, 4, 6]\n" +
                                                "for number in mList:\n" +
                                                "    pass",
                                        footer = "`pass` is just a placeholder for functionality to be added later,because  the " +
                                                "loop body cannot be empty. "
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
                                "`Break Statement`",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "The break statement is used for premature termination of the current loop.\n" +
                                        "After terminating the loop, execution at the next statement is resumed.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "The break statement can be used in both while and for loops.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "If the break statement is inside a nested loop (i.e loop inside another loop), the break statement will terminate the innermost loop.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example: ",
                                        code = "for letter in 'Python': \n" +
                                                "    if letter == 'h':\n" +
                                                "        break\n" +
                                                "    print ('Current Letter :', letter)",
                                        footer = "We want to terminate the loop once we encounter letter `h`"
                                ),
                                LessonTypes.CODE.ordinal
                        ),
                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output: ",
                                        code = "Current Letter : P\n" +
                                                "Current Letter : y\n" +
                                                "Current Letter : t",
                                        footer = ""
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
                                "",
                                CodeSnippet(
                                        header = "Example: ",
                                        code = "count = 1\n" +
                                                "while count < 5:\n" +
                                                "    print(count)\n" +
                                                "    count = count + 1\n" +
                                                "    if count == 3:\n" +
                                                "        break\n" +
                                                "\n" +
                                                "print(\"loop ended\")",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output: ",
                                        code = "1\n2\nloop ended",
                                        footer = "Only 1 and 2 are printed because we terminate the loop once 3 is encountered."
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
                                "`Continue Statement`",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "The continue statement is used to skip the rest of the code inside a loop for the current iteration only.\n" +
                                        "That is, the current iteration of the loop will be disrupted, but the program will return to the top of the loop.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "The break statement can be used in both while and for loops.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "If the break statement is inside a nested loop (i.e loop inside another loop), the break statement will terminate the innermost loop.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example: ",
                                        code = "for letter in 'Python': \n" +
                                                "    if letter == 'h':\n" +
                                                "        continue\n" +
                                                "    print ('Current Letter :', letter)",
                                        footer = "We want to skip the execution of the loop body when `h` is encountered"
                                ),
                                LessonTypes.CODE.ordinal
                        ),
                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output: ",
                                        code = "Current Letter : P\n" +
                                                "Current Letter : y\n" +
                                                "Current Letter : t\n" +
                                                "Current Letter : o\n" +
                                                "Current Letter : n",
                                        footer = "Notice that `h` did not get printed."
                                ),
                                LessonTypes.CODE.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),

        LessonResponse(
                5,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example: ",
                                        code = "count = 1\n" +
                                                "while count < 5:\n" +
                                                "    print(count)\n" +
                                                "    count = count + 1\n" +
                                                "    if count == 3:\n" +
                                                "        continue\n" +
                                                "\n" +
                                                "print(\"loop ended\")",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output: ",
                                        code = "1\n2\n4\nloop ended",
                                        footer = "Notice that 3 is skipped."
                                ),
                                LessonTypes.CODE.ordinal
                        )
                )
        ),

        LessonResponse(
                6,
                lessons = null,
                question = mapOf(
                        "1" to Question(
                                question = "A `pass` statement is ignored by the interpreter",
                                options = mapOf(
                                        "1" to "True",
                                        "2" to "False",
                                        "3" to "Not sure"
                                ),
                                answerKey = "2"
                        ),

                        "2" to Question(
                                question = "Whats the purpose of the `break statement` ",
                                options = mapOf(
                                        "1" to "Terminate a loop",
                                        "2" to "Continue loop execution",
                                        "3" to "It serves as a placeholder"
                                ),
                                answerKey = "1"
                        ),
                        "3" to Question(
                                question = "Whats the purpose of the `continue statement`",
                                options = mapOf(
                                        "1" to "It serves as a placeholder",
                                        "2" to "Terminate a loop",
                                        "3" to "Skip execution of a loop body"
                                ),
                                answerKey = "3"
                        )
                ),
                type = LessonResponseType.QUESTION.ordinal
        )
)