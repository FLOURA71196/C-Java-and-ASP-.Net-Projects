package com.example.floura.exam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Exam1 extends AppCompatActivity {
    Button b1;
    CheckBox c1,c2,c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);
        b1 = (Button)findViewById(R.id.bselect);
        c1 = (CheckBox)findViewById(R.id.ios);
        c2 = (CheckBox)findViewById(R.id.android);
        c3 = (CheckBox)findViewById(R.id.windows);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer res = new StringBuffer();
                res.append("IOS").append(c1.isChecked());
                res.append("Windows").append(c3.isChecked());
                res.append("Android").append(c2.isChecked());
                Toast.makeText(Exam1.this,res, Toast.LENGTH_LONG).show();
            }
        });
    }
}
