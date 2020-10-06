package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 * Created by Ogheneruona Onobrakpeya on 9/11/20.
 */

val lists = listOf(
    LessonResponse(
        "",
        1,
        lessons = mapOf(
            "1" to Tutorial(
                1,
                "",
                "Lists are sequences which are used to hold any data type in Python.\n" +
                    "A distinguishing feature is their mutability, i.e. The elements of lists can be altered.\n" +
                    "Lists are also multidimensional which means a single list can hold different data types.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to Tutorial(
                2,
                "",
                "Lists are declared with square brackets ([]) in Python.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to Tutorial(
                3,
                "",
                "",
                CodeSnippet("", "listEx = [12, 13, 14]    # this is a list of 3 elements", ""),
                LessonTypes.CODE.ordinal
            ),

            "4" to Tutorial(
                4,
                "",
                "Indexing a List",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "5" to Tutorial(
                5,
                "",
                "In Python, elements of a list are accessed with square brackets, and indexing begins at 0 (the first element has an index of 0, not 1).",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "6" to Tutorial(
                6,
                "",
                "",
                CodeSnippet(
                    "To index listEx in the previous example:",
                    "listEx_1st = listEx[0]    # first element of listEx\n" +
                        "listEx_2nd = listEx[1]    # second element of listEx\n" +
                        "listEx_3rd = listEx[2]    # third element of listEx\n" +
                        "\n" +
                        "print(listEx_2nd)\n" +
                        "print(listEx_3rd)\n" +
                        "print(listEx_4th",
                    ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "7" to Tutorial(
                7,
                "",
                "",
                CodeSnippet(
                    "Output:", "12\n" +
                        "13\n" +
                        "14", ""
                ),
                LessonTypes.CODE.ordinal
            )
        ),
        question = null,
        type = LessonResponseType.LESSON.ordinal
    ),
    LessonResponse(
        "",
        2,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "Manipulating Lists",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Python provides some methods and functions which can be used to change the contents of a list and we’ll cover a few.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "listName.append(x): Adds the value of x to the end of the list.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "",
                CodeSnippet(
                    "", "to_append = a\n" +
                        "listEx.append(to_append)\n" +
                        "print(listEx)", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet("Output", "[12, 13, 14, 'a']", ""),
                LessonTypes.CODE.ordinal
            ),

            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "listName.remove(x): Removes the first occurrence of x from the list.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "",
                CodeSnippet(
                    "", "listEx.remove(13)\n" +
                        "print(listEx)\n", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "9" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                9,
                "",
                "",
                CodeSnippet("Output", "[12, 14, 'a']", ""),
                LessonTypes.CODE.ordinal
            ),

            "10" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                10,
                "",
                "listName.insert(index, x): Inserts the value of x into the list at the position of index.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "11" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                11,
                "",
                "",
                CodeSnippet(
                    "", "listEx.insert(2, 'afri')\n" +
                        "print(listEx)", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "12" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                12,
                "",
                "",
                CodeSnippet("Output", "[12, 14, 'afri', 'a']", ""),
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
                "listName.pop(x): Removes and returns the element at the index x. Acts on the last element by default.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "",
                CodeSnippet(
                    "", "popped = listEx.pop()\n" +
                        "print(popped)\n" +
                        "popped2 = listEx.pop(1)\n" +
                        "print(popped2)", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    "Output", "a\n" +
                        "14\n" +
                        "[12, 'afri']", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "listName.reverse(): Reverses the order of elements in the list.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    "", "listEx.reverse()\n" +
                        "print(listEx)", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "",
                CodeSnippet("Output", "['afri', 12]", ""),
                LessonTypes.CODE.ordinal
            ),

            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "len(listName): Returns the number of elements in the list.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "8" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                8,
                "",
                "",
                CodeSnippet(
                    "", "length = len(listEx)\n" +
                        "print(length)", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "9" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                9,
                "",
                "",
                CodeSnippet("Output", "2", ""),
                LessonTypes.CODE.ordinal
            )
        ),
        question = null,
        type = LessonResponseType.LESSON.ordinal
    ),

    LessonResponse(
        "",
        4,
        lessons = mapOf(
            "1" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                1,
                "",
                "Iterating over a List",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "The for-loop can be used to traverse over a list and perform different operations.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "",
                CodeSnippet(
                    "Syntax", "for x in listName:\n" +
                        "    # perform operations", "Here, x is the current element in the list."
                ),
                LessonTypes.CODE.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "",
                CodeSnippet(
                    "", "for i in listEx:\n" +
                        "print(i)", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    "Output", "afri\n" +
                        "12", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "“Slicing” means accessing a part of a list.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "",
                CodeSnippet(
                    "Syntax",
                    "listName[a:b]",
                    "This slices the list starting from index a and stopping at index b – 1."
                ),
                LessonTypes.CODE.ordinal
            ),

            "8" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                8,
                "",
                "",
                CodeSnippet(
                    "", "listEx2 = [5, 'afri', 8, 0, 'portal']\n" +
                        "print(listEx2[0:3])", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "9" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                9,
                "",
                "",
                CodeSnippet("Output", "[5, 'afri', 8]", ""),
                LessonTypes.CODE.ordinal
            )
        ),
        question = null,
        type = LessonResponseType.LESSON.ordinal
    ),

    LessonResponse(
        "",
        5,
        lessons = null,
        question = mapOf(
            "1" to Question(
                question = "colourList = [\"black\", \"red\", \"blue\", \"pink\", \"yellow\"]\n" +
                    "what is the index of blue in the list above?",
                options = mapOf(
                    "1" to "3",
                    "2" to "2",
                    "3" to "4"
                ),
                answerKey = "2"
            ),

            "2" to Question(
                question = "colourList.pop()\n" +
                    "what does this return?",
                options = mapOf(
                    "1" to "yellow",
                    "2" to "black",
                    "3" to "blue"
                ),
                answerKey = "1"
            ),
            "3" to Question(
                question = "Which of these is true?",
                options = mapOf(
                    "1" to "A list can contain several different data types.",
                    "2" to "A list can hold only one data type.",
                    "3" to "A list can hold only integers and strings."
                ),
                answerKey = "1"
            )
        ),
        type = LessonResponseType.QUESTION.ordinal
    )
)