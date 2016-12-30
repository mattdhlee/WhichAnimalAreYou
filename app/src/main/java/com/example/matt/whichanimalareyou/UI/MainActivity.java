package com.example.matt.whichanimalareyou.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.matt.whichanimalareyou.Model.Questions;
import com.example.matt.whichanimalareyou.Model.Selector;
import com.example.matt.whichanimalareyou.R;
import com.example.matt.whichanimalareyou.Model.Page;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button mChoice1,mChoice2,mChoice3,mChoice4,mChoice5;
    private TextView mQuestion;
    private Questions mQuestionBank = new Questions();
    private Page currentPage;
    private int mQuestionIndex = 0;
    private Selector mChoices = new Selector();
    private HashMap<Button, Integer> pointsMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestion = (TextView) findViewById(R.id.questionTextView);
        mChoice1 = (Button) findViewById(R.id.button);
        mChoice2 = (Button) findViewById(R.id.button2);
        mChoice3 = (Button) findViewById(R.id.button3);
        mChoice4 = (Button) findViewById(R.id.button4);
        mChoice5 = (Button) findViewById(R.id.button5);

        pointsMap = makeMap(mChoice1,mChoice2,mChoice3,mChoice4,mChoice5);
        currentPage = mQuestionBank.getPage(mQuestionIndex);

        mQuestion.setText(currentPage.getQuestion());
        mChoice1.setText(currentPage.getChoice1());
        mChoice2.setText(currentPage.getChoice2());
        mChoice3.setText(currentPage.getChoice3());
        mChoice4.setText(currentPage.getChoice4());
        mChoice5.setText(currentPage.getChoice5());


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                //String buttonText = b.getText().toString();
                int point = pointsMap.get(b);

                mChoices.addPoints(point);
                mQuestionIndex++;



                if(mQuestionIndex<=4) {
                    currentPage = mQuestionBank.getPage(mQuestionIndex);
                    mQuestion.setText(currentPage.getQuestion());
                    mChoice1.setText(currentPage.getChoice1());
                    mChoice2.setText(currentPage.getChoice2());
                    mChoice3.setText(currentPage.getChoice3());
                    mChoice4.setText(currentPage.getChoice4());
                    mChoice5.setText(currentPage.getChoice5());



                }
                else{
                    //start final page
                    System.out.println("okokokokok");
                    String animal = mChoices.determineAnimal(mChoices.getTotalPoints());
                    startFinalPage(animal);


                }

            }
        };
        mChoice1.setOnClickListener(listener);
        mChoice2.setOnClickListener(listener);
        mChoice3.setOnClickListener(listener);
        mChoice4.setOnClickListener(listener);
        mChoice5.setOnClickListener(listener);



    }


    private void startFinalPage(String animal) {
        Intent intent = new Intent(this, FinalActivity.class);
        intent.putExtra("animal",animal);
        startActivity(intent);

    }

    private HashMap<Button,Integer> makeMap(Button b1, Button b2, Button b3, Button b4, Button b5) {
        pointsMap = new HashMap<Button, Integer>();
        pointsMap.put(mChoice1,1);
        pointsMap.put(mChoice2,2);
        pointsMap.put(mChoice3,3);
        pointsMap.put(mChoice4,4);
        pointsMap.put(mChoice5,5);
        return pointsMap;
    }
    protected void onResume() {
        super.onResume();
        // mNameField.setText("");
    }
}
