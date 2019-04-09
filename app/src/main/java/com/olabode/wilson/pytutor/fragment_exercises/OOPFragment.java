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
public class OOPFragment extends Fragment {
    private ExercisesRecyclerAdapter mExercisesAdapter;
    private List<Exercises> exercisesList;
    private RecyclerView mRecyclerView;



    public OOPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.exercises_recycler_view, container, false);


        mRecyclerView = rootView.findViewById(R.id.exercises_recycler);
        LinearLayoutManager exercisesLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(exercisesLayoutManager);


        exercisesList = new ArrayList<>();

        exercisesList.add(new Exercises("convert an integer to a roman numeral.", "Write a Python program to convert an integer to a roman numeral.",
                "class py_solution:\n" +
                        "    def int_to_Roman(self, num):\n" +
                        "        val = [\n" +
                        "            1000, 900, 500, 400,\n" +
                        "            100, 90, 50, 40,\n" +
                        "            10, 9, 5, 4,\n" +
                        "            1\n" +
                        "            ]\n" +
                        "        syb = [\n" +
                        "            \"M\", \"CM\", \"D\", \"CD\",\n" +
                        "            \"C\", \"XC\", \"L\", \"XL\",\n" +
                        "            \"X\", \"IX\", \"V\", \"IV\",\n" +
                        "            \"I\"\n" +
                        "            ]\n" +
                        "        roman_num = ''\n" +
                        "        i = 0\n" +
                        "        while  num > 0:\n" +
                        "            for _ in range(num // val[i]):\n" +
                        "                roman_num += syb[i]\n" +
                        "                num -= val[i]\n" +
                        "            i += 1\n" +
                        "        return roman_num\n" +
                        "\n" +
                        "\n" +
                        "print(py_solution().int_to_Roman(1))\n" +
                        "print(py_solution().int_to_Roman(4000))\n"));

        exercisesList.add(new Exercises("convert a roman numeral to an integer", "Write a Python class to convert a roman numeral to an integer",
                "class py_solution:\n" +
                        "    def roman_to_int(self, s):\n" +
                        "        rom_val = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}\n" +
                        "        int_val = 0\n" +
                        "        for i in range(len(s)):\n" +
                        "            if i > 0 and rom_val[s[i]] > rom_val[s[i - 1]]:\n" +
                        "                int_val += rom_val[s[i]] - 2 * rom_val[s[i - 1]]\n" +
                        "            else:\n" +
                        "                int_val += rom_val[s[i]]\n" +
                        "        return int_val\n" +
                        "\n" +
                        "print(py_solution().roman_to_int('MMMCMLXXXVI'))\n" +
                        "print(py_solution().roman_to_int('MMMM'))\n" +
                        "print(py_solution().roman_to_int('C'))\n"

        ));

        exercisesList.add(new Exercises("possible unique subsets from a set of distinct integers.", "Write a Python class to get all possible unique subsets from a set of distinct integers." +
                "\nInput : [4, 5, 6]\n" +
                "Output : [[], [6], [5], [5, 6], [4], [4, 6], [4, 5], [4, 5, 6]]\n" +
                "\n", "" +
                "class py_solution:\n" +
                "    def sub_sets(self, sset):\n" +
                "        return self.subsetsRecur([], sorted(sset))\n" +
                "    \n" +
                "    def subsetsRecur(self, current, sset):\n" +
                "        if sset:\n" +
                "            return self.subsetsRecur(current, sset[1:]) + self.subsetsRecur(current + [sset[0]], sset[1:])\n" +
                "        return [current]\n" +
                "\n" +
                "print(py_solution().sub_sets([4,5,6]))\n"
        ));

        exercisesList.add(new Exercises("find the three elements that sum to zero from a set of n real numbers", "" +
                "Write a Python class to find the three elements that sum to zero from a set of n real numbers.\n" +
                "Input array : [-25, -10, -7, -3, 2, 4, 8, 10]\n" +
                "Output : [[-10, 2, 8], [-7, -3, 10]]\n" +
                "\n", "" +
                "class py_solution:\n" +
                " def threeSum(self, nums):\n" +
                "        nums, result, i = sorted(nums), [], 0\n" +
                "        while i < len(nums) - 2:\n" +
                "            j, k = i + 1, len(nums) - 1\n" +
                "            while j < k:\n" +
                "                if nums[i] + nums[j] + nums[k] < 0:\n" +
                "                    j += 1\n" +
                "                elif nums[i] + nums[j] + nums[k] > 0:\n" +
                "                    k -= 1\n" +
                "                else:\n" +
                "                    result.append([nums[i], nums[j], nums[k]])\n" +
                "                    j, k = j + 1, k - 1\n" +
                "                    while j < k and nums[j] == nums[j - 1]:\n" +
                "                        j += 1\n" +
                "                    while j < k and nums[k] == nums[k + 1]:\n" +
                "                        k -= 1\n" +
                "            i += 1\n" +
                "            while i < len(nums) - 2 and nums[i] == nums[i - 1]:\n" +
                "                i += 1\n" +
                "        return result\n" +
                "\n" +
                "print(py_solution().threeSum([-25, -10, -7, -3, 2, 4, 8, 10]))\n"


        ));


        exercisesList.add(new Exercises("class to implement pow(x, n)", "" +
                " Write a Python class to implement pow(x, n)",
                "class py_solution:\n" +
                        "   def pow(self, x, n):\n" +
                        "        if x==0 or x==1 or n==1:\n" +
                        "            return x \n" +
                        "\n" +
                        "        if x==-1:\n" +
                        "            if n%2 ==0:\n" +
                        "                return 1\n" +
                        "            else:\n" +
                        "                return -1\n" +
                        "        if n==0:\n" +
                        "            return 1\n" +
                        "        if n<0:\n" +
                        "            return 1/self.pow(x,-n)\n" +
                        "        val = self.pow(x,n//2)\n" +
                        "        if n%2 ==0:\n" +
                        "            return val*val\n" +
                        "        return val*val*x\n" +
                        "\n" +
                        "print(py_solution().pow(2, -3));\n" +
                        "print(py_solution().pow(3, 5));\n" +
                        "print(py_solution().pow(100, 0));"

        ));


        exercisesList.add(new Exercises("pair of elements (indices of the two numbers) from a given array",
                "Write a Python program to find a pair of elements (indices of the two numbers) from a given array whose sum equals a specific target number.\n" +
                        "\nInput: numbers= [10,20,10,40,50,60,70], target=50\n" +
                        "Output: 3, 4"
                , "class py_solution:\n" +
                "   def twoSum(self, nums, target):\n" +
                "        lookup = {}\n" +
                "        for i, num in enumerate(nums):\n" +
                "            if target - num in lookup:\n" +
                "                return (lookup[target - num] + 1, i + 1)\n" +
                "            lookup[num] = i\n" +
                "print(\"index1=%d, index2=%d\" % py_solution().twoSum((10,20,10,40,50,60,70),50))\n"


        ));

        exercisesList.add(new Exercises("Geometric series", "Write a Python program to calculate the geometric sum of n-1.\n" +
                "Note : In mathematics, a geometric series is a series with a constant ratio between successive terms.",
                "def geometric_sum(n):\n" +
                        "  if n < 0:\n" +
                        "    return 0\n" +
                        "  else:\n" +
                        "    return 1 / (pow(2, n)) + geometric_sum(n - 1)\n" +
                        " \n" +
                        "print(geometric_sum(7))\n" +
                        "print(geometric_sum(4))\n"

        ));

        exercisesList.add(new Exercises("Reverse a string word by word.", "" +
                "Write a Python class to reverse a string word by word.\nInput string : 'hello .py'\n" +
                "Expected Output : '.py hello'", "class py_solution:\n" +
                "    def reverse_words(self, s):\n" +
                "        return ' '.join(reversed(s.split()))\n" +
                "\n" +
                "\n" +
                "print(py_solution().reverse_words('hello .py'))\n"


        ));


        mExercisesAdapter = new ExercisesRecyclerAdapter(getContext(), exercisesList);
        mRecyclerView.setAdapter(mExercisesAdapter);


        return rootView;
    }

}
