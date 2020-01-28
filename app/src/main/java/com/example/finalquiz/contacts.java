package com.example.finalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

public class contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conatcts);
    }

    public void addContact(View view){
        //String name = "Carla Klaes";
        //String email = "carla@carla.com";
        //String phone = "(647)231-3812";

        EditText name = (EditText) findViewById(R.id.et_name);
        EditText email = (EditText)  findViewById(R.id.et_email);
        EditText phone = (EditText)  findViewById(R.id.et_phone);

        insertContact(name.getText().toString(), email.getText().toString(), phone.getText().toString());
    }

    public void insertContact(String name, String email, String phone) {

        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }

    }
}
