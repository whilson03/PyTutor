package com.olabode.wilson.pytutor.QuizFiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.activities.MainActivity;

public class QuizResultActivity extends AppCompatActivity {
    private RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        ratingBar = findViewById(R.id.rating_bar);

        TextView textViewHighScore = findViewById(R.id.result_text_view);
        int score = getIntent().getIntExtra("extraScore", 0);
        textViewHighScore.setText(String.format("%d / 10", score));
        computeRating(score);


        Button tryAgain = findViewById(R.id.try_again);
        Button home = findViewById(R.id.home);


        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultActivity.this, QuizActivity.class);
                startActivity(intent);
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }


    public void computeRating(int score) {
        ratingBar.setStepSize((float) 0.5);
        switch (score) {
            case 0:
                ratingBar.setRating((float) 0);
                break;
            case 1:
                ratingBar.setRating((float) 0.5);
                break;

            case 2:
                ratingBar.setRating((float) 1);
                break;
            case 3:
                ratingBar.setRating((float) 1.5);
                break;
            case 4:
                ratingBar.setRating((float) 2.3);
                break;
            case 5:
                ratingBar.setRating((float) 3);
                break;
            case 6:
                ratingBar.setRating((float) 3.3);
                break;
            case 7:
            case 8:
                ratingBar.setRating((float) 4);
                break;
            case 9:
                ratingBar.setRating((float) 4.5);
                break;
            case 10:
                ratingBar.setRating((float) 5);
                break;
        }
    }
}
