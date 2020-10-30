package com.olabode.wilson.pytutor.files.lessons

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 *   Created by OLABODE WILSON on 9/12/20.
 */

val syntax = listOf(
    LessonResponse(
        "",
        1,
        lessons = mapOf(
            "1" to Tutorial(
                1,
                "",
                "This Topic illustrates some rules, syntax and common function used in python.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to Tutorial(
                2,
                "",
                "As you keep progressing you would get a better understanding of them.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to Tutorial(
                3,
                "",
                "A variable name is one example of an identifier.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "4" to Tutorial(
                4,
                "",
                "Identifiers have the following form:",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "5" to Tutorial(
                5,
                "",
                "Identifiers must contain at least one character.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "6" to Tutorial(
                6,
                "",
                "An identifier starts with a letter A to Z or a to z or an underscore (_) followed by zero or more letters, underscores and digits (0 to 9).",
                null,
                LessonTypes.BULLET.ordinal
            ),
            "7" to Tutorial(
                7,
                "",
                "Python does not allow punctuation characters such as @, \$, and % within identifiers.",
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
                "Python is a case sensitive programming language. i.e shapes and SHAPES are different Identifiers.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "A reserved word cannot be used as an identifier",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "Spaces aren't permitted in identifiers",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "Examples of valid identifiers:\n" +
                    "a, x1, age, shopping_list, FLAG, _count",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "Examples of Invalid identifiers\n" +
                    "shopping-list\n" +
                    "(dash is not a legal symbol in an identifier)\n" +
                    "\n" +
                    "class\n" +
                    "(class is a reserved word).\n" +
                    "\n" +
                    "first entry\n" +
                    "(space is not a legal symbol in an identifier),\n" +
                    "\n" +
                    "\$2 \n" +
                    "(Dollar sign is not a legal symbol in an identifier)",
                null,
                LessonTypes.TEXT.ordinal
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
                "Python reserves a number of words for special use, called reserved words or keywords.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "These words are special and are used to define the structure of Python programs and statements.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "There are 35 keywords in Python.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "and, del, from, None, try, as, elif, global, nonlocal, True, assert, else, if, not, while, break, except, import, or, with",
                null,
                LessonTypes.BULLET.ordinal
            ),
            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "class, False, in, pass, yield, continue, finally, is, raise, def, for, lambda, return",
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
                "Multi-Line Statements",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    header = "Statements in Python typically end with a new line. Python, however, allows the use of " +
                        "the line continuation character (\\) to denote that the line should continue.\nExample",
                    code = "total = value1 + \\\n" +
                        "value2 + \\\n" +
                        "value3",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    header = "The statements contained within the [ ], { } , or ( ) brackets do not need to use the line\n" +
                        "continuation character.",
                    code = "days = ['Monday', 'Tuesday', 'Wednesday',\n" +
                        "'Thursday', 'Friday']",

                    footer = ""
                ),
                LessonTypes.CODE.ordinal

            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "",
                CodeSnippet(
                    header = "Python accepts single ('), double (\") and triple (''' or \"\"\") quotes to denote string literals,\n" +
                        "as long as the same type of quote starts and ends the string.",
                    code = "name = 'toby'\n" +
                        "sentence = \"This is a sentence.\"\n" +
                        "paragraph = \"\"\"This is a paragraph. It is\n" +
                        "made up of multiple lines and sentences.\"\"\"",
                    footer = ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "Comments in Python",
                null,
                LessonTypes.TEXT.ordinal
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
                "Comments in Python",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "A hash sign (#) that is not inside a string literal is the beginning of a comment. All\n" +
                    "characters after the #, up to the end of the physical line, are part of the comment and the\n" +
                    "Python interpreter ignores them.",
                null,
                LessonTypes.BULLET.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "Python does not have multiple-line commenting feature. You have to comment each line\n" +
                    "individually.",
                CodeSnippet(
                    header = "",
                    code = "# This is a comment \n# Another comment",
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
                question = "Which combination is are not valid Python Keywords?",
                options = mapOf(
                    "1" to "raise, try, and",
                    "2" to "let, pass, break",
                    "3" to "def, class, continue"
                ),
                answerKey = "2"
            ),

            "2" to Question(
                question = "Which of the following combination Identifiers are valid ?",
                options = mapOf(
                    "1" to "A , _A , tel_no ",
                    "2" to "1A , tel-no, age",
                    "3" to "a g e , tel_no, age"
                ),
                answerKey = "1"
            ),
            "3" to Question(
                question = "Which Symbol is used to denote a Comment in Python?",
                options = mapOf(
                    "1" to "%",
                    "2" to "&",
                    "3" to "#"
                ),
                answerKey = "3"
            ),

            "4" to Question(
                question = "Python supports multi-line comments? ",
                options = mapOf(
                    "1" to "True",
                    "2" to "False",
                    "3" to "Not sure"
                ),
                answerKey = "2"
            ),
            "5" to Question(
                question = "Which function is used to display values to the console?",
                options = mapOf(
                    "1" to "print()",
                    "2" to "display()",
                    "3" to "console.log()"
                ),
                answerKey = "1"
            )
        ),
        type = LessonResponseType.QUESTION.ordinal
    )
)