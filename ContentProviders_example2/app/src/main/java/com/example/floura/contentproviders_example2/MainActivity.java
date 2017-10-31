package com.example.floura.contentproviders_example2;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button save,log;
    EditText name,job;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.edittext1);
        name = (EditText)findViewById(R.id.edittext2);
        save = (Button)findViewById(R.id.button);
        log = (Button)findViewById(R.id.button2);
    }

    public void do_save(View view) {
        String username = name.getText().toString();
        String jobdesc = job.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("job",jobdesc);
        ContentResolver contentResolver = getContentResolver();

    }

    public void do_show(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        Cursor cursor = getContentResolver().query(EmployeeContentProvider.CONTENT_URI,null,null,null,null);
        while (cursor.moveToNext()){
            String usname = cursor.getString(0);
            String jobdec = cursor.getString(1);
            stringBuilder.append(usname+" : "+jobdec+"\n");
        }
    }
}
