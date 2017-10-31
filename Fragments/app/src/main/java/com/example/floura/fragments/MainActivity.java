package com.example.floura.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Fragments - List (xml+java) and Text
        1 . Fragment class for above both
        2. override oncreateview
        3. create obj of xml and inflate it
        4. Add fragment - java/xml
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
