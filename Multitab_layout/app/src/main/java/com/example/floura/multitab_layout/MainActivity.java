package com.example.floura.multitab_layout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        1. NoActionBar
        2. ToolBar
        3. ViewPAger - for sliding option
        4. For content to be displaced use of fragments - 3 fragments
        5. class to return relevant slide option
        6. Find TabLayout
        7. MyAdapter obj
        8. MyAdapter & ViewPager link - set adapter
        9. Return Fragment position
        10. Event handling in viewpager
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Multi Taabs");
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        /*
        to change the selected tabon click
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
         */
        
        //object of adapter - getFrgmentMang instance
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(myAdapter);
        //change from one tab to another
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
