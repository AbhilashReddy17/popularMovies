package com.android.abhilash.popularmovies.Utils;

import android.content.Context;
import android.net.Uri;

import com.android.abhilash.popularmovies.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Abhilash Reddy on 6/23/2017.
 */

public class NetworkUtils {
    public static final int POPULAR_MOVIES = 0;
    public static final int TOP_RATED_MOVIES = 1;
    public static final String POSTER_PATH = "https://image.tmdb.org/t/p/w185";
    private static final String SCHEME = "https";
    private static final String AUTHORITY = "api.themoviedb.org";
    private static final String PATH_NUMBER = "3";
    private static final String PATH_MOVIE = "movie";
    private static final String PATH_TOPRATED_MOVIES = "top_rated";
    public static final String PATH_POPULAR_MOVIES = "popular";
    private static final String API_KEY_PARAM = "api_key";
    private static final String LANGUAGE_PARAM = "language";
    private static final String SORT_PARAM = "sort_by";

    private static final String LANGUAGE_VLAUE = "en-US";
    private static final String SORT_VALUE = "popularity.desc";
    private static final String TAG = NetworkUtils.class.getSimpleName();


    public static URL buildURL(Context context, int type) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(PATH_NUMBER)
                .appendPath(PATH_MOVIE);
        //checking if the requested type is top rated movies then appending the path
        if (type == TOP_RATED_MOVIES) {
            //if the requested URL is for the Top Rated Movies then modifying accordingly appending top_rated to the path
            builder.appendPath(PATH_TOPRATED_MOVIES);
        } else {
            //if the requested url is popular movies then appending the accordingly
            builder.appendPath(PATH_POPULAR_MOVIES);
        }

        builder.appendQueryParameter(API_KEY_PARAM, context.getResources().getString(R.string.api_key))
                .appendQueryParameter(LANGUAGE_PARAM, LANGUAGE_VLAUE)
                .appendQueryParameter(SORT_PARAM, SORT_VALUE);

        Uri uri = builder.build();

        URL url = null;

        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }


    public static String getResultFromURL(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = connection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            String result = null;
            if (hasInput) {
                result = scanner.next();
            } else return null;
            return result;
        } finally {
            //closing the connection whatsoever after everything is done
            connection.disconnect();
        }

    }


}
