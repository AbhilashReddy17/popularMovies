package com.android.abhilash.popularmovies.ViewPagerFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.abhilash.popularmovies.R;

/**
 * Created by Abhilash Reddy on 7/7/2017.
 */

public class TrailersFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_list,container,false);


        return view;
    }
}
