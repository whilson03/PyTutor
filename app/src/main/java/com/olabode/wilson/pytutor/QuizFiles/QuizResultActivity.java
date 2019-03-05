package com.olabode.wilson.pytutor.QuizFiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.activities.MainActivity;

public class QuizResultActivity extends AppCompatActivity {

    private int highscore;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        TextView textViewHighscore = findViewById(R.id.result_text_view);
        highscore = getIntent().getIntExtra("extraScore",0);
        textViewHighscore.setText(String.format("%d / 10", highscore));
        Button tryAgain = (Button) findViewById(R.id.try_again);
        Button home = (Button) findViewById(R.id.home);


        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }


}
