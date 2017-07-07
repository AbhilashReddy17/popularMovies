package com.android.abhilash.popularmovies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.abhilash.popularmovies.Utils.NetworkUtils;
import com.android.abhilash.popularmovies.data.MovieData;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abhilash Reddy on 6/24/2017.
 */

public class MovieDetailsActivity extends AppCompatActivity {
    public static final String MOVIE = "movie";
    @BindView(R.id.movie_title)
    TextView mmovieTitle;
    @BindView(R.id.movie_poster)
    ImageView mmoviePOster;
    @BindView(R.id.movie_overview)
    TextView mmovieOverview;
    @BindView(R.id.movie_rating)
    TextView mrating;
    @BindView(R.id.movie_releasedate)
    TextView mreleaseData;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_item_description);
        ButterKnife.bind(this);
        MovieData movie = getIntent().getParcelableExtra(MOVIE);

        mmovieTitle.setText(movie.getMmovieTitle());
        Picasso.with(this).load(NetworkUtils.POSTER_PATH + movie.getMmoviePOsterPath()).error(R.drawable.ic_broken_image_black_24dp).placeholder(R.drawable.ic_image_black_24dp).into(mmoviePOster);
        mreleaseData.setText(movie.getMreleaseData());
        mrating.setText(movie.getMrating());
        mmovieOverview.setText(movie.getMmovieOverview());

        ViewPagerAdapterForMovie adapterForMovie = new ViewPagerAdapterForMovie(getSupportFragmentManager());
        viewpager.setAdapter(adapterForMovie);
       TabLayout layout = (TabLayout) findViewById(R.id.tablayout);
        layout.setupWithViewPager(viewpager);
    }


}
