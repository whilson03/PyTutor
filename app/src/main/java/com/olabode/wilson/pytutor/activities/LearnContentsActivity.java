package com.olabode.wilson.pytutor.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.olabode.wilson.pytutor.R;

import java.util.ArrayList;
import java.util.List;


public class LearnContentsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private static final String TAG = LearnContentsActivity.class.getSimpleName();
    private int pos, size;


    private WebView webView;
    private List<String> mAssetTitle;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_contents);
        mRecyclerView = findViewById(R.id.recycler_list);
        actionBar = getSupportActionBar();
        // list of all the html files from the assets directory
        mAssetTitle = new ArrayList<>();
        mAssetTitle.add("overview.html");
        mAssetTitle.add("Environment_Setup.html");
        mAssetTitle.add("BasicSyntax.html");
        mAssetTitle.add("variables.html");
        mAssetTitle.add("basic_operator.html");
        mAssetTitle.add("strings.html");

        mAssetTitle.add("decision_making.html");
        mAssetTitle.add("loops.html");
        mAssetTitle.add("lists.html");
        mAssetTitle.add("Tuples.html");
        mAssetTitle.add("dictionaries.html");
        mAssetTitle.add("functions.html");
        mAssetTitle.add("Modules.html");
        mAssetTitle.add("file.html");
        mAssetTitle.add("exceptions.html");
        mAssetTitle.add("classes.html");


        pos = getIntent().getIntExtra("position", 0);
        size = getIntent().getIntExtra("listLength", mAssetTitle.size());

        Log.v(TAG, "intent " + "position " + pos + " size " + size);

        String title = getIntent().getStringExtra("title");

        if (title != null) {
            if (actionBar != null) {
                actionBar.setTitle(title);
            }
        }


        String assetName = getIntent().getStringExtra("ContentAssetName");
        webView = findViewById(R.id.web_view);
        webView.setWebViewClient(new MyBrowser());

//
//        WebView myWebView = new WebView(this);
//        myWebView.getSettings().setJavaScriptEnabled(false);
//        myWebView.loadUrl("file:///android_asset/" + assetName);
//        setContentView(R.layout.learn_contents_webview);

        String url = "file:///android_asset/" + assetName;
        webView.getSettings().setLoadsImagesAutomatically(false);
        webView.getSettings().setJavaScriptEnabled(false);
        webView.loadUrl(url);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.utils_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem next = menu.findItem(R.id.menu_next);
        MenuItem previous = menu.findItem(R.id.menu_previous);
        if (pos == 0) {
            previous.setEnabled(false);
        } else if (pos == size - 1) {
            next.setEnabled(false);
        }
        return super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_next) {
            pos++;
            Log.v(TAG, "next  " + "position " + pos + " size " + size);
            moveToNext(pos);

            return true;
        } else if (id == R.id.menu_previous) {
            pos--;
            Log.v(TAG, "previous " + "position " + pos + " size " + size);
            moveToPrevious(pos);


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void moveToNext(int currentPosition) {
        String fileName = mAssetTitle.get(currentPosition);
        String url = "file:///android_asset/" + fileName;
        actionBar.setTitle(fileName.substring(0, fileName.indexOf(".html")).toUpperCase());
        webView.getSettings().setLoadsImagesAutomatically(false);
        webView.getSettings().setJavaScriptEnabled(false);
        webView.loadUrl(url);
        invalidateOptionsMenu();
    }

    void moveToPrevious(int currentPosition) {
        String fileName = mAssetTitle.get(currentPosition);
        String url = "file:///android_asset/" + fileName;
        actionBar.setTitle(fileName.substring(0, fileName.indexOf(".html")).toUpperCase());
        webView.getSettings().setLoadsImagesAutomatically(false);
        webView.getSettings().setJavaScriptEnabled(false);
        webView.loadUrl(url);
        invalidateOptionsMenu();
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }



}

