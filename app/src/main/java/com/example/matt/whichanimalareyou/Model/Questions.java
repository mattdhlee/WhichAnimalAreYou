package com.example.matt.whichanimalareyou.Model;

/**
 * Created by Matt on 2016-12-27.
 */

public class Questions {

    Page[] mQuestions = new Page[5];
    public Questions() {
        mQuestions[0] = new Page("What do you like to do in your free time?", "Go out with friends", "Travel", "Excercise", "Cook", "Read or Watch movies");
        mQuestions[1] = new Page ("What is your favorite color?", "Blue", "White", "Red", "Green", "Yellow");
        mQuestions[2] = new Page("What is your favorite cuisine?","Italian","Korean","American","Mexican","Japanese");
        mQuestions[3] = new Page("On average, how many hours do you sleep each night?","Less than 4", "5-7","7-9","9-11","More than 11");
        mQuestions[4] = new Page("What is your favoirte activity?", "Swimming", "Climbing", "Running", "Singing","Napping");

    }

    public Page[] getQuestions() {
        return mQuestions;
    }

    public Page getPage(int i) {
        return mQuestions[i];
    }
}
