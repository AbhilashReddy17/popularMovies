package com.android.abhilash.popularmovies.data;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.abhilash.popularmovies.MovieDetailsActivity;
import com.android.abhilash.popularmovies.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.android.abhilash.popularmovies.Utils.NetworkUtils.POSTER_PATH;

/**
 * Created by Abhilash Reddy on 6/23/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DataHolder> {


    private static final String TAG = RecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private List<MovieData> movieDataList;

    public RecyclerViewAdapter(Context context, List<MovieData> movieDataList) {
        this.movieDataList = movieDataList;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new RecyclerViewAdapter.DataHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.DataHolder holder, int position) {
        String imagePath = POSTER_PATH + movieDataList.get(position).getMmoviePOsterPath();
        Picasso.with(context).load(imagePath).error(R.drawable.ic_broken_image_black_24dp).placeholder(R.drawable.ic_image_black_24dp).into(holder.poster_movie);
        holder.poster_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MovieDetailsActivity.class);
                intent.putExtra(MovieDetailsActivity.MOVIE, movieDataList.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieDataList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_poster)
        ImageView poster_movie;

        public DataHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
