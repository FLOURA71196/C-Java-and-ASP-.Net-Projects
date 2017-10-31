package com.example.floura.serviceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);
        //check the thread id
        Log.i("mylog","Thread in main: "+Thread.currentThread().getId());
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start the service
                Intent intent = new Intent(getApplicationContext(),MyService.class);
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MyService.class);
                stopService(intent);
            }
        });
    }
}
