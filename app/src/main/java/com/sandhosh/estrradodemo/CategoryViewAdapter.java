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

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewAdapter extends RecyclerView.Adapter<CategoryViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    List<HomeResponseModel.Category> featuredList;
    Context mContext;

    public CategoryViewAdapter(Context context, List<HomeResponseModel.Category> featuredList) {
        this.mInflater = LayoutInflater.from(context);
        this. mContext=context;
        this. featuredList=featuredList;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.category_list, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (featuredList.get(position).getCategoryImage()!=null) {
            Picasso.with(mContext).load((featuredList.get(position).getCategoryImage())).into(holder.imageView);
        }else{
            Picasso.with(mContext).load((R.drawable.home_logo)).into(holder.imageView);
        }
        holder.text1.setText(String.valueOf(featuredList.get(position).getCategoryName()));
    }

    @Override
    public int getItemCount() {
        return featuredList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView text1,text2;
        RatingBar rating;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            text1 = itemView.findViewById(R.id.text1);

        }
    }
}