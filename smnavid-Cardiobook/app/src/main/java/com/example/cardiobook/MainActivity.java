package com.example.cardiobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private static final String FILENAME = "file.sav";

    public Button addMeasurement;

    private ArrayList<Measurement> measurements = new ArrayList<Measurement>();
    private ArrayAdapter<Measurement> adapter;
    //private ArrayList<String> stringMeasurements = new ArrayList<>();

    public ArrayList<Measurement> getMeasurements() {
        return measurements;
    }

    private ListView listMeasurements;

    private Measurement measurement;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMeasurement = findViewById(R.id.addButton);
        listMeasurements = findViewById(R.id.addMes);

        adapter = new ArrayAdapter<Measurement>(getApplicationContext(), android.R.layout.simple_list_item_1, measurements);

        listMeasurements.setAdapter((adapter));

        listMeasurements.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                measurements.remove(measurements.get(position));
                adapter.notifyDataSetChanged();

            }
        });

        addMeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAdd();
            }
        });


    }

    /*
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        //loadFromFile();
        adapter = new ArrayAdapter<Measurement>(this, R.layout.activity_list_items, measurements);
        listMeasurements.setAdapter(adapter);
    }
*/
    public void gotoAdd(){
        Intent intent = new Intent(this, addentryactivity.class);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                this.measurement = (Measurement) data.getExtras().get("addedMeasurement");

                measurements.add(measurement);
                adapter.notifyDataSetChanged();

                }
        }
        int length = measurements.size();
        String length1 = Integer.toString(length);
        if(length>0){
            String measurement = measurements.get(0).toString();
            Log.d("TAG420", length1 + " "+ measurement);
        }


    }


}
