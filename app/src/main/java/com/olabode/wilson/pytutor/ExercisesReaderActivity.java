package com.olabode.wilson.pytutor;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExercisesReaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_reader);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView questionText = (TextView) findViewById(R.id.exercise_question);
        final TextView solutionText = (TextView) findViewById(R.id.exercise_solution);

        String question = getIntent().getStringExtra("Question");
        final String body = getIntent().getStringExtra("Body");
        questionText.setText(question);

        Button showSolution = (Button) findViewById(R.id.solution_button);
        showSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solutionText.setText(body);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }


}
