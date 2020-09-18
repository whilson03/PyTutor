package com.olabode.wilson.pytutor.files

import com.olabode.wilson.pytutor.models.tutorial.*
import com.olabode.wilson.pytutor.ui.tutorial.adapters.LessonTypes

/**
 * Created by Ogheneruona Onobrakpeya on 9/12/20.
 */

val dictionaries = listOf(
        LessonResponse(
                1,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "In Python, dictionaries are data structures used to hold data in a key-value pair.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "Unlike lists and tuples, dictionaries are not ordered. \n" +
                                        "This means their elements are not guaranteed to be arranged in the same order the are stored.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "Due to this property, indexing isn't possible with dictionaries.\n" +
                                        "To obtain values, their corresponding keys are used.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet("Structure of a Dictionary", "dictTest = {\n" +
                                        "    key: value,\n" +
                                        "    key: value,\n" +
                                        "    key: value\n" +
                                        "}", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "Almost any Python data type can be a dictionary key as long as it is immutable. Thus lists cannot be keys.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "Additionally, keys are unique meaning they can appear only once in a dictionary.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "7" to Lesson(
                                7,
                                "",
                                "These restrictions do not apply to values as they can be mutable and appear multiple times in a dictionary.",
                                null,
                                LessonTypes.TEXT.ordinal
                        )
                )
        ),


        LessonResponse(
                2,
                lessons = mapOf(
                        "1" to Lesson(
                                1,
                                "",
                                "Creating a Dictionary",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "Dictionaries are created with curly braces ({})",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet("", "clientInfo = {\"firstName\": \"John\", \"lastName\": \"Doe\", \"gender\": \"Male\", \"age\": 32}", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "clientInfo is a dictionary whose keys are \"firstName\", \"lastName\", \"gender\" and \"age\" respectively.\n" +
                                        "Their corresponding values are \"John\", \"Doe\", \"Male\" and 32.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "To access the values of clientInfo, use the keys as indexes:",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "",
                                CodeSnippet("", "print(clientInfo[\"firstName\"])\n" +
                                        "print(clientInfo[\"lastName\"])\n" +
                                        "print(clientInfo[\"gender\"])\n" +
                                        "print(clientInfo[\"age\"])", ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "7" to Lesson(
                                7,
                                "",
                                "",
                                CodeSnippet("Output", "John\n" +
                                        "Doe\n" +
                                        "Male\n" +
                                        "32", ""
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
                                "Dictionary Operations",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "Dictionaries have 3 methods which are used to access keys and values in a list format.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "keys(): Returns an array of a dictionary's keys.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet("", "print(clientInfo.keys())", ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet("Output", "['lastName', 'age', 'firstName', 'gender']", ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "values(): Returns an array of a dictionary's values.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "7" to Lesson(
                                7,
                                "",
                                "",
                                CodeSnippet("", "print(clientInfo.values())", ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "8" to Lesson(
                                8,
                                "",
                                "",
                                CodeSnippet("Output", "['Doe', 32, 'John', 'Male']", ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "9" to Lesson(
                                9,
                                "",
                                "items(): Returns an array of both a dictionary's keys and values.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "10" to Lesson(
                                10,
                                "",
                                "",
                                CodeSnippet("", "print(clientInfo.items())", ""
                                ),
                                LessonTypes.CODE.ordinal
                        ),

                        "11" to Lesson(
                                11,
                                "",
                                "",
                                CodeSnippet("Output", "[('lastName', 'Doe'), ('age', 32), ('firstName', 'John'), ('gender', 'Male')]", ""
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
                                "get(): Takes two parameters, key and default value and returns the value at \"key\". If the specified key does not exist, the default value is returned instead.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet("", "print(clientInfo.get(\"age\", 18))", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet("Output", "32", "32 is returned since it is the value of \"age\"."),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet("Let's try an invalid key:", "print(clientInfo.get(\"height\", 170))", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet("Output", "170", "170 is returned because no such key called \"height\" exists in clientInfo."),
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
                                "setdefault(): Takes two parameters, \"key\" and \"default value\" and creates a new element with them only if the key does not exist.",
                                null,
                                LessonTypes.TEXT.ordinal
                        ),

                        "2" to Lesson(
                                2,
                                "",
                                "",
                                CodeSnippet("", "clientInfo.setdefault(\"weight\", 70)\n" +
                                        "print(clientInfo)", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "3" to Lesson(
                                3,
                                "",
                                "",
                                CodeSnippet("Output", "{'lastName': 'Doe', 'age': 32, 'weight': 70, 'firstName': 'John', 'gender': 'Male'}", "A new key \"weight\" was created with the value \"70\"."),
                                LessonTypes.CODE.ordinal
                        ),

                        "4" to Lesson(
                                4,
                                "",
                                "",
                                CodeSnippet("To add or change an existing key's value, use square braces to access the key.", "clientInfo[\"lastName\"] = \"Smith\"\n" +
                                        "print(clientInfo)", ""),
                                LessonTypes.CODE.ordinal
                        ),

                        "5" to Lesson(
                                5,
                                "",
                                "",
                                CodeSnippet("Output", "{'lastName': 'Smith', 'age': 32, 'weight': 70, 'firstName': 'John', 'gender': 'Male'}", "lastName was changed from \"Doe\" to \"Smith\""),
                                LessonTypes.CODE.ordinal
                        ),

                        "6" to Lesson(
                                6,
                                "",
                                "Because they don't make use of numerical indexes and are unordered, operations such as slicing cannot be performed on dictionaries.",
                                null,
                                LessonTypes.TEXT.ordinal
                        )

                ),
                question = null,
                type = LessonResponseType.LESSON.ordinal
        ),

        LessonResponse(
                4,
                lessons = null,
                question = mapOf(
                        "1" to Question(
                                question = "Which of these cannot be a dictionary key?",
                                options = mapOf(
                                        "1" to "Tuple",
                                        "2" to "List",
                                        "3" to "String"
                                ),
                                answerKey = "2"
                        ),

                        "2" to Question(
                                question = "Which of these is not a valid way of adding data to a dictionary?",
                                options = mapOf(
                                        "1" to "userInfo[\"name\"] = \"Paul\"",
                                        "2" to "userInfo = {\"name\": \"Paul\", \"age\": 32}",
                                        "3" to "userInfo = [\"name\": \"Paul\", \"age\": 32]"
                                ),
                                answerKey = "3"
                        ),

                        "3" to Question(
                                question = "Which command returns boths the keys and values of a dictionary?",
                                options = mapOf(
                                        "1" to "dict.all()",
                                        "2" to "dict.items()",
                                        "3" to "dict.data()"
                                ),
                                answerKey = "2"
                        )
                ),
                type = LessonResponseType.QUESTION.ordinal
        )
)