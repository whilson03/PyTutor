package com.olabode.wilson.pytutor.files.exercises

import com.olabode.wilson.pytutor.models.Exercise
import com.olabode.wilson.pytutor.models.remote.exercise.ExerciseResponse

/**
 * Created by Ogheneruona Onobrakpeya on 10/13/20.
 */

fun listOfExercises () = listOf<ExerciseResponse> (
    ExerciseResponse("1", "Palindrome check", "Easy", "Write a program which checks if a word is a palindrome.", "def palindrome(word):\n" +
        "    left = 0\n" +
        "    right = len(word) - 1\n" +
        "\n" +
        "    while left < right:\n" +
        "        if word[left] != word[right]:\n" +
        "            return False\n" +
        "        left += 1\n" +
        "        right -= 1\n" +
        "\n" +
        "    return True\n" +
        "\n" +
        "def main():\n" +
        "    word = input(\"Enter a word\\n\")\n" +
        "\n" +
        "    if palindrome(word):\n" +
        "        print(f\"{word} is a palindrome\")\n" +
        "    else:\n" +
        "        print(f\"{word} is not a palindrome\")\n" +
        "\n" +
        "main()")

)