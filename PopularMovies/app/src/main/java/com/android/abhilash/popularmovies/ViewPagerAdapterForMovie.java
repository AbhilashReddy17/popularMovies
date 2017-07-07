package com.android.abhilash.popularmovies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.android.abhilash.popularmovies.ViewPagerFragments.ReviewsFragment;
import com.android.abhilash.popularmovies.ViewPagerFragments.TrailersFragment;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Abhilash Reddy on 7/7/2017.
 */

public class ViewPagerAdapterForMovie extends FragmentStatePagerAdapter {
    public ViewPagerAdapterForMovie(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        return new TrailersFragment();
        else
            return new ReviewsFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "Trailers";
        else
            return "Reviews";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
