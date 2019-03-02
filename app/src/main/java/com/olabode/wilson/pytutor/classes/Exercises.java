package com.olabode.wilson.pytutor.classes;

/**
 * class to hold exercises and solutions.
 */

public class Exercises {
    private String mExerciseTitle;
    private String mExerciseSolution;
    private String mTopic;


    /**
     * @param mExerciseTitle    title to display in the list view.
     * @param topic             main topic of the exercise and possible example output.
     * @param mExerciseSolution solution to the quiz.
     */
    public Exercises(String mExerciseTitle, String topic, String mExerciseSolution) {
        this.mExerciseTitle = mExerciseTitle;
        this.mExerciseSolution = mExerciseSolution;
        this.mTopic = topic;
    }

    public String getExerciseTitle() {
        return mExerciseTitle;
    }


    public String getExerciseBody() {
        return mExerciseSolution;
    }


    public String getTopic() {
        return mTopic;
    }
}
