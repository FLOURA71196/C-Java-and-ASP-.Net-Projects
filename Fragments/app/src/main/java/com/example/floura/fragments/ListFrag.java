package com.example.floura.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by floura on 28/10/17.
 */

public class ListFrag extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //for converting it to java object
        View view =inflater.inflate(
          R.layout.list_frag, //which one
                container, //to which
                false //to attach it or not
        );
        //now to add in listview = view will point to the linear layout to enable to access all its member
        //obj of listview with view
        ListView listView = (ListView) view.findViewById(R.id.listview);
        //data source
        String planets[] = {"Mars","Earth","Jupiter","Saturn","Mercury"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getActivity(), //activity where current frag is associated = Main
                android.R.layout.simple_list_item_1,
                planets
        );
        //set adapter content in list view
        listView.setAdapter(arrayAdapter);
        //event handling in listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //retrieve the detail of the element selected
                TextView textView = (TextView)view;
                String data = textView.getText().toString();
                /*pass data to the text_frag
                find the fragment - Fragment Manager
                1. get fragment Manager : to manage all fragments
                 */
                FragmentManager fragmentManager = getFragmentManager();
                TextFrag textFrag = (TextFrag) fragmentManager.findFragmentById(R.id.fragment2);
                textFrag.textView.setText(data);
            }
        });
        return view;
    }
}
