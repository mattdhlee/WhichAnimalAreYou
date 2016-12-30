package com.example.matt.whichanimalareyou.Model;

/**
 * Created by Matt on 2016-12-27.
 */
//This perofrms the logic based on the five answers chosen by the user
public class Selector {
    //int mAnswer1, mAnswer2, mAnswer3, mAnswer4, mAnswer5;
    int totalPoints = 0;

    public int getTotalPoints() {
        return totalPoints;
    }
    public void addPoints(int n) {
        totalPoints = totalPoints + n;
    }

    //TODO: a logic function that determines the animal

    public String determineAnimal(int totalPoints) {
        //Dolphin
        if(totalPoints >= 5 && totalPoints<9) {
            return "Dolphin";
        }
        if(totalPoints >=9 && totalPoints<13) {
            return "Monkey";
        }
        if(totalPoints >=13 && totalPoints<17) {
            return "Tiger";
        }
        if(totalPoints >=17 && totalPoints<21) {
            return "Elephant";
        }
        if(totalPoints >=21) {
            return "Red Panda";
        }
        else{
            return "NoNO";
        }


    }

    //TODO: a function that returns the animal name






}
