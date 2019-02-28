package com.olabode.wilson.pytutor.QuizFiles;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.olabode.wilson.pytutor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizStartScreen extends Fragment {
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    private TextView textViewHighscore;
    private int highscore;


    public QuizStartScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_starting_screen, container, false);
        textViewHighscore = rootView.findViewById(R.id.text_view_highscore);

        Button buttonStartQuiz = rootView.findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
        return rootView;
    }


    private void startQuiz() {
        Intent intent = new Intent(getContext(), QuizActivity.class);
        startActivity(intent);
    }
}
