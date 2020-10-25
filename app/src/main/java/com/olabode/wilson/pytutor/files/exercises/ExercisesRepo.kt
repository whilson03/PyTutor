package com.olabode.wilson.pytutor.files.exercises

import com.olabode.wilson.pytutor.models.remote.exercise.ExerciseResponse

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */

fun listOfExercises() = listOf<ExerciseResponse>(
        ExerciseResponse(
                title = "Check Even",
                question = "Determine if a number is an Even Number.\nAn Even Number is one that is divisible by 2 without a remainder." +
                        "\nE.g: 2 ,4 ,6 ... ",
                solution = "num = 8\n" +
                        "if num % 2 == 0:\n" +
                        "    print(num, \"is Even\")\n" +
                        "else:\n" +
                        "    print(num , \"is Odd\")\n"
        ),
        ExerciseResponse(
                title = "Calculate Area of Circle",
                question = "Write a Python program which accepts the radius of a circle from the user and compute the area.",
                solution = "from math import pi\n" +
                        "radius = float(input (\"Input the radius of the circle : \"))\n" +
                        "print (\"The area of the circle with radius \" + str(radius) + \" is: \" + str(pi * radius ** 2))\n"

        ),
        ExerciseResponse(
                title = "Check Vowels",
                question = "Write a Python program to test whether a passed letter is a vowel or not.\nVowels are: a, e, i, o, u",
                solution = "def is_vowel(char):\n" +
                        "    all_vowels = 'aeiou'\n" +
                        "    return char in all_vowels\n" +
                        "print(is_vowel('c'))"

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        ),
        ExerciseResponse(
                title = "",
                question = "",
                solution = ""

        )


)