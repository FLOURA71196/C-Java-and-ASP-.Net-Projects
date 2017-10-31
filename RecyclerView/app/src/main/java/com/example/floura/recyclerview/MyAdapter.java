package com.example.floura.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by floura on 17/10/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    String title[],des[];
    int imgres[];
    Context context;

    public MyAdapter(Context mainContext,int img[],String s1[],String s2[]){
        context = mainContext;
        title = s1;
        des = s2;
        imgres = img;
    }

    /*
    inflate activity_second and stores in recycler view
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //view object contains java object of activity_second
        View view = layoutInflater.inflate(R.layout.activity_second,parent,false);
        Log.i("status","oncreate");
        return new MyViewHolder(view);
    }

    /*
    set value dynamically - after oncreate all the time, except when already created
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(title[position]);
        holder.textView2.setText(des[position]);
        holder.imageView.setImageResource(imgres[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }
}
