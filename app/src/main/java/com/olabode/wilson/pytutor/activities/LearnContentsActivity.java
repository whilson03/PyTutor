package com.olabode.wilson.pytutor.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;


public class LearnContentsActivity extends AppCompatActivity {

    private static final String TAG = LearnContentsActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        String title = getIntent().getStringExtra("title");
        if (title != null) {
            if (actionBar != null) {
                actionBar.setTitle(title);
            }
        }

        String assetName = getIntent().getStringExtra("ContentAssetName");


        WebView myWebView = new WebView(this);
        myWebView.getSettings().setJavaScriptEnabled(false);
        myWebView.loadUrl("file:///android_asset/" + assetName);
        setContentView(myWebView);


    }

}

