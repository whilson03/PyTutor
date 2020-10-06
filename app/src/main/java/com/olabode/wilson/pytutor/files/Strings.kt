package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/12/20.
 */

val strings = listOf(
    LessonResponse(
        "",
        1,
        lessons = mapOf(
            "1" to Tutorial(
                1,
                "",
                "Strings in Python are identified as a set of characters surrounded by quotation marks.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to Tutorial(
                2,
                "",
                "Python allows either pair of single or double quotes.Multi-line strings can be denoted using triple quotes, ''' or \"\"\"",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "school = \"my cool school\" # double quotes is used\n" +
                        "\n" +
                        "name = '2020' # single quotes is used\n" +
                        "\n" +
                        "long_name = \"\"\"     # multi line string\n" +
                        "    my\n" +
                        "    multiline\n" +
                        "    name\n" +
                        "    \"\"\"\n" +
                        "\n" +
                        "print(school)\n" +
                        "print(name)\n" +
                        "print(long_name)",
                    footer = "N.B: 2020 is a string not an integer."
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to Tutorial(
                4,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "my cool school\n" +
                        "2020\n" +
                        "    my\n" +
                        "    multiline\n" +
                        "    name",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to Tutorial(
                5,
                "",
                "Spaces within a String are also counted as Characters",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "6" to Tutorial(
                6,
                "",
                "",
                CodeSnippet(
                    header = "Do not mix quotes when creating strings,that start and end quotes must match",
                    footer = "",
                    code = "school = 'my cool school\" # ERROR\n"
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
                "",
                CodeSnippet(
                    header = "Subsets of strings can be taken using the slice operator ([ ] and [:] ) with indexes starting at 0 in the beginning of the string and working their way from -1 to the end.",
                    code = "hero = \"Batman\"\n" +
                        "\n" +
                        "print(hero) #complete string\n" +
                        "print(hero[0]) #first character of the string\n" +
                        "\n" +
                        "print(hero[0:4]) #characters starting from 1st to the 3rd\n" +
                        "print (str[2:]) #the whole string starting from 3rd character",
                    footer = "The syntax for the slice operator is [startIndex: StopIndex - 1 : <Step>]. Both stopIndex and Step are optional."
                ),
                LessonTypes.CODE.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "Batman\n" +
                        "B\n" +
                        "Batm\n" +
                        "tman",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    header = "Strings can also be index backwards. The last character is -1",
                    code = "print(hero[-1]) # Prints the last character in the string\n" +

                        "print(hero[-3: -1])\n # Prints the 3rd and 2nd character from behind in the string",
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
                    code = "B\nma",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    header = "Example: ",
                    code = "language = \"Python\"\n" +
                        "print(language[0:6:2])",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "",
                CodeSnippet(
                    header = "Output: ",
                    code = "Pto #skips two characters",
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
                "A very common case when working with Strings is to know how many characters it contain. Python has and handy function for that.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "len() is used to get the number of characters in a String.",
                    code = "language = \"Python\"\n" +
                        "\n" +
                        "print(len(language))",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "String Concatenation: ",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "",
                CodeSnippet(
                    header = "The plus (+) sign is the string concatenation operator.",
                    code = "greeting = \"Hello\"\n" +
                        "print(greeting + \"World\")\n" +
                        "print(\"Welcome  \" + \"back\")",
                    footer = "N.B: The Spaces at the end of `Welcome` are also characters in the String."
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "Output: ",
                CodeSnippet(
                    header = "",
                    code = "HelloWorld\n" +
                        "Welcome  back",
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
                "String Repetition: ",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Example:\n The asterisk (*) is the repetition" +
                        "operator ",
                    code = "greeting = \"Hello\"\n" +
                        "print(greeting * 2)",
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
                    code = "HelloHello",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "Apart from len() there several other Built-In Functions for working and manipulating Strings in Python.",
                null,
                LessonTypes.BULLET.ordinal
            )
        )
    ),
    LessonResponse(
        "",
        5,
        lessons = null,
        question = mapOf(
            "1" to Question(
                question = "whats the output? \n" +
                    "print(len(\"hello\"))",
                options = mapOf(
                    "1" to "6",
                    "2" to "5",
                    "3" to "Error"
                ),
                answerKey = "2"
            ),

            "2" to Question(
                question = "Whats the output?\n" +
                    "name = 'Wilson\"\n" +
                    "print(name[0]) ",
                options = mapOf(
                    "1" to "Error",
                    "2" to "Wilson",
                    "3" to "W"
                ),
                answerKey = "1"
            ),
            "3" to Question(
                question = "Whats the output?\n" +
                    "name = \"Pytutor\"\n" +
                    "print(name[0: len(name) - 1 ])",
                options = mapOf(
                    "1" to "Pytutor",
                    "2" to "Pytuto",
                    "3" to "Error"
                ),
                answerKey = "2"
            ),

            "4" to Question(
                question = "Which is used for multi-line Strings.",
                options = mapOf(
                    "1" to "''",
                    "2" to "\"\"",
                    "3" to "\"\"\" \"\"\" , ''' '''"
                ),
                answerKey = "3"
            )
        ),
        type = LessonResponseType.QUESTION.ordinal
    )
)
