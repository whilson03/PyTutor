package com.olabode.wilson.pytutor.fragment_exercises;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.activities.ExercisesReaderActivity;
import com.olabode.wilson.pytutor.adapters.ExercisesAdapter;
import com.olabode.wilson.pytutor.classes.Exercises;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FunctionsFragment extends Fragment {


    public FunctionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.exercises_list_view, container, false);

        final ArrayList<Exercises> exercisesList = new ArrayList<>();

        exercisesList.add(new Exercises("Fucntion to check if a number is prime", "Fucntion to check if a number is prime\n" +
                "def checkPrime(num):",
                "def checkPrime(num):\n" +
                        "\t# num = int(input(\"Enter a number: \"))\n" +
                        "\n" +
                        "\t# prime numbers are greater than 1\n" +
                        "\tif num > 1:\n" +
                        "\t   # check for factors\n" +
                        "\t   for i in range(2,num):\n" +
                        "\t       if (num % i) == 0:\n" +
                        "\t           print(num,\"is not a prime number\")\n" +
                        "\t           print(i,\"times\",num//i,\"is\",num)\n" +
                        "\t           break\n" +
                        "\t   else:\n" +
                        "\t       print(num,\"is a prime number\")\n" +
                        "\t       \n" +
                        "\t# if input number is less than\n" +
                        "\t# or equal to 1, it is not prime\n" +
                        "\telse:\n" +
                        "\t   print(num,\"is not a prime number\")"));


        exercisesList.add(new Exercises("count String length", "create a function that takes a string and returns" +
                "the lenght of the string\ndef countString(word):", "" +
                "def countString(word):\n" +
                "    count = 0\n" +
                "    for i in word:\n" +
                "        count += 1\n" +
                "    return count\n" +
                "\n" +
                "print(countString(\"HEllo\"))\n" +
                "\n" +
                "        "
        ));

        exercisesList.add(new Exercises("Check even", "create a function that checks if a number is even and return either true" +
                "or false", "def isEven(num):\n" +
                "    if num % 2 == 0:\n" +
                "        return True\n" +
                "    else:\n" +
                "        return False\n" +
                "\n" +
                "print(isEven(4))\n"));

        exercisesList.add(new Exercises("Check if String is Palindrome", "A string is said to be palindrome if reverse of the string is same as string. For example, “radar” is" +
                " palindrome, but “radix” is not palindrome.\ndef isPalindrome(str):", "# function to check string is \n" +
                "# palindrome or not \n" +
                "def isPalindrome(str): \n" +
                "\n" +
                "\t# Run loop from 0 to len/2 \n" +
                "\tfor i in xrange(0, len(str)/2): \n" +
                "\t\tif str[i] != str[len(str)-i-1]: \n" +
                "\t\t\treturn False\n" +
                "\treturn True\n"));

        exercisesList.add(new Exercises("Reverse String", "create a function that can return the reverse of a given s" +
                "tring\nE.G : HELLO\n OUTPUT: OLLEH\n" +
                "def reverseString(str):", "def reverseString(string):\n" +
                "    return string[::-1]\n" +
                "\n" +
                "print(reverseString(\"hello\"))\n"
        ));

        exercisesList.add(new Exercises("Calculate Factorial", "Write a Python function to calculate the factorial of a number (a non-negative integer). " +
                "The function accepts the number as an argument", "def factorial(n):\n" +
                "    if n == 0:\n" +
                "        return 1\n" +
                "    else:\n" +
                "        return n * factorial(n-1)\n" +
                "n=int(input(\"Input a number to compute the factiorial : \"))\n" +
                "print(factorial(n))"));

        exercisesList.add(new Exercises("Check square of numbers", "Write a Python function to create and print a list where the values" +
                " are square of numbers between 1 and 30 (both included", "def printValues():\n" +
                "\tl = list()\n" +
                "\tfor i in range(1,21):\n" +
                "\t\tl.append(i**2)\n" +
                "\tprint(l)\n" +
                "\t\t\n" +
                "printValues()"));

        exercisesList.add(new Exercises("Detect local variables", "Write a Python program to detect the number" +
                " of local variables declared in a function", "" +
                "def detectLocalVar():\n" +
                "    x = 1\n" +
                "    y = 2\n" +
                "    str1= \"wilson\"\n" +
                "    print(\"Python Exercises\")\n" +
                "\n" +
                "print(detectLocalVar.__code__.co_nlocals)"));

        exercisesList.add(new Exercises("Max of three numbers", "Write a Python function to find the Max of three numbers.",
                "def max_of_two( x, y ):\n" +
                        "    if x > y:\n" +
                        "        return x\n" +
                        "    return y\n" +
                        "def max_of_three( x, y, z ):\n" +
                        "    return max_of_two( x, max_of_two( y, z ) )\n" +
                        "print(max_of_three(3, 6, -5))\n"
        ));

        exercisesList.add(new Exercises("Multiply all the numbers in a list\n", "Write a Python function to multiply all the numbers in a list" +
                "\nSample List : (8, 2, 3, -1, 7)\n" +
                "Expected Output : -336 \n", "def multiply(numbers):  \n" +
                "    total = 1\n" +
                "    for x in numbers:\n" +
                "        total *= x  \n" +
                "    return total  \n" +
                "print(multiply((8, 2, 3, -1, 7)))"
        ));

        exercisesList.add(new Exercises("Get unique list", "Write a Python function that takes a list and returns" +
                " a new list with unique elements of the first list.\nSample List : [1,2,3,3,3,3,4,5]\n" +
                "Unique List : [1, 2, 3, 4, 5]", "def unique_list(l):\n" +
                "  x = []\n" +
                "  for a in l:\n" +
                "    if a not in x:\n" +
                "      x.append(a)\n" +
                "  return x\n" +
                "\n" +
                "print(unique_list([1,2,3,3,3,3,4,5])) "));

        exercisesList.add(new Exercises("pascal triangle", "Write a Python function that prints out the first n " +
                "rows of Pascal's triangle.", "def pascal_triangle(n):\n" +
                "   trow = [1]\n" +
                "   y = [0]\n" +
                "   for x in range(max(n,0)):\n" +
                "      print(trow)\n" +
                "      trow=[l+r for l,r in zip(trow+y, y+trow)]\n" +
                "   return n>=1\n" +
                "pascal_triangle(6) "
        ));

        exercisesList.add(new Exercises("pangram", "Write a Python function to check " +
                "whether a string is a pangram or not\nNote : Pangrams are words or sentences containing every letter of the alphabet at least once.\n" +
                "E.G: The quick brown fox jumps over the lazy dog\" ", "" +
                "import string, sys\n" +
                "def ispangram(str1, alphabet=string.ascii_lowercase):\n" +
                "    alphaset = set(alphabet)\n" +
                "    return alphaset <= set(str1.lower())\n" +
                " \n" +
                "print ( ispangram('The quick brown fox jumps over the lazy dog')) \n"
        ));

        exercisesList.add(new Exercises("Upper - Lower", "Write a Python function that accepts a string and" +
                " calculate the number of upper case letters and lower case letters\n" +
                "Sample String : 'WHilCodes'\n" +
                "Expected Output : \n" +
                "No. of Upper case characters : 3\n" +
                "No. of Lower case Characters : 6\n", "" +
                "def string_test(s):\n" +
                "    d={\"UPPER_CASE\":0, \"LOWER_CASE\":0}\n" +
                "    for c in s:\n" +
                "        if c.isupper():\n" +
                "           d[\"UPPER_CASE\"]+=1\n" +
                "        elif c.islower():\n" +
                "           d[\"LOWER_CASE\"]+=1\n" +
                "        else:\n" +
                "           pass\n" +
                "    print (\"Original String : \", s)\n" +
                "    print (\"No. of Upper case characters : \", d[\"UPPER_CASE\"])\n" +
                "    print (\"No. of Lower case Characters : \", d[\"LOWER_CASE\"])\n" +
                "\n" +
                "string_test('WHilCode')"));


        ExercisesAdapter exercisesAdapter = new ExercisesAdapter(getContext(), exercisesList, R.color.category_list_view_color);

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        listView.setAdapter(exercisesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Exercises currentExercise = exercisesList.get(position);

                Intent i = new Intent(getContext(), ExercisesReaderActivity.class);
                i.putExtra("Question", currentExercise.getTopic());
                i.putExtra("Body", currentExercise.getExerciseBody());
                startActivity(i);
            }
        });


        return rootView;
    }

}
