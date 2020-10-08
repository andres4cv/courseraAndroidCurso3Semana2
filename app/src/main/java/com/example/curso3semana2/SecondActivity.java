package com.example.curso3semana2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        String date = i.getStringExtra("date");
        String text1 = i.getStringExtra("text1");
        String text2 = i.getStringExtra("text2");
        String text3 = i.getStringExtra("text3");
        String text4 = i.getStringExtra("text4");
        TextInputEditText showText1 = (TextInputEditText) findViewById(R.id.textShow1);
        showText1.setText(text1);
        TextInputEditText showTextDate = (TextInputEditText) findViewById(R.id.textShowDate);
        showTextDate.setText(date);
        TextInputEditText showText2 = (TextInputEditText) findViewById(R.id.textShow2);
        showText2.setText(text2);
        TextInputEditText showText3 = (TextInputEditText) findViewById(R.id.textShow3);
        showText3.setText(text3);
        TextInputEditText showText4 = (TextInputEditText) findViewById(R.id.textShow4);
        showText4.setText(text4);
        showText1.setEnabled(false);
        showText2.setEnabled(false);
        showText3.setEnabled(false);
        showText4.setEnabled(false);
        showTextDate.setEnabled(false);
    }
}
