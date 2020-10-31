package com.olabode.wilson.pytutor.files.exercises

import com.olabode.wilson.pytutor.models.remote.exercise.DIFFICULTY
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
                title = "Max of Three",
                question = "Implement a function that takes as input three variables, and returns the largest of the three. Do this without using the Python max() function!",
                solution = "def max_of_three(num1, num2, num3):\n" +
                        "\tif (num1 >= num2) and (num1 >= num3):\n" +
                        "   \t\tlargest = num1\n" +
                        "\telif (num2 >= num1) and (num2 >= num3):\n" +
                        "   \t\tlargest = num2\n" +
                        "\telse:\n" +
                        "   \t\tlargest = num3\n" +
                        "\n" +
                        "   \treturn largest"

        ),
        ExerciseResponse(
                title = "Convert Minutes into Seconds",
                question = "Write a function that takes an integer minutes and converts it to seconds.\n" +
                        "\n" +
                        "Examples\n" +
                        "convert(5) ➞ 300\n" +
                        "\n" +
                        "convert(3) ➞ 180\n" +
                        "\n" +
                        "convert(2) ➞ 120",
                solution = "def convert(minutes):\n" +
                        "\treturn minutes * 60"

        ),
        ExerciseResponse(
                title = "Find the Largest Number in a List",
                question = "Create a function that takes a list of numbers. Return the largest number in the list.\n" +
                        "This should be done without using the max() function." +
                        "\n" +
                        "Examples\n" +
                        "findLargestNum([4, 5, 1, 3]) ➞ 5\n" +
                        "\n" +
                        "findLargestNum([300, 200, 600, 150]) ➞ 600\n" +
                        "\n" +
                        "findLargestNum([1000, 1001, 857, 1]) ➞ 1001",

                solution = "def findLargestNum(nums):\n" +
                        "  largest = nums[0]\n" +
                        "  for i in nums:\n" +
                        "    if i > largest:\n" +
                        "      largest = i\n" +
                        "  return largest"

        ),
        ExerciseResponse(
                title = "Get the Sum of All List Elements",
                question = "Create a function that takes a list and returns the sum of all numbers in the list.\n" +
                        "This should be done without using the sum function" +
                        "\n" +
                        "Examples\n" +
                        "get_sum_of_elements([2, 7, 4]) ➞ 13\n" +
                        "\n" +
                        "get_sum_of_elements([45, 3, 0]) ➞ 48\n" +
                        "\n" +
                        "get_sum_of_elements([-2, 84, 23]) ➞ 105",

                solution = "def get_sum_of_elements(lst):\n" +
                        "\ta = 0\n" +
                        "\tfor i in lst:\n" +
                        "\t\ta += i\n" +
                        "\treturn a"

        ),
        ExerciseResponse(
                title = "Check Unique",
                question = "Write a Python function that takes a sequence of numbers and determines whether all the numbers are different from each other.\n" +
                        "\n" +
                        "Examples\n" +
                        "\n" +
                        "[1, 2, 3] ->  True\n" +
                        "[1, 2, 2] ->  False",

                solution = "def test_distinct(data):\n" +
                        "  if len(data) == len(set(data)):\n" +
                        "    return True\n" +
                        "  else:\n" +
                        "    return False\n\n" +
                        "print(test_distinct([1,5,7]))\n" +
                        "print(test_distinct([5,5,7,9]))"

        ),
        ExerciseResponse(
                title = "Display Triangular Pattern",
                question = "write a program to display a triangle pattern based on specified height.\n" +
                        "\n" +
                        "#\n" +
                        "##\n" +
                        "###\n" +
                        "####",
                solution = "height = 5\n" +
                        "for i in range(1 , height + 1):\n" +
                        "    print(\"#\" * i)\n" +
                        "\n" +
                        "\n"

        ),
        ExerciseResponse(
                title = "Check Leap Year",
                question = "A leap year is exactly divisible by 4 except for century years (years ending with 00). The century year is a leap year only if it is perfectly divisible by 400.\n" +
                        "\n" +
                        "For example,\n" +
                        "\n" +
                        "2017 is not a leap year\n" +
                        "1900 is a not leap year\n" +
                        "2012 is a leap year\n" +
                        "2000 is a leap year",

                solution = "# Python program to check if year is a leap year or not\n" +
                        "\n" +
                        "year = 2000\n" +
                        "\n" +
                        "\n" +
                        "if (year % 4) == 0:\n" +
                        "   if (year % 100) == 0:\n" +
                        "       if (year % 400) == 0:\n" +
                        "           print(\"{0} is a leap year\".format(year))\n" +
                        "       else:\n" +
                        "           print(\"{0} is not a leap year\".format(year))\n" +
                        "   else:\n" +
                        "       print(\"{0} is a leap year\".format(year))\n" +
                        "else:\n" +
                        "   print(\"{0} is not a leap year\".format(year))"

        ),

        ExerciseResponse(
                title = "Check Prime Number",
                question = "check whether an integer is a prime number\n " +
                        "\n" +
                        "What is a Prime Number?\n" +
                        "A positive integer greater than 1 which does not have other factors except 1 and the number itself is called a prime number." +
                        "The numbers 2, 3, 5, 7, etc. are prime numbers as they do not have any other factors.",

                solution = "num = 407\n" +
                        "\n" +
                        "# prime numbers are greater than 1\n" +
                        "if num > 1:\n" +
                        "   # check for factors\n" +
                        "   for i in range(2,num):\n" +
                        "       if (num % i) == 0:\n" +
                        "           print(num,\"is not a prime number\")\n" +
                        "           print(i,\"times\",num//i,\"is\",num)\n" +
                        "           break\n" +
                        "   else:\n" +
                        "       print(num,\"is a prime number\")\n" +
                        "       \n" +
                        "# if input number is less than\n" +
                        "# or equal to 1, it is not prime\n" +
                        "else:\n" +
                        "   print(num,\"is not a prime number\")"

        ),
        ExerciseResponse(
                title = "Display multiplication table from 1 to 10 ",
                question = "Write a program to display the whole multiplication table from 1 to 10\nOutput" +
                        "\n" +
                        " +----------------------------------------\n" +
                        " 1 |   1   2   3   4   5   6   7   8   9  10 \n" +
                        " 2 |   2   4   6   8  10  12  14  16  18  20 \n" +
                        " 3 |   3   6   9  12  15  18  21  24  27  30 \n" +
                        " 4 |   4   8  12  16  20  24  28  32  36  40 \n" +
                        " 5 |   5  10  15  20  25  30  35  40  45  50 \n" +
                        " 6 |   6  12  18  24  30  36  42  48  54  60 \n" +
                        " 7 |   7  14  21  28  35  42  49  56  63  70 \n" +
                        " 8 |   8  16  24  32  40  48  56  64  72  80 \n" +
                        " 9 |   9  18  27  36  45  54  63  72  81  90 \n" +
                        "10 |  10  20  30  40  50  60  70  80  90 100 ",

                solution = "print(\" +----------------------------------------\")\n" +
                        "for row in range(1, 11): # 1 <= row <= 10, table has 10 rows\n" +
                        "    if row < 10: # Need to add space?\n" +
                        "        print(\" \", end=\"\")\n" +
                        "    print(row, \"| \", end=\"\") # Print heading for this row.\n" +
                        "    for column in range(1, 11): # Table has 10 columns.\n" +
                        "        product = row*column # Compute product\n" +
                        "        if product < 100: # Need to add space?\n" +
                        "            print(end=\" \")\n" +
                        "        if product < 10: # Need to add another space?\n" +
                        "            print(end=\" \")\n" +
                        "        print(product, end=\" \") # Display product\n" +
                        "    print() # Move cursor to next row\n" +
                        "    \n",
                difficulty = DIFFICULTY.MEDIUM.ordinal

        ),
        ExerciseResponse(
                title = "Print the Fibonacci sequence",
                question = "A Fibonacci sequence is the integer sequence of 0, 1, 1, 2, 3, 5, 8....\n" +
                        "\n" +
                        "The first two terms are 0 and 1. All other terms are obtained by adding the preceding two terms. This means to say the nth term is the sum of (n-1)th and (n-2)th term.",
                solution = "nterms = 10 # number of terms\n" +
                        "\n" +
                        "# first two terms\n" +
                        "n1, n2 = 0, 1\n" +
                        "count = 0\n" +
                        "\n" +
                        "# check if the number of terms is valid\n" +
                        "if nterms <= 0:\n" +
                        "   print(\"Please enter a positive integer\")\n" +
                        "elif nterms == 1:\n" +
                        "   print(\"Fibonacci sequence upto\",nterms,\":\")\n" +
                        "   print(n1)\n" +
                        "else:\n" +
                        "   print(\"Fibonacci sequence:\")\n" +
                        "   while count < nterms:\n" +
                        "       print(n1)\n" +
                        "       nth = n1 + n2\n" +
                        "       # update values\n" +
                        "       n1 = n2\n" +
                        "       n2 = nth\n" +
                        "       count += 1",
                difficulty = DIFFICULTY.MEDIUM.ordinal

        ),
        ExerciseResponse(
                title = "Check Armstrong Number",
                question = "check whether an n-digit integer is an Armstrong number or not.\n" +
                        "Armstrong number is a number that is equal to the sum of cubes of its digits. For example 0, 1, 153, 370, 371 and 407 are the Armstrong numbers.\n" +
                        "Example:\n153 = 1*1*1 + 5*5*5 + 3*3*3  // 153 is an Armstrong number.",
                solution = "num = 370\n" +
                        "\n" +
                        "# initialize sum\n" +
                        "sum = 0\n" +
                        "\n" +
                        "# find the sum of the cube of each digit\n" +
                        "temp = num\n" +
                        "while temp > 0:\n" +
                        "   digit = temp % 10\n" +
                        "   sum += digit ** 3\n" +
                        "   temp //= 10\n" +
                        "\n" +
                        "# display the result\n" +
                        "if num == sum:\n" +
                        "   print(num,\"is an Armstrong number\")\n" +
                        "else:\n" +
                        "   print(num,\"is not an Armstrong number\")",
                difficulty = DIFFICULTY.MEDIUM.ordinal

        ),
        ExerciseResponse(
                title = "Find the Factorial of a Number",
                question = "The factorial of a number is the product of all the integers from 1 to that number.\n" +
                        "\n" +
                        "For example:\nThe factorial of 6 is 1*2*3*4*5*6 = 720.\nFactorial is not defined for negative numbers, and the factorial of zero is one, 0! = 1.",
                solution = "num = 7\n" +
                        "\n" +
                        "factorial = 1\n" +
                        "\n" +
                        "# check if the number is negative, positive or zero\n" +
                        "if num < 0:\n" +
                        "   print(\"Sorry, factorial does not exist for negative numbers\")\n" +
                        "elif num == 0:\n" +
                        "   print(\"The factorial of 0 is 1\")\n" +
                        "else:\n" +
                        "   for i in range(1,num + 1):\n" +
                        "       factorial = factorial*i\n" +
                        "   print(\"The factorial of\",num,\"is\",factorial)"

        ),
        ExerciseResponse(
                title = "Check Palindrome number",
                question = "A palindrome is nothing but any number or a string which remains unaltered when reversed.\nExample\n" +
                        "121, 12321",
                solution = "num = 6 \n" +
                        "temp = num\n" +
                        "rev = 0\n" +
                        "while(num > 0):\n" +
                        "    dig = num % 10\n" +
                        "    rev = rev * 10 + dig\n" +
                        "    num = num // 10\n" +
                        "if(temp == rev):\n" +
                        "    print(\"The number is palindrome!\")\n" +
                        "else:\n" +
                        "    print(\"Not a palindrome!\")"

        ),
        ExerciseResponse(
                title = "Reverse a number",
                question = "Write a program to reverse a number\n" +
                        "Example:\n" +
                        "123\n" +
                        "\n" +
                        "Output:\n" +
                        "321",
                solution = "\n" +
                        "num = 123\n" +
                        "\n" +
                        "\n" +
                        "test_num = 0\n" +
                        " \n" +
                        "# Check using while loop\n" +
                        " \n" +
                        "while(num>0):\n" +
                        "  #Logic\n" +
                        "  remainder = num % 10\n" +
                        "  test_num = (test_num * 10) + remainder\n" +
                        "  num = num//10\n" +
                        " \n" +
                        "# Display the result\n" +
                        "print(\"The reverse number is : {}\".format(test_num))"

        ),
        ExerciseResponse(
                title = "Concatenate All Elements in a List",
                question = "Write a Python program to concatenate all elements in a list into a string and return it.",
                solution = "def concatenate_list(sampleList):\n" +
                        "    result= \"\"\n" +
                        "    for element in sampleList:\n" +
                        "        result += str(element)\n" +
                        "    \n" +
                        "    return result\n" +
                        "\n" +
                        "print(concatenate_list([\"three\", 5, \"blue\", \"low\"]))"

        ),
        ExerciseResponse(
                title = "Find the LCM of Two Positive Numbers",
                question = "Write a Python program to get the least common multiple (LCM) of two positive integers.",
                solution = "def lcm(x, y):\n" +
                        "   if x > y:\n" +
                        "       z = x\n" +
                        "   else:\n" +
                        "       z = y\n" +
                        "\n" +
                        "   while(True):\n" +
                        "       if((z % x == 0) and (z % y == 0)):\n" +
                        "           lcm = z\n" +
                        "           break\n" +
                        "       z += 1\n" +
                        "\n" +
                        "   return lcm\n" +
                        "\n" +
                        "print(lcm(4, 7))"

        ),
        ExerciseResponse(
                title = "Find the GCD of Two Positive Numbers",
                question = "Write a Python program to compute the greatest common divisor (GCD) of two positive integers.",
                solution = "def gcd(x, y):\n" +
                        "    gcd = 1\n" +
                        "    \n" +
                        "    if x % y == 0:\n" +
                        "        return y\n" +
                        "    \n" +
                        "    for i in range(int(y / 2), 0, -1):\n" +
                        "        if x % i == 0 and y % i == 0:\n" +
                        "            gcd = i\n" +
                        "            break \n" +
                        "         \n" +
                        "    return gcd\n" +
                        "\n" +
                        "print(gcd(12, 16))"

        ),
        ExerciseResponse(
                title = "Calculate the Distance between 2 Points",
                question = "Write a Python program to compute the distance between the points (x1, y1) and (x2, y2).",
                solution = "import math\n" +
                        "p1 = [4, 2]\n" +
                        "p2 = [5, 5]\n" +
                        "distance = math.sqrt( (p1[0]-p2[0])**2 + (p1[1]-p2[1])**2 ) \n" +
                        "\n" +
                        "print(distance)"

        ),
        ExerciseResponse(
                title = "Calculate the Sum of the Digits in an Integer",
                question = " Write a Python program to calculate the sum of the digits in a 4 digit integer.",
                solution = "num = int(input(\"Input a four digit numbers: \"))\n" +
                        "x  = num // 1000\n" +
                        "x1 = (num - x*1000) // 100\n" +
                        "x2 = (num - x*1000 - x1*100) // 10\n" +
                        "x3 = num - x*1000 - x1*100 - x2*10\n" +
                        "print(f\"The sum of digits in the number is {x+x1+x2+x3}\")"

        ),
        ExerciseResponse(
                title = "Check if a Word is a Palindrome",
                question = "Write a program which checks if a string is a palindrome.",
                solution = "def palindrome(word):\n" +
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
                        "main()\n"

        ),
        ExerciseResponse(
                title = "Find the Midpoint of a Line",
                question = "Write a Python program to calculate midpoints of a line.",
                solution = "x1 = float(input(\"The value of x1: \"))\n" +
                        "y1 = float(input(\"The value of y1: \"))\n" +
                        "print()\n" +
                        "x2 = float(input(\"The value of x2: \"))\n" +
                        "y2 = float(input(\"The value of y2: \"))\n" +
                        "\n" +
                        "xMidPoint = (x1 + x2)/2\n" +
                        "yMidPoint = (y1 + y2)/2\n" +
                        "\n" +
                        "print()\n" +
                        "print(f\"The midpoint's x value is: {xMidPoint}\")\n" +
                        "print(f\"The midpoint's y value is: {yMidPoint}\")"

        ),
        ExerciseResponse(
                title = "Find the Character Count in a String",
                question = "Write a Python program to count the number of occurrence of a specific character in a string.",
                solution = "def charCount(word, char):\n" +
                        "    count = 0\n" +
                        "    for c in word:\n" +
                        "        if char == c:\n" +
                        "            count += 1\n" +
                        "\n" +
                        "    return count \n" +
                        "\n" +
                        "sampleWord = \"The quick brown fox jumps over the lazy dog.\"\n" +
                        "print(charCount(sampleWord, \"o\"))"

        ),
        ExerciseResponse(
                title = "Swap Two Variables",
                question = "Write a program to swap two variables.",
                solution = "a = \"first\"\n" +
                        "b = \"second\"\n" +
                        "\n" +
                        "print(\"Before the swap:\")\n" +
                        "print(f\"a = {a}\")\n" +
                        "print(f\"b = {b}\")\n" +
                        "\n" +
                        "temp = a\n" +
                        "a = b\n" +
                        "b = temp\n" +
                        "\n" +
                        "print()\n" +
                        "print(\"After the swap:\")\n" +
                        "print(f\"a = {a}\")\n" +
                        "print(f\"b = {b}\")"

        ),
        ExerciseResponse(
                title = "Filter Positive Numbers from a List",
                question = "Write a Python program to filter the positive numbers from a list.",
                solution = "def posFilter(sampleList):\n" +
                        "    posList = []\n" +
                        "\n" +
                        "    for num in sampleList:\n" +
                        "        if num % 2 == 0:\n" +
                        "            posList.append(num)\n" +
                        "    \n" +
                        "    return posList\n" +
                        "\n" +
                        "numList = [1, 2, 7, 9, 2, 4, 6]\n" +
                        "print(posFilter(numList))"

        ),
        ExerciseResponse(
                title = "Check if a Number is Divisible by Another",
                question = "Write a Python function to check whether a number is divisible by another without a remainder.",
                solution = "def isDivisible(num, den):\n" +
                        "    if num % den == 0:\n" +
                        "        return True\n" +
                        "    \n" +
                        "    return False\n" +
                        "\n" +
                        "numerator = int(input(\"Enter the numerator: \"))\n" +
                        "denominator = int(input(\"Enter the denominator: \"))\n" +
                        "\n" +
                        "print(isDivisible(numerator, denominator))"

        ),
        ExerciseResponse(
                title = "Implement the Pythagorean Theorem",
                question = "Implement the Pythagorean Theorem to find the length of the hypotenuse of a triangle when given the other two sides.",
                solution = "import math\n" +
                        "\n" +
                        "def hyp(sideA, sideB):\n" +
                        "    return math.sqrt(sideA**2 + sideB**2)\n" +
                        "\n" +
                        "a = float(input(\"Enter the length of side A: \"))\n" +
                        "b = float(input(\"Enter the length of side B: \"))\n" +
                        "print(f\"The hypotenuse of the triangle is {hyp(a, b)}\")"

        ),
        ExerciseResponse(
                title = "FizzBuzz Challenge",
                question = "Write a Python program which iterates the integers from 1 to 100. For multiples of three print \"Fizz\" instead of the number and for the multiples of five print \"Buzz\". For numbers which are multiples of both three and five print \"FizzBuzz\".",
                solution = "for number in range(1, 101):\n" +
                        "    if number % 3 == 0 and number % 5 == 0:\n" +
                        "        print(\"FizzBuzz\")\n" +
                        "    elif number % 3 == 0:\n" +
                        "        print(\"Fizz\")\n" +
                        "    elif number % 5 == 0:\n" +
                        "        print(\"Buzz\")\n"

        ),
        ExerciseResponse(
                title = "Print Even Numbers",
                question = "Print the even numbers from 1 to 100.",
                solution = "def checkEven(num):\n" +
                        "    if num % 2 == 0:\n" +
                        "        return True\n" +
                        "    else:\n" +
                        "        return False\n" +
                        "\n" +
                        "for num in range(1, 101):\n" +
                        "    if checkEven(num):\n" +
                        "        print(num)"

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