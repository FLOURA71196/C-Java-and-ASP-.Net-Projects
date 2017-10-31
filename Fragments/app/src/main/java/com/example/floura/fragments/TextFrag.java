package com.example.floura.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by floura on 28/10/17.
 */

public class TextFrag extends Fragment{
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(
              R.layout.text_frag,
                container,
                false
        );
        //find the instance of the textview
        textView = (TextView) view.findViewById(R.id.textView);
        return view;
    }
}
