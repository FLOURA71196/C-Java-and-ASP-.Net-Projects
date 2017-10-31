package com.example.floura.optionsmenujavacode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //first - group,second - id, third - order value, fourth - title
        menu.add(Menu.NONE,10,0,"one");
        menu.add(Menu.NONE,11,`1,"two");
        menu.add(Menu.NONE,12,2,"three");
        //add submenu through java code
        SubMenu subMenu = menu.addSubMenu(Menu.NONE,13,2,"fourth");
        subMenu.add(Menu.NONE,20,0,"Fourth1");
        subMenu.add(Menu.NONE,21,1,"Fourth2");
        subMenu.add(Menu.NONE,22,2,"Fourth3");
        return super.onCreateOptionsMenu(menu);
    }
}
