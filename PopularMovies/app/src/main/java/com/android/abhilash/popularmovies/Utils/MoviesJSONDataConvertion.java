package com.android.abhilash.popularmovies.Utils;

import android.support.annotation.NonNull;

import com.android.abhilash.popularmovies.data.MovieData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhilash Reddy on 6/23/2017.
 */

public class MoviesJSONDataConvertion {

    public static final String RESULTS = "results";
    public static final String ORIGINAL_TITLE = "original_title";
    public static final String POSTER_PATH = "poster_path";
    public static final String OVERVIEW = "overview";
    public static final String VOTE_AVERAGE = "vote_average";
    public static final String RELEASE_DATE = "release_date";
    public static final String MOVIE_ID = "id";

    public static List<MovieData> getJsonData(String data) {
        JSONObject jsonObject;
        List<MovieData> movieList = new ArrayList<>();
        try {
            jsonObject = new JSONObject(data);
            if (jsonObject.has(RESULTS)) {
                JSONArray resultArray = jsonObject.getJSONArray(RESULTS);
                for (int i = 0; i < resultArray.length(); i++) {
                    JSONObject movieObject = (JSONObject) resultArray.get(i);
                    MovieData movie = getMovie(movieObject);
                    movieList.add(i, movie);
                }

            } else {
                return null;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    @NonNull
    private static MovieData getMovie(JSONObject movieObject) throws JSONException {
        String mmovieTitle = movieObject.getString(ORIGINAL_TITLE);
        String mmoviePOsterPath = movieObject.getString(POSTER_PATH);
        String mmovieOverview = movieObject.getString(OVERVIEW);
        String mrating = movieObject.getString(VOTE_AVERAGE);
        String mreleaseData = movieObject.getString(RELEASE_DATE);
        String mmovie_id = movieObject.getString(MOVIE_ID);
        return new MovieData(mmovieTitle, mmoviePOsterPath, mmovieOverview, mrating, mreleaseData,mmovie_id);
    }
}
