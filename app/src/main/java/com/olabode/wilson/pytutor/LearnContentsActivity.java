package com.olabode.wilson.pytutor;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LearnContentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_contents);
        ActionBar actionBar = getSupportActionBar();
        String title = getIntent().getStringExtra("title");
        if (title != null) {
            actionBar.setTitle(title);
        }
    }


}
