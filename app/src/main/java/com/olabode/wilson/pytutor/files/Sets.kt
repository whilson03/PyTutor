package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.tutorial.*
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 * Created by Ogheneruona Onobrakpeya on 9/13/20.
 */

val sets = listOf(
        LessonResponse(
                1,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "Sets are the fourth and last data structure we will cover.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "A set is a collection of unordered unique and mutable data.    ",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "As it is unique, no value can appear more than once.\n" +
                                        "Sets can also not be indexed because they are unordered.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "Creating a Set",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet("Sets are created with curly braces or the \"set\" keyword.", "colourSet = {\"black\", \"blue\", \"red\", \"green\", \"white\"}\n" +
                                "colourSet2 = set([\"black\", \"brown\", \"red\", \"yellow\", \"grey\"])", ""),
                                LessonTypes.CODE.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),

        LessonResponse(
                2,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "Set Operations",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "Adding values to a Set",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet("", "colourSet.add(\"purple\")\n" +
                                        "print(colourSet)", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet("Output", "set(['blue', 'green', 'purple', 'black', 'white', 'red'])", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet("Trying to add an existing value to the set does nothing.", "colourSet.add(\"black\")\n" +
                                        "print(colourSet)", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet("", "set(['blue', 'green', 'purple', 'black', 'white', 'red'])", "No changes made to the set values."),
                                LessonTypes.CODE.ordinal
                        ),

                        "7" to Lesson(
                                7,
                                "",
                                "x.union(y): Returns a set which is a combination of the elements in sets x and y without repetition.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "8" to Lesson(
                                8,
                                "",
                                "",
                                CodeSnippet("", "colourSet3 = colourSet.union(colourSet2)\n" +
                                        "print(colourSet3)", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "9" to Lesson(
                                9,
                                "",
                                "",
                                CodeSnippet("Output", "set(['blue', 'brown', 'grey', 'yellow', 'purple', 'black', 'green', 'white', 'red'])", "\"black\" and \"red\" aren't repeated."),
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
                                "x.intersection(y): Returns a set which has the common elements of sets x and y.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet("", "print(colourSet.intersection(colourSet2))", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet("Output", "set(['black', 'red'])", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "x.difference(y): Returns a set of the values present in set x but not y.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet("", "print(colourSet.difference(colourSet2))", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet("Output", "set(['blue', 'green', 'purple', 'black', 'white', 'red'])", ""),
                                LessonTypes.CODE.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),

        LessonResponse(
                4,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "Frozen Sets",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "These are the immutable versions of sets.\n" +
                                        "Their values cannot be changed after creation.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "Creation of Frozen Sets",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet("Frozen sets can be created with the \"frozenset\" keyword from scratch or from already existing sets.", "frozenColourSet = frozenset([\"red\", \"blue\", \"green\", \"yellow\"])\n" +
                                        "frozenColourSet2 = frozenset(colourSet)\n" +
                                        "print(frozenColourSet)\n" +
                                        "print(frozenColourSet2)", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet("Adding or modifying the elements of a frozen set yields an error.", "frozenColourSet.add(\"pink\")", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet("Output", "AttributeError: 'frozenset' object has no attribute 'add'", ""),
                                LessonTypes.CODE.ordinal
                        )
                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),

        LessonResponse(
                5,
                lessons = null,
                question = mapOf(
                        "1" to Question(
                                question = "Sets are ordered.",
                                options = mapOf(
                                        "1" to "True",
                                        "2" to "False",
                                        "3" to "Sometimes"
                                ),
                                answerKey = "2"
                        ),

                        "2" to Question(
                                question = "What is a difference between a set and a list?",
                                options = mapOf(
                                        "1" to "Lists can have duplicate values unlike sets",
                                        "2" to "Lists are mutable and sets are not",
                                        "3" to "Sets are multidimensional but lists are not"
                                ),
                                answerKey = "1"
                        ),
                        "3" to Question(
                                question = "",
                                options = mapOf(
                                        "1" to "",
                                        "2" to "",
                                        "3" to ""
                                ),
                                answerKey = "1"
                        ),

                        "4" to Question(
                                question = "",
                                options = mapOf(
                                        "1" to "",
                                        "2" to "",
                                        "3" to ""
                                ),
                                answerKey = "2"
                        ),
                        "5" to Question(
                                question = "What methods returns the combination of two sets?",
                                options = mapOf(
                                        "1" to "intersection",
                                        "2" to "union",
                                        "3" to "difference"
                                ),
                                answerKey = "2"
                        )
                ),
                type = LessonResponseType.QUESTION.ordinal
        )
)