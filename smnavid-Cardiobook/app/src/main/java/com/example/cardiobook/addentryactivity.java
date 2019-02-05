package com.example.cardiobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addentryactivity extends AppCompatActivity {

    EditText etDate;
    EditText etTime;
    EditText etSys;
    EditText etDia;
    EditText ethr;
    EditText etComment;
    Button addEntry;
    Measurement measurement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addentryactivity);

        etDate = findViewById(R.id.editDate);
        etTime = findViewById(R.id.editTime);
        etSys = findViewById(R.id.editSys);
        etDia = findViewById(R.id.editDia);
        ethr = findViewById(R.id.editHr);
        etComment = findViewById(R.id.editCom);

        addEntry = findViewById(R.id.addEntry);







        addEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = etSys.getText().toString();
                int sys = Integer.parseInt(text);
                String text2 = etDia.getText().toString();
                int dia = Integer.parseInt(text2);
                String text3 = ethr.getText().toString();
                int hr = Integer.parseInt(text3);
                String dob_var = etDate.getText().toString();
                Date date = toDate(dob_var);
                String text4 = etTime.getText().toString();
                Date time = toTime(text4);

                String comment = etComment.getText().toString();


                Measurement measurement1 = new Measurement(date,time,sys,dia,hr);
                measurement = measurement1;

                if(comment != null){
                    measurement.setComment(comment);
                }

                GoToPrevActivity(measurement);

            }
        });


    }

    private Date toDate(String dob_var){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date myDate = new Date();
        try {
            myDate = df.parse(dob_var);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return myDate;
    }

    private Date toTime(String text) {

        DateFormat formatter = new SimpleDateFormat("hh:mm");
        Date date = new Date();
        try {
            date = formatter.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private void GoToPrevActivity(Measurement measurement){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("addedMeasurement", measurement);
        setResult(RESULT_OK, intent);
        finish();
    }
}
