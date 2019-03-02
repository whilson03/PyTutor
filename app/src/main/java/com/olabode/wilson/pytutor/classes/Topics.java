package com.olabode.wilson.pytutor.classes;

public class Topics {
    private String mTitle;
    private int mLeftIcon;


    /**
     * constructor to the topic and drawable icons for the tutorial sertion.
     *
     * @param leftIcon drawable icon
     * @param title    topic considered.
     */
    public Topics(int leftIcon, String title) {
        mTitle = title;
        mLeftIcon = leftIcon;
    }


    public String getTopic() {
        return mTitle;
    }


    public int getLeftIcon() {
        return mLeftIcon;
    }

}
