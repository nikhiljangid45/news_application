package com.example.newsapp.fragment;

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
import com.example.newsapp.service.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Technologyfragment extends Fragment {


    private String apiKey="83f4610591a142d6a76a89e0e6313868";
    private RecyclerView recyclerViewtech;
    private Adapter adapter;
    private String country = "in";
    private ArrayList<ModelClass> modelClassArrayList;

    private String category = "technology";
    public Technologyfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_technologyfragment, container, false);

        recyclerViewtech =v.findViewById(R.id.recyclerviewodtechnology);
        modelClassArrayList =new ArrayList<>();
        recyclerViewtech.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter =new Adapter(getContext(),modelClassArrayList);
        recyclerViewtech.setAdapter(adapter);


        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,apiKey).enqueue(new Callback<mainNews>() {
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
        return   v;
    }
}