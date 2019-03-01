package com.olabode.wilson.pytutor.classes;

public class Exercises {
    private String mExerciseTitle;
    private String mExerciseBody;
    ;
    private String mTopic;

    public Exercises(String mExerciseTitle) {
        this.mExerciseTitle = mExerciseTitle;
    }

    public Exercises(String mExerciseTitle, String topic, String mExerciseBody) {
        this.mExerciseTitle = mExerciseTitle;
        this.mExerciseBody = mExerciseBody;
        this.mTopic = topic;
    }

    public String getExerciseTitle() {
        return mExerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.mExerciseTitle = exerciseTitle;
    }


    public String getExerciseBody() {
        return mExerciseBody;
    }

    private void setExerciseBody(String exerciseBody) {
        this.mExerciseBody = exerciseBody;
    }


    public String getTopic() {
        return mTopic;
    }
}
