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
import com.olabode.wilson.pytutor.classes.Exercises;
import com.olabode.wilson.pytutor.adapters.ExercisesAdapter;
import com.olabode.wilson.pytutor.R;

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
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Check Even"));
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Find Prime"));
        exercisesList.add(new Exercises("Find Prime"));

        ExercisesAdapter exercisesAdapter = new ExercisesAdapter(getContext(),exercisesList,R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        listView.setAdapter(exercisesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getContext(), ExercisesReaderActivity.class);
                startActivity(i);
            }
        });

        return rootView;
    }

}
