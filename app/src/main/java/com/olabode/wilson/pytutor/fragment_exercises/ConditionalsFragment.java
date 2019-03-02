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
public class ConditionalsFragment extends Fragment {


    public ConditionalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.exercises_list_view, container, false);


        final ArrayList<Exercises> exercisesList = new ArrayList<>();
        exercisesList.add(new Exercises("odd or even", "Ask the user for a number. Depending on whether the number is " +
                "even or odd, print out an appropriate" +
                " message to the user", "num = int(input('Enter a number')\nif num % 2 == 0:\n\tprint(num,'is even')\nelse:\n\tprint(num,' is odd')"));

        exercisesList.add(new Exercises("print all letter in a string", "myString = 'Hello'\nprint all letters in the word",
                "for letters in myString:\n\t\tprint(letters)"));

        exercisesList.add(new Exercises("Show even numbers in list", "show all even numbers in list.\nmList = [1,2,3,4,5,6,7,9,44,6]",
                "for numbers in mList:\n\t\tif numbers % 2 == 0:\n\t\t\t\t\tprint(numbers)"));

        exercisesList.add(new Exercises("Show five letter words in tuple", "Show five letter words in tuple.\n" +
                "my_tup = (\"hello\",\"willy\",\"python\",\"wilson\",\"java\")", "" +
                "for words in my_tup:\n" +
                "    if len(words) == 5:\n" +
                "        print(words)"));

        exercisesList.add(new Exercises("find largest number in a tuple", "find largest number in a tuple\nmy_tup = (1,78,3,6,8,9,8,3)",
                "my_tup = (1,78,3,6,8,9,8,3)\n" +
                        "max_no = my_tup[0]\n" +
                        "\n" +
                        "for i in my_tup:\n" +
                        "    if max_no < i:\n" +
                        "        max_no = i\n" +
                        "\n" +
                        "print(max_no)"));

        exercisesList.add(new Exercises("count no of occurrences", "count the number of occurences of 1 in the list below\n" +
                "my_list = [1,2,1,33,1,1,4,7,9]", "count = 0\n" +
                "for i in my_list:\n" +
                "    if i == 1:\n" +
                "        count += 1\n" +
                "\n" +
                "print(count)"));

        exercisesList.add(new Exercises("Print Triangle pattern", "print triangle pattern\n* \n" +
                "* * \n" +
                "* * * \n" +
                "* * * * \n" +
                "* * * * * ", "height = 5\n" +
                "for i in range(height):\n" +
                "    for j in range(i + 1):\n" +
                "        print(\"*\",end=\" \")\n" +
                "    print()"));

        exercisesList.add(new Exercises("Display 10 by 10 multiplication table", "Display 10 " +
                "by 10 multiplication table\n" +
                "i.e the time table will have 10 rows and 10 columns", "for row in range(1,11):\n" +
                "    # print column from 1 to 10\n" +
                "    for column in range(1,21):\n" +
                "        print(\"{0:<4}\".format(row * column),end= \" \")\n" +
                "    print()"));

        exercisesList.add(new Exercises("Find prime numbers", "Write a program to generate a list of " +
                "all prime numbers less than 20.", "# Initialize a list\n" +
                "primes = []\n" +
                "for possiblePrime in range(2, 21):\n" +
                "    \n" +
                "    # Assume number is prime until shown it is not. \n" +
                "    isPrime = True\n" +
                "    for num in range(2, possiblePrime):\n" +
                "        if possiblePrime % num == 0:\n" +
                "            isPrime = False\n" +
                "      \n" +
                "    if isPrime:\n" +
                "        primes.append(possiblePrime)"
        ));

        exercisesList.add(new Exercises("Check Longest word in a list", "Check Longest word in a list\nmList = [\"hello\",\"long\",\"toba\",\"bella\",\"wilson\",\"program\"]"
                , "mList = [\"hello\",\"long\",\"toba\",\"bella\",\"wilson\",\"program\"]\n" +
                "longestWord = mList[0]\n" +
                "for i in mList:\n" +
                "    if len(longestWord) < len(i):\n" +
                "        longestWord = i;\n" +
                "\n" +
                "print(longestWord)\n" +
                "\n" +
                "    "));

        exercisesList.add(new Exercises("square / rectangle pattern", "print square / rectangle pattern\n++++++\n" +
                "++++++\n" +
                "++++++\n" +
                "++++++\n" +
                "++++++\n" +
                "++++++", "size = 6\n" +
                "for i in range(size):\n" +
                "    for j in range(size):\n" +
                "        print(\"+\",end=\"\")\n" +
                "    print()\n"
        ));

        exercisesList.add(new Exercises("Skip numbers", "Write a Python program that prints a" +
                "ll the numbers from 0 to 6 except 3 and 6.", "" +
                "for x in range(6):\n" +
                "    if (x == 3 or x==6):\n" +
                "        continue\n" +
                "    print(x,end=' ')\n" +
                "print(\"\\n\")"
        ));
        exercisesList.add(new Exercises("Fibonacci series in a range", " Write a Python program" +
                " to get the Fibonacci series between 0 to 50.\nNB : The Fibonacci Sequence is the series of numbers :\n" +
                "0, 1, 1, 2, 3, 5, 8, 13, 21, .... \n" +
                "Every next number is found by adding up the two numbers before it.", "" +
                "x,y=0,1\n" +
                "\n" +
                "while y<50:\n" +
                "    print(y)\n" +
                "    x,y = y,x+y"));

        exercisesList.add(new Exercises("Print pattern D", "Write a Python program to pr" +
                "int alphabet pattern 'D'\n" +
                " ****                                                                   \n" +
                " *   *                                                                  \n" +
                " *   *                                                                  \n" +
                " *   *                                                                  \n" +
                " *   *                                                                  \n" +
                " *   *                                                                  \n" +
                " **** ", "" +
                "result_str=\"\";    \n" +
                "for row in range(0,7):    \n" +
                "    for column in range(0,7):     \n" +
                "        if (column == 1 or ((row == 0 or row == 6) and (column > 1 and column < 5)) or (column == 5 and row != 0 and row != 6)):  \n" +
                "            result_str=result_str+\"*\"    \n" +
                "        else:      \n" +
                "            result_str=result_str+\" \"    \n" +
                "    result_str=result_str+\"\\n\"    \n" +
                "print(result_str);"));

        exercisesList.add(new Exercises("Check vowel or Consonant", "Write a Python program to check whether" +
                " an alphabet is a vowel or consonant", "l = input(\"Input a letter of the alphabet: \")\n" +
                "\n" +
                "if l in ('a', 'e', 'i', 'o', 'u'):\n" +
                "\tprint(\"%s is a vowel.\" % l)\n" +
                "elif l == 'y':\n" +
                "\tprint(\"Sometimes letter y stand for vowel, sometimes stand for consonant.\")\n" +
                "else:\n" +
                "\tprint(\"%s is a consonant.\" % l) "));

        exercisesList.add(new Exercises("Month name to number of days", "Write a Python program to " +
                "convert month name to a number of days", "" +
                "print(\"List of months: January, February, March, April, May, June, July, August, September, October, November, December\")\n" +
                "month_name = input(\"Input the name of Month: \")\n" +
                "\n" +
                "if month_name == \"February\":\n" +
                "\tprint(\"No. of days: 28/29 days\")\n" +
                "elif month_name in (\"April\", \"June\", \"September\", \"November\"):\n" +
                "\tprint(\"No. of days: 30 days\")\n" +
                "elif month_name in (\"January\", \"March\", \"May\", \"July\", \"August\", \"October\", \"December\"):\n" +
                "\tprint(\"No. of days: 31 day\")\n" +
                "else:\n" +
                "\tprint(\"Wrong month name\") \n" +
                "\t"
        ));


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
