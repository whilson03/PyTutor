package com.olabode.wilson.pytutor.classes;

import android.graphics.drawable.Icon;

public class Topics {
    private String mTitle;
    private int mLeftIcon;
    private int mRightIcon;


    public Topics(int leftIcon ,String title, int rightIcon) {
        mTitle = title;
        mLeftIcon = leftIcon;
        mRightIcon = rightIcon;
    }

    /*
     Constructor for the exercises list
     */
    public Topics(String tiltle) {
        mTitle = tiltle;
    }


    public String getTopic() {
        return mTitle;
    }

    public void setTopic(String mString) {
        this.mTitle = mString;
    }

    public int getLeftIcon() {
        return mLeftIcon;
    }

    public void setLeftIcon(int leftIcon) {
        this.mLeftIcon = mLeftIcon;
    }

    public int getRightIcon() {
        return mRightIcon;
    }

    public void setRightIcon(int rightIcon) {
        this.mRightIcon = rightIcon;
    }
}
