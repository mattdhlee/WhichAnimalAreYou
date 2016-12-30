package com.example.matt.whichanimalareyou.UI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matt.whichanimalareyou.R;

import java.util.HashMap;

public class FinalActivity extends AppCompatActivity {
    TextView mAnimalTextView;
    ImageView mImageView;
    String mAnimal;
    HashMap<String, Drawable> mDrawables;
    Button mReplayButton;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        makeDrawableMap();

        Intent intent = getIntent();
        mAnimal = intent.getStringExtra("animal");
        mReplayButton = (Button)findViewById(R.id.replayButton);

        mAnimalTextView = (TextView) findViewById(R.id.animalTextView);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setImageDrawable(mDrawables.get(mAnimal));
        mAnimalTextView.setText("You are a " +mAnimal +" !");

        mReplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                //finish();
            }
        });









    }

    private void makeDrawableMap() {
        mDrawables = new HashMap<String,Drawable>();
        mDrawables.put("Dolphin",getResources().getDrawable(R.drawable.dolphin));
        mDrawables.put("Elephant",getResources().getDrawable(R.drawable.elephant));
        mDrawables.put("Monkey",getResources().getDrawable(R.drawable.monkey));
        mDrawables.put("Red Panda",getResources().getDrawable(R.drawable.redpanda));
        mDrawables.put("Tiger",getResources().getDrawable(R.drawable.tiger));

    }

}
