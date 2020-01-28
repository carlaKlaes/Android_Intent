package com.example.finalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }

    public void sendEmail(View view){

        EditText to = (EditText) findViewById(R.id.et_to);
        EditText cc = (EditText)  findViewById(R.id.et_cc);
        EditText bcc = (EditText)  findViewById(R.id.et_bcc);
        EditText sub = (EditText)  findViewById(R.id.et_subject);
        EditText body = (EditText)  findViewById(R.id.et_message);

        String subject = body.getText().toString();
        String[] addresses = to.getText().toString().split(",");
        String[] bccAddress = bcc.getText().toString().split(",");
        String[] ccAddress = cc.getText().toString().split(",");
        String textBody = body.getText().toString();

        composeEmail(addresses,bccAddress, ccAddress,subject,textBody);

    }

    public void composeEmail(String[] addresses, String[] bccAddress, String[] ccAddress, String subject, String textBody) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_TEXT, textBody);
        intent.putExtra(Intent.EXTRA_CC, ccAddress);
        intent.putExtra(Intent.EXTRA_BCC, bccAddress);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}
