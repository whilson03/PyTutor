package com.olabode.wilson.pytutor.fragment_exercises;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.olabode.wilson.pytutor.ExercisesReaderActivity;
import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.adapters.ExercisesAdapter;
import com.olabode.wilson.pytutor.classes.Exercises;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicsFragment extends Fragment {


    public BasicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.exercises_list, container, false);


        final  ArrayList<Exercises> exercisesList = new ArrayList<>();

        exercisesList.add(new Exercises("Area of Triangle", "Find Area of triangle \nArea = 1/2 * base * height"
                , "base = 2 \nheight = 2 \nArea = (1/2) * base * height \n" +
                "print(Area)"));

        exercisesList.add(new Exercises("Area of Circle", " Write a Python program which accepts the radius of" +
                " a circle from the user and compute the area\nArea = pi * r ^ 2", "from math import pi\n" +
                "r = float(input (\"Input the radius of the circle : \"))\n" +
                "print (\"The area of the circle with radius \" + str(r) + \" is: \" + str(pi * r**2))\n"));

        exercisesList.add(new Exercises("Volume of Sphere", "A sphere is a three-dimensional solid with no face, no edge, no base and no vertex." +
                "It is a round body with all points on its surface equidistant from the center. The volume of a sphere is measured in cubic units.\n" +
                "\n" + "The volume of the sphere is : \n" +
                "V = 4/3 × π × r ^ 3",
                "pi = 3.14\n" +
                        "r= 6.0\n" +
                        "V= 4.0 / 3.0 *pi * r ** 3\n" +
                        "print('The volume of the sphere is: ',V)"));

        exercisesList.add(new Exercises("Tell my Age", "Create a program that asks the user to enter their name and their age.\n" +
                "Print out a message addressed to them that tells them the year that they will turn 100 years old."
                , "name = input(\"What is your name: \")\n" +
                "age = int(input(\"How old are you: \"))\n"
                + "current_year = 2018\n" +
                "year = str((current_year - age)+100)\n" +
                "print(name + \" will be 100 years old in the year \" + year)"));

        exercisesList.add(new Exercises("Convert pound to Kilogram", "Write a program that converts pounds into\n" +
                "kilograms. The program prompts the user to enter a value in pounds, converts it to\n" +
                "kilograms, and displays the result. One pound is 0.454 kilograms.",
                "pounds = eval(input(\"Enter a number in pounds: \"))\n" +
                        "\n" +
                        "kilograms = pounds * 0.454;\n" +
                        "\n" +
                        "print(str(pounds) + \" pounds is \" + str(kilograms) + \" kilograms\")"));


        exercisesList.add(new Exercises("Sum the digits in an integer", " Write a program that reads an integer between 0 and\n" +
                "1000 and adds all the digits in the integer. For example, if an integer is 932, the" +
                "sum of all its digits is 14. (Hint: Use the % operator to extract digits, and use the //\n" +
                "operator to remove the extracted digit. For instance, 932 % 10 = 2 and 932 //\n" +
                "10 = 93"
                , "#  Read a number\n" +
                "number = eval(input(\"Enter an integer between 0 and 1000: \"))\n" +
                "\n" +
                "lastDigit = number % 10\n" +
                "remainingNumber = number // 10\n" +
                "secondLastDigit = remainingNumber % 10\n" +
                "\n" +
                "remainingNumber = remainingNumber // 10\n" +
                "thirdLastDigit = remainingNumber % 10\n" +
                "\n" +
                "# Obtain the sum of all digits\n" +
                "sum = lastDigit + secondLastDigit + thirdLastDigit\n" +
                "\n" +
                "# Display results\n" +
                "print(\"The sum of all digits in\", number, \"is\", sum)"));

        exercisesList.add(new Exercises("Check python version", " Write a Python program to" +
                " get the Python version you are using", "" +
                "import sys\n" +
                "print(\"Python version\")\n" +
                "print (sys.version)\n" +
                "print(\"Version info.\")\n" +
                "print (sys.version_info)"));

        exercisesList.add(new Exercises("Generate list and tuples", "Write a Python program which accepts a sequence of comma-separated numbers from user" +
                " and generate a list and a tuple with those numbers\nSample data : 3, 5, 7, 23\n" +
                "Output : \n" +
                "List : ['3', ' 5', ' 7', ' 23'] \n" +
                "Tuple : ('3', ' 5', ' 7', ' 23')", "values = input(\"Input some comma seprated numbers : \")\n" +
                "list = values.split(\",\")\n" +
                "tuple = tuple(list)\n" +
                "print('List : ',list)\n" +
                "print('Tuple : ',tuple)"
        ));


        exercisesList.add(new Exercises("Get file extension", "Write a Python program to accept a filename from the user and print th" +
                "e extension of that\nSample filename : www.html \n" +
                "Output : html", "filename = input(\"Input the Filename: \")\n" +
                "f_extns = filename.split(\".\")\n" +
                "print (\"The extension of the file is : \" + repr(f_extns[-1]))"
        ));


        exercisesList.add(new Exercises("Concatenate Strings", "Write a Python program to concatenate all elements in a list into " +
                "a string", "mList = [1,2,3,78]\n" +
                "result= ''\n" +
                "for element in mList:\n" +
                "    result += str(element)\n" +
                "print(result)    \n"
        ));


        exercisesList.add(new Exercises("program to solve (x + y) * (x + y).", "write a Python program to solve (x + y) * (x + y)." +
                "", "x, y = 4, 3\n" +
                "result = x * x + 2 * x * y + y * y\n" +
                "print(\"({} + {}) ^ 2) = {}\".format(x, y, result))"
        ));

        exercisesList.add(new Exercises("compute distance", "Write a Python program to compute the distance" +
                " between the points (x1, y1) and (x2, y2)", "" +
                "import math\n" +
                "p1 = [4, 0]\n" +
                "p2 = [6, 6]\n" +
                "distance = math.sqrt( ((p1[0]-p2[0])**2)+((p1[1]-p2[1])**2) )\n" +
                "\n" +
                "print(distance)\n"
        ));

        exercisesList.add(new Exercises("CPUs", "Write a Python program to find out the number of CPUs using.",
                "import multiprocessing\n" +
                        "print(multiprocessing.cpu_count())"


        ));

        exercisesList.add(new Exercises("parse string to float", "Write a Python program to parse a string of numbers to Float or Integer.",
                "n = \"246.2458\"\n" +
                        "print(float(n))"
        ));

        exercisesList.add(new Exercises(" convert height (in feet and inches) to centimeters.", "" +
                "Write a Python program to convert height (in feet and inches) to centimeters.", "" +
                "print(\"Input your height: \")\n" +
                "h_ft = int(input(\"Feet: \"))\n" +
                "h_inch = int(input(\"Inches: \"))\n" +
                "\n" +
                "h_inch += h_ft * 12\n" +
                "h_cm = round(h_inch * 2.54, 1)\n" +
                "\n" +
                "print(\"Your height is : %d cm.\" % h_cm)\n"

        ));



        ExercisesAdapter exercisesAdapter = new ExercisesAdapter(getContext(),exercisesList,R.color.category_numbers);
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
