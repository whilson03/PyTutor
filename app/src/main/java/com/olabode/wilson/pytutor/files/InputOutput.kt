package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Lesson
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/14/20.
 */

val io = listOf(
        LessonResponse(
                1,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "A common scenario in programming is allowing user interact with our programs, i.e getting user inputs and also displaying outputs for them to see.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "In this Chapter we will be focusing on how to get inputs from users and also display some meaningful " +
                                        "information to them after processing their inputs.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "Getting user input:",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "Programs may use the `input()` function to obtain information from the user.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example:",
                                        code = "print(\"Please enter some text: \")\n" +
                                                "value = input()\n" +
                                                "print(\"Text entered is \" + value)",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example:",
                                        code = "Output:\n" +
                                                "Please enter some text: \n" +
                                                "Hello\n" +
                                                "Text entered is Hello",
                                        footer = "After the program prints the message `Please enter some text:`, the `input()` causes the program’s execution stops and waits for the user to type some text using the keyboard.. " +
                                                "The text is then displayed to the user using the `print()` function."
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
                                "NB: `input() returns a String.`",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "input([prompt]) also takes an optional prompt which must be a String. This prompt is displayed to the user before the input is entered.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example: ",
                                        code = "stringNum = input('Enter a number: ')\n" +
                                                "print(type(stringNum))",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output: ",
                                        code = "Enter a number:\n" +
                                                "22\n" +
                                                "<class 'str'>",
                                        footer = "Even though the value entered is a number, `input() ` returns a string"
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "But how do we actually get the value inputted as an integer ?",
                                null,
                                LessonTypes.TEXT.ordinal
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
                                "This takes us to Type Conversion",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "Python has some Built-In functions for converting from one Data type to another.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "To convert a string-number (\"22\") from a string into a number we can use int() or float() functions.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),
                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example: ",
                                        code = "myString = \"24\"\n" +
                                                "myFloat = float(myString)\n" +
                                                "myInt = int(myString)\n" +
                                                "\n" +
                                                "print(type(myString))\n" +
                                                "print(type(myFloat))\n" +
                                                "print(type(myInt))",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),
                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output ",
                                        code = "<class 'str'>\n" +
                                                "<class 'float'>\n" +
                                                "<class 'int'>",
                                        footer = "N.B: The `float()` converts the string to a float , while the `int()` converts the string to an integer." +
                                                "Now these values can be used in arithmetic operations."
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
                                "Output Using `print()` function",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "Before now we have used the `print()` to display outputs.Lets take a closer look into this function.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "The `print()` function is used output data to the standard output device (screen).",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),
                        "4" to Lesson(
                                4,
                                "",
                                "print(object(s), sep=' ', end='\\n', file=sys.stdout, flush=False)",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),
                        "5" to Lesson(
                                5,
                                "",
                                "Lets take a closer look at this syntax.",
                                null,
                                LessonTypes.BULLET.ordinal
                        )
                )
        ),

        LessonResponse(
                5,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "object(s)\nAn object or multiple objects Separated by commas `,`.They Will be converted to string before printed.\n" +
                                        "object in this case refers to Strings,Integer, Floats etc.",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example",
                                        code = "print(\"Hello\", \"how are you?\")",
                                        footer = "Print more than one object"
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output",
                                        code = "Hello , how are you",
                                        footer = ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "sep\n" +
                                        "This value is optional. It specifies how to separate the objects, if there is more than one.\n" +
                                        "If no value is provided, the default value is an empty string ' '",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example:",
                                        footer = "This `---` dashes will be inserted between the values to be printed. ",
                                        code = "print(1,2,3,sep=\"---\")"
                                ),
                                LessonTypes.CODE.ordinal
                        ),
                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output: ",
                                        code = "1---2---3",
                                        footer = "The dashes has been used as a separator"
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
                                "The last argument we will be looking at is the `end=' ' ` ",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "end\n" +
                                        "The purpose of `end=` is to specify what to print at the end of each line.\n" +
                                        "By default when a print statement is executed, the cursor moves to the next line after printing.This is because by default end='\\n'.\n" +
                                        "`\\n` is a special character which means newline,it moves the cursor to the next line.\n" +
                                        "we can change this behaviour by providing it with what ever we want to get printed after each line",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Example: ",
                                        code = "print(\"jack\" , end = '@')\n" +
                                                "print(\"pytutor.com\")",
                                        footer = "NB: `@` is specified as the end character, so the cursor will remain on that line and `@` will " +
                                                "be displayed at the end of the line."
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "sep\n" +
                                        "This value is optional. It specifies how to separate the objects, if there is more than one.\n" +
                                        "If no value is provided, the default value is an empty string ' '",
                                null,
                                LessonTypes.BULLET.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet(
                                        header = "Output: ",
                                        code = "jack@pytutor.com",
                                        footer = "Since the cursor remained on that same line after executing the first print() statement, the second print() " +
                                                "also gets printed on that line."
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
                                question = "What does \\n denote ?",
                                options = mapOf(
                                        "1" to "space",
                                        "2" to "newline",
                                        "3" to "tab character"
                                ),
                                answerKey = "2"
                        ),

                        "2" to Question(
                                question = "Whats the output?\n" +
                                        "print(\"hello\",\"tom\",sep='--',end='&jerry')",
                                options = mapOf(
                                        "1" to "hello&jerry--tom&jerry",
                                        "2" to "Error",
                                        "3" to "hello--tom&jerry"
                                ),
                                answerKey = "3"
                        ),
                        "3" to Question(
                                question = "Whats the default value for `sep= ???` and `end= ???` respectively?",
                                options = mapOf(
                                        "1" to "' ' , \\n ",
                                        "2" to "\\n , ' '",
                                        "3" to "' ', ' '"
                                ),
                                answerKey = "1"
                        )
                ),
                type = LessonResponseType.QUESTION.ordinal
        )
)