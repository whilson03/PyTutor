package com.olabode.wilson.pytutor.fragment_exercises;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.adapters.ExercisesRecyclerAdapter;
import com.olabode.wilson.pytutor.classes.Exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicsFragment extends Fragment {
    private ExercisesRecyclerAdapter mExercisesAdapter;
    private List<Exercises> exercisesList;
    private RecyclerView mRecyclerView;


    public BasicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.exercises_recycler_view, container, false);

        mRecyclerView = rootView.findViewById(R.id.exercises_recycler);
        LinearLayoutManager exercisesLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(exercisesLayoutManager);


        exercisesList = new ArrayList<>();

        exercisesList.add(new Exercises(" Add Two Numbers", "Python Program to Add Two Numbers\n", "" +
                "# This program adds two numbers\n" +
                "\n" +
                "num1 = 1.5\n" +
                "num2 = 6.3\n" +
                "\n" +
                "# Add two numbers\n" +
                "sum = float(num1) + float(num2)\n" +
                "\n" +
                "# Display the sum\n" +
                "print('The sum of {0} and {1} is {2}'.format(num1, num2, sum))"));

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

        exercisesList.add(new Exercises("Convert Celsius To Fahrenheit", "we take temperature in degree Celsius and convert it into degree Fahrenheit. They are related by the formula:\n" +
                "\n", "" +
                "# Python Program to convert temperature in celsius to fahrenheit\n" +
                "\n" +
                "# change this value for a different result\n" +
                "celsius = 37.5\n" +
                "\n" +
                "# calculate fahrenheit\n" +
                "fahrenheit = (celsius * 1.8) + 32\n" +
                "print('%0.1f degree Celsius is equal to %0.1f degree Fahrenheit' %(celsius,fahrenheit))"));

        exercisesList.add(new Exercises("Program to Find the Square Root", "" +
                "Program to Find the Square Root", "" +
                "# Python Program to calculate the square root\n" +
                "\n" +
                "# Note: change this value for a different result\n" +
                "num = 8 \n" +
                "\n" +
                "# uncomment to take the input from the user\n" +
                "#num = float(input('Enter a number: '))\n" +
                "num_sqrt = num ** 0.5\n" +
                "print('The square root of %0.3f is %0.3f'%(num ,num_sqrt))"));
        exercisesList.add(new Exercises("Solve quadratic equation", "program to solve quadratic equation\n" +
                "The standard form of a quadratic equation is:\n" +
                "ax^2 + bx + c = 0, where\n" +
                "a, b and c are real numbers and\n" +
                "a ≠ 0\n", "# Solve the quadratic equation ax**2 + bx + c = 0\n" +
                "\n" +
                "# import complex math module\n" +
                "import cmath\n" +
                "\n" +
                "a = 1\n" +
                "b = 5\n" +
                "c = 6\n" +
                "\n" +
                "# To take coefficient input from the users\n" +
                "# a = float(input('Enter a: '))\n" +
                "# b = float(input('Enter b: '))\n" +
                "# c = float(input('Enter c: '))\n" +
                "\n" +
                "# calculate the discriminant\n" +
                "d = (b**2) - (4*a*c)\n" +
                "\n" +
                "# find two solutions\n" +
                "sol1 = (-b-cmath.sqrt(d))/(2*a)\n" +
                "sol2 = (-b+cmath.sqrt(d))/(2*a)\n" +
                "\n" +
                "print('The solution are {0} and {1}'.format(sol1,sol2))"));
        exercisesList.add(new Exercises("Generate a Random Number", "Python Program to Generate a Random Number",
                "# Program to generate a random number between 0 and 9\n" +
                        "\n" +
                        "# import the random module\n" +
                        "import random\n" +
                        "\n" +
                        "print(random.randint(0,9))"));

        mExercisesAdapter = new ExercisesRecyclerAdapter(getContext(), exercisesList);
        mRecyclerView.setAdapter(mExercisesAdapter);



        return rootView;
    }
}
