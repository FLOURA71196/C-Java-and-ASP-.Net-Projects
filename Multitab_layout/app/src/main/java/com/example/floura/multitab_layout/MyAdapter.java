package com.example.floura.multitab_layout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by floura on 28/10/17.
 * To return relevant fragment to display
 */

public class MyAdapter extends FragmentStatePagerAdapter {
    private int tabcount;
    public MyAdapter(FragmentManager fm,int tabcount) {
        super(fm);
        this.tabcount = tabcount;
    }

    @Override
    public Fragment getItem(int position) {
        //start default = 0 ,tab position
        switch (position){
            case 0:return new Fragment1();
            case 1:return new Fragment2();
            case 2:return new Fragment3();
            default:return null;
        }
    }

    /*
    used to specify the number of tabs to manage
     */
    @Override
    public int getCount() {
        return tabcount;
    }
}
