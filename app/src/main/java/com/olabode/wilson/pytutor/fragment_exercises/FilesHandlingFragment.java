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
public class FilesHandlingFragment extends Fragment {


    public FilesHandlingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.exercises_list_view, container, false);
        final ArrayList<Exercises> exercisesList = new ArrayList<>();
        exercisesList.add(new Exercises("Read File", "Write a Python program to read an entire text file.",
                "def file_read(fname):\n" +
                        "        txt = open(fname)\n" +
                        "        print(txt.read())\n" +
                        "\n" +
                        "file_read('transparent_button.txt')"));

        exercisesList.add(new Exercises("read first line of file", "Write a Python program to read first n lines of a file.",
                "def file_read_from_head(fname, nlines):\n" +
                        "        from itertools import islice\n" +
                        "        with open(fname) as f:\n" +
                        "                for line in islice(f, nlines):\n" +
                        "                        print(line)\n" +
                        "file_read_from_head('transparent_button.txt',2)\n"

        ));

        exercisesList.add(new Exercises("Append to file", "Write a Python program to append text to a file and display the text.",
                "def file_read(fname):\n" +
                        "        from itertools import islice\n" +
                        "        with open(fname, \"w\") as myfile:\n" +
                        "                myfile.write(\"Python Exercises\\n\")\n" +
                        "                myfile.write(\"Java Exercises\")\n" +
                        "        txt = open(fname)\n" +
                        "        print(txt.read())\n" +
                        "file_read('abc.txt')"

        ));

        exercisesList.add(new Exercises("Read last line of file", "Write a Python program to read last n lines of a file",
                "import sys\n" +
                        "import os\n" +
                        "def file_read_from_tail(fname,lines):\n" +
                        "        bufsize = 8192\n" +
                        "        fsize = os.stat(fname).st_size\n" +
                        "        iter = 0\n" +
                        "        with open(fname) as f:\n" +
                        "                if bufsize > fsize:\n" +
                        "                        bufsize = fsize-1\n" +
                        "                        data = []\n" +
                        "                        while True:\n" +
                        "                                iter +=1\n" +
                        "                                f.seek(fsize-bufsize*iter)\n" +
                        "                                data.extend(f.readlines())\n" +
                        "                                if len(data) >= lines or f.tell() == 0:\n" +
                        "                                        print(''.join(data[-lines:]))\n" +
                        "                                        break\n" +
                        "\n" +
                        "file_read_from_tail('transparent_button.txt',2)"

        ));

        exercisesList.add(new Exercises("Read and store file in list", "Write a Python program to read a file line by line and" +
                " store it into a list", "def file_read(fname):\n" +
                "        with open(fname) as f:\n" +
                "                #Content_list is the list that contains the read lines.     \n" +
                "                content_list = f.readlines()\n" +
                "                print(content_list)\n" +
                "\n" +
                "file_read(\\'transparent_button.txt\\')\n"
        ));

        exercisesList.add(new Exercises("Read and store file in variable", "Write a Python program to read a file " +
                "line by line store it into a variable", "" +
                "def file_read(fname):\n" +
                "        with open (fname, \"r\") as myfile:\n" +
                "                data=myfile.readlines()\n" +
                "                print(data)\n" +
                "file_read('transparent_button.txt')\n"));

        exercisesList.add(new Exercises("Longest word in file", "Write a python program to find the longest words" +
                "", "def longest_word(filename):\n" +
                "    with open(filename, 'r') as infile:\n" +
                "              words = infile.read().split()\n" +
                "    max_len = len(max(words, key=len))\n" +
                "    return [word for word in words if len(word) == max_len]\n" +
                "\n" +
                "print(longest_word('transparent_button.txt'))"
        ));

        exercisesList.add(new Exercises("Count no of lines in files", "Write a Python program to count the number of lines in a text file",
                "def file_lengthy(fname):\n" +
                        "        with open(fname) as f:\n" +
                        "                for i, l in enumerate(f):\n" +
                        "                        pass\n" +
                        "        return i + 1\n" +
                        "print(\"Number of lines in the file: \",file_lengthy(\"transparent_button.txt\"))\n"
        ));


        exercisesList.add(new Exercises("Frequency of word in file", "Write a Python program to count the frequency of words in a file.",
                "from collections import Counter\n" +
                        "def word_count(fname):\n" +
                        "        with open(fname) as f:\n" +
                        "                return Counter(f.read().split())\n" +
                        "\n" +
                        "print(\"Number of words in the file :\",word_count(\"transparent_button.txt\"))\n"

        ));

        exercisesList.add(new Exercises("Get file size", "Write a Python program to get the file size of a plain file", "" +
                "def file_size(fname):\n" +
                "        import os\n" +
                "        statinfo = os.stat(fname)\n" +
                "        return statinfo.st_size\n" +
                "\n" +
                "print(\"File size in bytes of a plain file: \",file_size(\"transparent_button.txt\"))\n"
        ));


        exercisesList.add(new Exercises("Remove new line characters from file", " Write a Python program to remove newline characters from a file",
                "def remove_newlines(fname):\n" +
                        "    flist = open(fname).readlines()\n" +
                        "    return [s.rstrip('\\n') for s in flist]\n" +
                        "\n" +
                        "print(remove_newlines(\"transparent_button.txt\"))\n"
        ));

        exercisesList.add(new Exercises("Copy contents", "Write a Python program to copy the contents of a file to another file ",
                "from shutil import copyfile\n" +
                        "copyfile('transparent_button.py', 'abc.py')"
        ));
        exercisesList.add(new Exercises("Write list to file", "Write a Python program to write a list to a file", "" +
                "color = ['app', 'written', 'for', 'swep 200', 'OAU', 'IFE']\n" +
                "with open('abc.txt', \"w\") as myfile:\n" +
                "        for c in color:\n" +
                "                myfile.write(\"%s\\n\" % c)\n" +
                "\n" +
                "content = open('abc.txt')\n" +
                "print(content.read())"));

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
