package com.android.abhilash.popularmovies.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Abhilash Reddy on 6/23/2017.
 */

public class MovieData implements Parcelable {
    private String mmovieTitle;
    private String mmoviePOsterPath;
    private String mmovieOverview;
    private String mrating;
    private String mreleaseData;
    private String mmovie_id;

    public String getMmovieTitle() {
        return mmovieTitle;
    }


    public String getMmoviePOsterPath() {
        return mmoviePOsterPath;
    }

    public String getMmovieOverview() {
        return mmovieOverview;
    }


    public String getMrating() {
        return mrating;
    }

    public String getMovie_id() {
        return mmovie_id;
    }

    public String getMreleaseData() {
        return mreleaseData;
    }

    public MovieData(String mmovieTitle, String mmoviePOsterPath, String mmovieOverview, String mrating, String mreleaseData,String mmovie_id) {
        this.mmovieTitle = mmovieTitle;
        this.mmoviePOsterPath = mmoviePOsterPath;
        this.mmovieOverview = mmovieOverview;
        this.mrating = mrating;
        this.mreleaseData = mreleaseData;
        this.mmovie_id = mmovie_id;
    }

    protected MovieData(Parcel in) {
        mmovieTitle = in.readString();
        mmoviePOsterPath = in.readString();
        mmovieOverview = in.readString();
        mrating = in.readString();
        mreleaseData = in.readString();
        mmovie_id=in.readString();
    }

    public MovieData() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mmovieTitle);
        dest.writeString(mmoviePOsterPath);
        dest.writeString(mmovieOverview);
        dest.writeString(mrating);
        dest.writeString(mreleaseData);
        dest.writeString(mmovie_id);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MovieData> CREATOR = new Parcelable.Creator<MovieData>() {
        @Override
        public MovieData createFromParcel(Parcel in) {
            return new MovieData(in);
        }

        @Override
        public MovieData[] newArray(int size) {
            return new MovieData[size];
        }
    };
}