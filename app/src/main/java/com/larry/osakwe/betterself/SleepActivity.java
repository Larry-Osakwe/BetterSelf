package com.larry.osakwe.betterself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class SleepActivity extends AppCompatActivity {

    private Spinner hoursSpinner;
    private Spinner minuteSpinner;
    private Spinner ampmSpinner;
    private Button calcButton;
    private Calendar sleepyTime1;
    private Date time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        addItemsOnSpinner();
        addListenerOnButton();

    }

    public void addItemsOnSpinner() {
        hoursSpinner = (Spinner) findViewById(R.id.hour_spinner);
        List<String> hours = new ArrayList<String>();
        hours.add("(hour)");
        hours.add("1");
        hours.add("2");
        hours.add("3");
        hours.add("4");
        hours.add("5");
        hours.add("6");
        hours.add("7");
        hours.add("8");
        hours.add("9");
        hours.add("10");
        hours.add("11");
        hours.add("12");
        ArrayAdapter<String> hoursAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, hours);

        hoursAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hoursSpinner.setAdapter(hoursAdapter);

        minuteSpinner = (Spinner) findViewById(R.id.minute_spinner);
        List<String> minutes = new ArrayList<String>();
        minutes.add("(minute)");
        minutes.add("00");
        minutes.add("05");
        minutes.add("10");
        minutes.add("15");
        minutes.add("20");
        minutes.add("25");
        minutes.add("30");
        minutes.add("35");
        minutes.add("40");
        minutes.add("45");
        minutes.add("50");
        minutes.add("55");
        ArrayAdapter<String> minuteAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, minutes);

        minuteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minuteSpinner.setAdapter(minuteAdapter);

        ampmSpinner = (Spinner) findViewById(R.id.am_pm_spinner);
        List<String> ampm = new ArrayList<String>();
        ampm.add("AM");
        ampm.add("PM");

        ArrayAdapter<String> ampmAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, ampm);

        ampmAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ampmSpinner.setAdapter(ampmAdapter);

    }

    public void addListenerOnButton() {
        calcButton = (Button) findViewById(R.id.calculate);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (String.valueOf(hoursSpinner.getSelectedItem()).equals("(hour)") ||
                        String.valueOf(minuteSpinner.getSelectedItem()).equals("(minute)")) {
                    Toast.makeText(SleepActivity.this, "Please select time",
                            Toast.LENGTH_SHORT).show();
                } else {


                    try {
                        bedTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    TextView test = (TextView) findViewById(R.id.calcMessage);
                    test.setText("You should fall asleep at " + sleepyTime1.get(Calendar.HOUR) + ":"
                            + sleepyTime1.get(Calendar.MINUTE) + " " + ampm());
                }
            }
        });

    }

    public void bedTime() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        time = sdf.parse(String.valueOf(hoursSpinner.getSelectedItem()) + ":" +
                String.valueOf(minuteSpinner.getSelectedItem()) + " " +
                String.valueOf(ampmSpinner.getSelectedItem()));

        sleepyTime1 = Calendar.getInstance();
        sleepyTime1.setTime(time);
        sleepyTime1.add(Calendar.HOUR, -7);
        sleepyTime1.add(Calendar.MINUTE, -30);

    }

    public String ampm() {
        if (sleepyTime1.get(Calendar.AM_PM) == 0) {
            return "AM";
        }
        return "PM";


    }

}
