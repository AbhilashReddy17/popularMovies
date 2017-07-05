package com.android.abhilash.popularmovies.Utils;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.android.abhilash.popularmovies.MainActivity;
import com.android.abhilash.popularmovies.data.MovieData;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class MoviesAsynkTask extends AsyncTask<String, Integer, List<MovieData>> {

    MainActivity activity;

    public MoviesAsynkTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        activity.showProgressbar();
    }

    @Override
    protected List<MovieData> doInBackground(String... strings) {
        URL url = null;
        List<MovieData> movieDataList = Collections.EMPTY_LIST;
        try {
            url = new URL(strings[0]);
            String string = NetworkUtils.getResultFromURL(url);
            movieDataList = MoviesJSONDataConvertion.getJsonData(string);
            return movieDataList;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieDataList;
    }

    @Override
    protected void onPostExecute(List<MovieData> movieDataList) {
        activity.loadMoviesList(movieDataList);
        activity.hideProgressbar();

    }
}
