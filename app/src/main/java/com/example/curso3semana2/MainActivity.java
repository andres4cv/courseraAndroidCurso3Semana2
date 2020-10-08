package com.example.curso3semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button siguiente = (Button) findViewById(R.id.btnSiguiente);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayDate = (TextView) findViewById(R.id.selectFecha);


        mDisplayDate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy: " + dayOfMonth + "/" + month + "/" + year);

                String date = dayOfMonth + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

    }

    public void nextAct(View view){

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        TextInputEditText text1 = (TextInputEditText) findViewById(R.id.textField1);
        TextInputEditText text2 = (TextInputEditText) findViewById(R.id.textField2);
        TextInputEditText text3 = (TextInputEditText) findViewById(R.id.textField3);
        TextInputEditText text4 = (TextInputEditText) findViewById(R.id.textField4);
        String date = mDisplayDate.getText().toString();
        String text1Str = text1.getText().toString();
        String text2Str = text2.getText().toString();
        String text3Str = text3.getText().toString();
        String text4Str = text4.getText().toString();
        intent.putExtra("date", date);
        intent.putExtra("text1", text1Str);
        intent.putExtra("text2", text2Str);
        intent.putExtra("text3", text3Str);
        intent.putExtra("text4", text4Str);
        startActivity(intent);
    }
}