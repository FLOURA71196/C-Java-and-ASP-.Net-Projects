package com.example.floura.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * this class holds reference to ui components
 * Created by floura on 17/10/17.
 */


public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView,textView2;
    public MyViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        textView = (TextView) itemView.findViewById(R.id.textView);
        textView2 = (TextView)itemView.findViewById(R.id.textView);
    }
}
