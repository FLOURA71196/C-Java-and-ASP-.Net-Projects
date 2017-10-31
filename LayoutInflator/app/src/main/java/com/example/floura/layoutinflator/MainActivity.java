package com.example.floura.layoutinflator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout)findViewById(R.id.activity_main);
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(
                R.layout.layout1,
                null
        );
        linearLayout.addView(view);
        button = (Button)view.findViewById(R.id.button);
        button.setText("Another");
        if(view instanceof Button){
            //Toast
        }
    }
}
