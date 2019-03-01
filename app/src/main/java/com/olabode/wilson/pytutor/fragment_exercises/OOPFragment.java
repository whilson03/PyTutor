package com.olabode.wilson.pytutor.fragment_exercises;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.adapters.ExercisesAdapter;
import com.olabode.wilson.pytutor.classes.Exercises;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OOPFragment extends Fragment {


    public OOPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.exercises_list, container, false);

        final ArrayList<Exercises> exercisesList = new ArrayList<>();


        ExercisesAdapter exercisesAdapter = new ExercisesAdapter(getContext(),exercisesList,R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        listView.setAdapter(exercisesAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

}
