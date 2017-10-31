package com.example.floura.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        textView =(TextView)findViewById(R.id.textView);
    }

    //save info
    public void save_info(View view){
        //only this application
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("username",edit1.getText().toString());
        edit.putString("password",edit2.getText().toString());
        edit.apply();

        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
    }

    //display info
    public void display(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("username","");
        String password = sharedPreferences.getString("password","");
        textView.setText(name +" " +password);
    }
}
