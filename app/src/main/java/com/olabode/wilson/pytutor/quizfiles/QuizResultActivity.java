package com.olabode.wilson.pytutor.quizfiles;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.olabode.wilson.pytutor.R;
import com.olabode.wilson.pytutor.activities.MainActivity;

public class QuizResultActivity extends AppCompatActivity {
    int pStatus = 0;
    TextView tv, messageTextView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        messageTextView = findViewById(R.id.congratulations_text_view);

        Button tryAgain = findViewById(R.id.try_again);
        Button home = findViewById(R.id.home);


        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = findViewById(R.id.circularProgressbar);
        mProgress.setProgress(0);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);

        int score = getIntent().getIntExtra("extraScore", 0);
        score = score * 10;

        if (score <= 50) {
            messageTextView.setText(getString(R.string.try_again));

        } else {
            messageTextView.setText(getString(R.string.congrats));
        }


        tv = findViewById(R.id.tv);
        final int finalScore = score;
        new Thread(new Runnable() {

            @Override
            public void run() {

                while (pStatus < finalScore) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {

                            mProgress.setProgress(pStatus);
                            tv.setText(pStatus + "%");
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(16); //thread will take approx 3 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



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

}
