package com.example.floura.studentdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText regno,name;
    Button add,display,delete,update;
    DatabaseHandler databaseHandler;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regno = (EditText)findViewById(R.id.regno);
        name = (EditText)findViewById(R.id.name);
        add = (Button)findViewById(R.id.Add);
        display = (Button)findViewById(R.id.Display);
        delete = (Button)findViewById(R.id.Delete);
        update = (Button)findViewById(R.id.Update);
        textView = (TextView)findViewById(R.id.textView);
        databaseHandler = new DatabaseHandler(getApplicationContext(),"StudentDetails",null,1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHandler.addDetails(Integer.parseInt(regno.getText().toString()),name.getText().toString());
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String details = databaseHandler.displayDetails();
                textView.setText(details);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHandler.deleteDetails();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHandler.updateDetails();
            }
        });
    }
}
