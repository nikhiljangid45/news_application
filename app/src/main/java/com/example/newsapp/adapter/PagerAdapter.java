package com.example.newsapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapp.fragment.Entertainmentfragment;
import com.example.newsapp.fragment.Healthfagment;
import com.example.newsapp.fragment.Homefagment;
import com.example.newsapp.fragment.Sciencefagment;
import com.example.newsapp.fragment.Sportsfragment;
import com.example.newsapp.fragment.Technologyfragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private int tabCount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount =behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new Homefagment();
            case 1:
                return  new Sportsfragment();
            case 2:
                return  new Healthfagment();
            case 3:
                return  new Sciencefagment();
            case 4:
                return  new Entertainmentfragment();
            case 5:
                return  new Technologyfragment();
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
