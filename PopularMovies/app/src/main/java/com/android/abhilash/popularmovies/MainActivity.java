package com.android.abhilash.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.android.abhilash.popularmovies.Utils.MoviesAsynkTask;
import com.android.abhilash.popularmovies.Utils.NetworkUtils;
import com.android.abhilash.popularmovies.data.MovieData;
import com.android.abhilash.popularmovies.data.RecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.posters_recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.pb_indicator)
    ProgressBar mprogressbar;
    public static List<MovieData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureViews();

        //loading the movies by default popular movies
        loadingTheMovies(NetworkUtils.POPULAR_MOVIES);

    }

    private void loadingTheMovies(int category) {

        MoviesAsynkTask task = new MoviesAsynkTask(this);
        task.execute(NetworkUtils.buildURL(this, category).toString());
    }

    private void configureViews() {
        //binding butterknife
        ButterKnife.bind(this);
    }

    public void loadMoviesList(List<MovieData> list) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }


    public void showProgressbar() {
        mprogressbar.setVisibility(View.VISIBLE);
    }

    public void hideProgressbar() {
        mprogressbar.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_popularmovie:
                loadingTheMovies(NetworkUtils.POPULAR_MOVIES);
                return true;
            case R.id.menu_topratedmovies:
                loadingTheMovies(NetworkUtils.TOP_RATED_MOVIES);
                return true;

            default:
                return true;
        }
    }
}
