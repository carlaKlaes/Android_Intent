package com.example.finalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class audiofile extends AppCompatActivity {

    TextView etFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiofile);
    }

    public void playAudio (View view){

        playAudioFile();
        etFile = (TextView) findViewById(R.id.et_audio_file);

    }

    public void playAudioFile() {

        Intent intent = new Intent();

        intent.setType("audio/mp3");

        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(
                intent, "Open Audio (mp3) file"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri audioFileUri = data.getData();
            // Do work with full size photo saved at fullPhotoUri

            etFile.setText(audioFileUri.getPath());

        }
    }

}
