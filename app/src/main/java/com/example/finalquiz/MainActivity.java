package com.example.finalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addAlarm(View view){

        Intent intent = new Intent(this,alarm.class);
        startActivity(intent);

    }

    public void addPhoto(View view){

        Intent intent = new Intent(this,picture.class);
        startActivity(intent);

    }

    public void addNewContact(View view){

        Intent intent = new Intent(this,contacts.class);
        startActivity(intent);

    }

    public void openbroser(View view){

        Intent intent = new Intent(this,browser.class);
        startActivity(intent);

    }

    public void openemail(View view){

        Intent intent = new Intent(this,email.class);
        startActivity(intent);

    }

    public void openaudio(View view){

        Intent intent = new Intent(this,audiofile.class);
        startActivity(intent);

    }



}
