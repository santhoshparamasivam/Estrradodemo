package com.sandhosh.estrradodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.sandhosh.estrradodemo.model.HomeResponseModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    List<HomeResponseModel.Featured> featuredList;
    Context mContext;

    public MyRecyclerViewAdapter(Context context, List<HomeResponseModel.Featured> featuredList) {
        this.mInflater = LayoutInflater.from(context);
        this. mContext=context;
        this. featuredList=featuredList;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text1.setText(featuredList.get(position).getPrdName());
        holder.text2.setText(featuredList.get(position).getUnit());
   holder.text3.setText(String.valueOf(featuredList.get(position).getPrice()));
        Picasso.with(mContext).load((featuredList.get(position).getPrdImage())).into(holder.imageView);
        holder.rating.setRating(Float.parseFloat(featuredList.get(position).getRating()));
    }

    @Override
    public int getItemCount() {
        return featuredList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView text1,text2,text3;
        RatingBar rating;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            text3 = itemView.findViewById(R.id.text3);
            rating=itemView.findViewById(R.id.rating);
        }
    }
}