package com.example.floura.exam1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Button b1,b2;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView)findViewById(R.id.text1);
        //Toast.makeText(MainActivity.this, t1.getText().toString(), Toast.LENGTH_LONG).show();
        b1 = (Button)findViewById(R.id.button1);
       // Toast.makeText(MainActivity.this,b1.getText().toString(), Toast.LENGTH_LONG).show();
        e1 = (EditText)findViewById(R.id.pass);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setTextColor(Color.rgb(123,15,87));
                //Toast.makeText(MainActivity.this,e1.getText().toString(), Toast.LENGTH_LONG).show();

            }
        });
        Intent intent = new Intent(this,Exam12.class);
        //this.startActivity(intent);
        b2 = (Button)findViewById(R.id.button);
        registerForContextMenu(b2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderIcon(android.R.drawable.btn_default);
        menu.setHeaderTitle("Mymenu");
        menu.add(Menu.NONE,10,1,"Floura");
    }
}
