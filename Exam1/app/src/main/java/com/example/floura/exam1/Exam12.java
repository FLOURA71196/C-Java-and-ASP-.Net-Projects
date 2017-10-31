package com.example.floura.exam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Exam12 extends AppCompatActivity {
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam12);
        // Array of choices
        final String colors[] = {"Red","Blue","White","Yellow","Black", "Green","Purple","Orange","Grey"};

// Selection of the spinner
        final Spinner spinner = (Spinner) findViewById(R.id.myspinner);

// Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, colors);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(Exam12.this,spinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
             //   Toast.makeText(Exam12.this,"Nothing Selected", Toast.LENGTH_LONG).show();
            }
        });
//ListView
        l = (ListView)findViewById(R.id.list);
        final String planets[] = {"Mars","Earth","Venus","Mercury"};
        ArrayAdapter<String> mylist = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,planets);
        l.setAdapter(mylist);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(planets[position].equals("Mars")){
                    Toast.makeText(Exam12.this,"Mangalyan", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(Exam12.this,planets[position], Toast.LENGTH_LONG).show();
            }
        });

    }
}
