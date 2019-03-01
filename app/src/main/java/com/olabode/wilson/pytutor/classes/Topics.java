package com.olabode.wilson.pytutor.classes;

public class Topics {
    private String mTitle;
    private int mLeftIcon;


    public Topics(int leftIcon, String title) {
        mTitle = title;
        mLeftIcon = leftIcon;
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


}
