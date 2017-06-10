package com.larry.osakwe.betterself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.larry.osakwe.betterself.R.id.tdee;

public class EatActivity extends AppCompatActivity {

    private int age;
    private double feet;
    private double inches;
    private double weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);

        Button calcButton = (Button) findViewById(R.id.calculate);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayTDEE(""+ tdeeCalc());
            }
        });


    }


    private double bmrCalc() {
        RadioGroup radioGroupCity = (RadioGroup) findViewById(R.id.male_or_female);
        RadioButton trueCheckRadioButton = (RadioButton) radioGroupCity.findViewById(radioGroupCity.getCheckedRadioButtonId());
        boolean checked = (trueCheckRadioButton.isChecked());

        switch (trueCheckRadioButton.getId()) {
            case R.id.male:
                if (checked) {
                    return menBMR(age(), height(), weight());

                }
            case R.id.female:
                if (checked) {
                    return women(age(), height(), weight());
                }
        }

        return -1;
    }

    private double tdeeCalc() {
        RadioGroup radioGroupCity = (RadioGroup) findViewById(R.id.activity_group);
        RadioButton trueCheckRadioButton = (RadioButton) radioGroupCity.findViewById(radioGroupCity.getCheckedRadioButtonId());
        boolean checked = (trueCheckRadioButton.isChecked());

        switch (trueCheckRadioButton.getId()) {
            case R.id.sedantary:
                if (checked) {
                    return 1.2 * bmrCalc();
                }
            case R.id.lightly_active:
                if (checked) {
                    return 1.375 * bmrCalc();
                }
            case R.id.moderately_active:
                if (checked) {
                    return 1.55 * bmrCalc();

                }
            case R.id.very_active:
                if (checked) {
                    return 1.725 * bmrCalc();
                }
        }
        return -1;
    }





    private void displayTDEE(String tdeeCalc) {
        TextView tdeeView = (TextView) findViewById(tdee);
        tdeeView.setText("" + tdeeCalc);
    }


    private double menBMR(int age, double height, double weight) {
        return 66 + (6.2 * weight) + (12.7 * height) - (6.76 * age);
    }

    private double women(int age, double height, double weight) {
        return 665.1 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
    }

    private int age() {
        EditText ageField = (EditText) findViewById(R.id.age);
        if (ageField.getText().toString().equals(null) || ageField.getText().toString().equals("")) {
            return 0;
        }
        int finalValue = Integer.parseInt(ageField.getText().toString());
        return finalValue;
    }

    private double height() {
        EditText feetField = (EditText) findViewById(R.id.feet);
        if (feetField.getText().toString().equals(null) || feetField.getText().toString().equals("")) {
            return 0;
        }
        int feetValue = Integer.parseInt(feetField.getText().toString());

        EditText inchField = (EditText) findViewById(R.id.inches);
        if (inchField.getText().toString().equals(null) || inchField.getText().toString().equals("")) {
            return 0;
        }
        int inchValue = Integer.parseInt(inchField.getText().toString());

        return 12*feetValue + inchValue;
    }

    private double weight() {
        EditText weightField = (EditText) findViewById(R.id.weight);
        if (weightField.getText().toString().equals(null) || weightField.getText().toString().equals("")) {
            return 0;
        }
        int weightValue = Integer.parseInt(weightField.getText().toString());
        return weightValue*1.0;
    }






}
