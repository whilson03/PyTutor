package com.olabode.wilson.pytutor.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.olabode.wilson.pytutor.classes.Exercises;
import com.olabode.wilson.pytutor.R;

import java.util.ArrayList;

public class ExercisesAdapter extends ArrayAdapter<Exercises> {
    private int mColorResourceId;

    public ExercisesAdapter(Context context, ArrayList<Exercises> exercises, int colorResourceId) {
        super(context, 0, exercises);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.exercises_list_items, parent, false);
        }

        Exercises currentExercise = getItem(position);
        TextView exerciseTitleTextView = (TextView) listItemView.findViewById(R.id.exercise_title_text_view);
        exerciseTitleTextView.setText(currentExercise.getExerciseTitle());


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }


}
