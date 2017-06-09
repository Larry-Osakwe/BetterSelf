package com.larry.osakwe.betterself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView sleepImage = (ImageView) findViewById(R.id.sleep_image);
        //Set a click listener on that view
        sleepImage.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent sleepIntent = new Intent(MainActivity.this, SleepActivity.class);
                startActivity(sleepIntent);
            }
        });

        ImageView eatImage = (ImageView) findViewById(R.id.eat_image);
        //Set a click listener on that view
        eatImage.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent eatIntent = new Intent(MainActivity.this, EatActivity.class);
                startActivity(eatIntent);
            }
        });

    }
}
