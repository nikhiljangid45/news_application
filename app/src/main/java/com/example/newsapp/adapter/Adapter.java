package com.example.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.model.ModelClass;
import com.example.newsapp.activity.webVIew;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassArrayList;


    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(v->{
            Intent intent= new Intent(context, webVIew.class);
            intent.putExtra("url",modelClassArrayList.get(position).getUrl());
            context.startActivity(intent);
        });

        holder.mTime.setText(modelClassArrayList.get(position).getPublishedAt());
        holder.mAuthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mHeading.setText(modelClassArrayList.get(position).getTitle());
        holder.mContact.setText(modelClassArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mHeading,mContact,mAuthor,mTime;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            mHeading =itemView.findViewById(R.id.mainHeading);
            mContact =itemView.findViewById(R.id.content);
            mAuthor =itemView.findViewById(R.id.auther);
            mTime =itemView.findViewById(R.id.times);
            cardView =itemView.findViewById(R.id.cardView);
            imageView =itemView.findViewById(R.id.imageView);

        }
    }
}
