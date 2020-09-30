package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponse
import com.olabode.wilson.pytutor.models.remote.tutorial.LessonResponseType
import com.olabode.wilson.pytutor.models.tutorial.CodeSnippet
import com.olabode.wilson.pytutor.models.tutorial.Question
import com.olabode.wilson.pytutor.models.tutorial.Tutorial
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 * Created by Ogheneruona Onobrakpeya on 9/12/20.
 */

val tuples = listOf(
    LessonResponse(
        "",
        1,
        lessons = mapOf(
            "1" to Tutorial(
                1,
                "",
                "Similar to lists, tuples are data structures which are used to hold elements in Python.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to Tutorial(
                2,
                "",
                "Like lists, they are also ordered and multidimensional.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to Tutorial(
                3,
                "",
                "The key difference however, is that while lists are mutable, tuples are not.\n" +
                    "This means that the elements of tuples cannot be altered after creation.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "4" to Tutorial(
                4,
                "",
                "Tuples are declared with parenthesis (()).",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "5" to Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    "Creating a tuple.", "tupleEx = (5, 4, 2, 5, 9, 4)\n" +
                        "print(tupleEx)\n" +
                        "tupleEx2 = (\"a\", \"d\", \"e\", \"f\")\n" +
                        "print(tupleEx2)\n" +
                        "tupleEx3 = (\"a\", 10, 23, \"d\", 14, \"e\", \"f\")\n" +
                        "print(tupleEx3)", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "6" to Tutorial(
                6,
                "",
                "",
                CodeSnippet(
                    "Output", "(5, 4, 2, 5, 9, 4)\n" +
                        "(\"a\", \"d\", \"e\", \"f\")\n" +
                        "(\"a\", 10, 23, \"d\", 14, \"e\", \"f\")", ""
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
                "Creating a Tuple with One Element",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Constructing a tuple with a single element requires an extra step.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "Try creating one as before.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "",
                CodeSnippet(
                    "", "test_tuple = (\"binder\")\n" +
                        "print(type(test_tuple))", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet("Output", "<class 'str'>", ""),
                LessonTypes.CODE.ordinal
            ),

            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "As seen above, a tuple declaration with a single element isn’t a tuple at all, but it takes the type of the element, in this case, string.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "To make it a tuple, you have to append a comma after the element.",
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
                "Operations with Tuples",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Tuples has most operations applicable to lists except those which modify elements.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "You shouldn’t expect to be able to use append, insert, remove, and pop.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "Like lists, elements of tuples can be accessed by indexing, slicing, and looping through.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "5" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                5,
                "",
                "",
                CodeSnippet(
                    "", "test_tuple = (\"binder\", 42, \"talk\", 7)\n" +
                        "print(test_tuple[3])    # indexing\n" +
                        "print()\n" +
                        "print(test_tuple[:])    # slicing \n" +
                        "print()\n" +
                        "for i in test_tuple:    # looping\n" +
                        "    print(i)", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "6" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                6,
                "",
                "",
                CodeSnippet(
                    "Output", "7\n" +
                        "\n" +
                        "('binder', 42, 'talk', 7)\n" +
                        "\n" +
                        "binder\n" +
                        "42\n" +
                        "talk\n" +
                        "7", ""
                ),
                LessonTypes.CODE.ordinal
            ),

            "7" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                7,
                "",
                "len(tupleName): Returns the number of elements in the tuple.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "8" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                8,
                "",
                "",
                null,
                LessonTypes.TEXT.ordinal
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
                "Why use Tuples?",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "2" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                2,
                "",
                "Tuples may seem to be just less flexible forms of lists, but they also have their use cases.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "3" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                3,
                "",
                "For a constant set of values which you have no plans of changing in the future, tuples are preferred as they are much faster than lists.",
                null,
                LessonTypes.TEXT.ordinal
            ),

            "4" to com.olabode.wilson.pytutor.models.tutorial.Tutorial(
                4,
                "",
                "Also, dictionaries require immutable data as keys for which tuples can be used unlike lists.",
                null,
                LessonTypes.TEXT.ordinal
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
                question = "Which is false?",
                options = mapOf(
                    "1" to "Tuples are immutable.",
                    "2" to "Tuples are multidimensional.",
                    "3" to "Tuples are unordered."
                ),
                answerKey = "3"
            ),

            "2" to Question(
                question = "What is used to create tuples?",
                options = mapOf(
                    "1" to "Parenthesis.",
                    "2" to "Square braces.",
                    "3" to "Curly braces."
                ),
                answerKey = "1"
            ),
            "3" to Question(
                question = "Can tuples be sliced?",
                options = mapOf(
                    "1" to "No.",
                    "2" to "Yes.",
                    "3" to "Kinda."
                ),
                answerKey = "1"
            )
        ),
        type = LessonResponseType.QUESTION.ordinal
    )
)