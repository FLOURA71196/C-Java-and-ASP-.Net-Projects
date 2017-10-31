package com.example.floura.optionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate- load the menu to the activity
        //get inflate
        MenuInflater menuInflater = getMenuInflater();
        //int-menuresoucre fie,menu objevct
        menuInflater.inflate(R.menu.my_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    //handle menu item - whenevr menu item clicked

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle()+" is clicked",Toast.LENGTH_SHORT).show();
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.file1:
                break;
            case R.id.file2:
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
