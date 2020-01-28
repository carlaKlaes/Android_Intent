package com.example.finalquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.os.EnvironmentCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class picture extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE = 1;
    String imageFilePath;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_picture);
    }

    public void camera (View view){

        String targetFilename = "3.jpg";

        imageView = (ImageView) findViewById(R.id.img_photo);

        capturePhoto(targetFilename);
    }


    /*public void capturePhoto(String targetFilename) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Uri locationForPhotos = Uri.parse(Environment.DIRECTORY_DCIM);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.withAppendedPath(locationForPhotos, targetFilename));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

        }
    }*/

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap thumbnail = (Bitmap) data.getParcelableExtra("data");
            ImageView imageView = (ImageView) myview.findViewById(R.id.img_photo);
            imageView.setImageBitmap(thumbnail);

        }
    }*/

    public void capturePhoto(String targetFilename) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            startActivityForResult(intent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(thumbnail);


    }

}
