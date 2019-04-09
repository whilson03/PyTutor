package com.olabode.wilson.pytutor.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.activities.ExercisesReaderActivity;
import com.olabode.wilson.pytutor.classes.Exercises;

import java.util.List;

/*
  RecyclerView adapter to inflate layout that displays the exercises in the exercises section
 */
public class ExercisesRecyclerAdapter extends RecyclerView.Adapter<ExercisesRecyclerAdapter.ExercisesViewHolder> {
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final List<Exercises> mExercises;

    // recycler view constructor
    public ExercisesRecyclerAdapter(Context context, List<Exercises> exercises) {
        this.mContext = context;
        this.mExercises = exercises;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ExercisesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mLayoutInflater.inflate(R.layout.exercises_recycler_items, viewGroup, false);
        return new ExercisesViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ExercisesViewHolder exercisesViewHolder, int position) {

        Exercises exercise = mExercises.get(position);

        exercisesViewHolder.topic = exercise.getTopic();

        exercisesViewHolder.exerciseTitle.setText(exercise.getExerciseTitle());

        exercisesViewHolder.exerciseBody = exercise.getExerciseBody();

    }


    @Override
    public int getItemCount() {
        return mExercises.size();
    }


    // view holder class that hold all the items in the card view for each item in the list.
    public class ExercisesViewHolder extends RecyclerView.ViewHolder {

        public final TextView exerciseTitle;
        public String topic, exerciseBody;


        public ExercisesViewHolder(@NonNull final View itemView) {
            super(itemView);
            exerciseTitle = itemView.findViewById(R.id.exercise_title_text_view);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(mContext, ExercisesReaderActivity.class);
                    i.putExtra("Question", topic);
                    i.putExtra("Body", exerciseBody);

                    mContext.startActivity(i);
                }
            });


        }
    }
}
