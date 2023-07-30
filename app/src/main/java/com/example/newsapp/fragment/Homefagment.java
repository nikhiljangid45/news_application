package com.example.newsapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.R;
import com.example.newsapp.adapter.Adapter;
import com.example.newsapp.model.ModelClass;
import com.example.newsapp.model.mainNews;
import com.example.newsapp.service.ApiInterface;
import com.example.newsapp.service.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Homefagment extends Fragment {


    public Homefagment() {
        // Required empty public constructor
    }


    String apiKey="83f4610591a142d6a76a89e0e6313868";
    RecyclerView recyclerViewHome;
    Adapter adapter;
    String country = "in";
    ArrayList<ModelClass> modelClassArrayList;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_homefagment, container, false);

        recyclerViewHome =v.findViewById(R.id.recyclerviewodhome);
modelClassArrayList =new ArrayList<>();
recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
adapter =new Adapter(getContext(),modelClassArrayList);
recyclerViewHome.setAdapter(adapter);

findNews();








        return v;
    }

    private void findNews() {


        ApiUtilities.getApiInterface().getNews(country,100,apiKey).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}