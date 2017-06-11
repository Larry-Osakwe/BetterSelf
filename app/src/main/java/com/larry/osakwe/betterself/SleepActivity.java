package com.larry.osakwe.betterself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Calendar;

public class SleepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        Calendar cal = Calendar.getInstance();


        TextView test = (TextView)findViewById(R.id.test);
        test.setText(""+cal.get(Calendar.HOUR_OF_DAY));


    }
}
