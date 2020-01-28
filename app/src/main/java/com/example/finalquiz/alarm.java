package com.example.finalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class alarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
    }

    public void setAlarm(View view){

        //get info from XML screen
        EditText msg = (EditText) findViewById(R.id.et_msg);
        EditText hour = (EditText)  findViewById(R.id.et_hour);
        EditText min = (EditText)  findViewById(R.id.et_min);

        CheckBox vibrate = findViewById(R.id.cb_vibrate);
        CheckBox mon = findViewById(R.id.cb_mon); // 2
        CheckBox tue = findViewById(R.id.cb_tue); // 3
        CheckBox wed = findViewById(R.id.cb_wed); // 4
        CheckBox thu = findViewById(R.id.cb_thu); // 5
        CheckBox fri = findViewById(R.id.cb_fri); // 6
        CheckBox sat = findViewById(R.id.cb_sat); // 7
        CheckBox sun = findViewById(R.id.cb_sun); // 1

        vibrate.isChecked();

        ArrayList<Integer> weekdays = new ArrayList<Integer>();

        if (mon.isChecked()){
            weekdays.add(2);
        }
        if (tue.isChecked()){
            weekdays.add(3);
        }
        if (wed.isChecked()){
            weekdays.add(4);
        }
        if (thu.isChecked()){
            weekdays.add(5);
        }
        if (fri.isChecked()){
            weekdays.add(6);
        }
        if (sat.isChecked()){
            weekdays.add(7);
        }
        if (sun.isChecked()){
            weekdays.add(1);
        }


        int iMin = Integer.parseInt(min.getText().toString());
        int iHour = Integer.parseInt(hour.getText().toString());

        createAlarm(msg.getText().toString(), iHour, iMin, vibrate.isChecked(),weekdays);

    }

    public void createAlarm(String message, int hour, int minutes, boolean vibrate, ArrayList<Integer> weekdays ) {

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                .putExtra(AlarmClock.EXTRA_DAYS, weekdays)
                .putExtra(AlarmClock.EXTRA_VIBRATE, vibrate);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
