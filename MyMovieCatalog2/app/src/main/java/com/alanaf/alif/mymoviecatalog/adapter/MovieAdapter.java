package com.alanaf.alif.mymoviecatalog.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alanaf.alif.mymoviecatalog.DetailActivity;
import com.alanaf.alif.mymoviecatalog.MainActivity;
import com.alanaf.alif.mymoviecatalog.R;
import com.alanaf.alif.mymoviecatalog.model.MovieFilm;
import com.squareup.picasso.Picasso;

import java.util.List;
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<MovieFilm> movies;
    private int rowLayout;
    private Context context;
    public static final String IMAGE_URL_BASE_PATH="https://image.tmdb.org/t/p/w342//";
    public MovieAdapter(List<MovieFilm> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    //A view holder inner class where we get reference to the views in the layout using their ID
    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
//        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView movieImage;
        Button btnDetail;
        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieImage = (ImageView) v.findViewById(R.id.movie_image);
            movieTitle = (TextView) v.findViewById(R.id.title);
//            data = (TextView) v.findViewById(R.id.date);
            movieDescription = (TextView) v.findViewById(R.id.description);
//            rating = (TextView) v.findViewById(R.id.rating);
            btnDetail = v.findViewById(R.id.btn_detail);
        }
    }
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        String image_url = IMAGE_URL_BASE_PATH + movies.get(position).getPosterPath();
        Picasso.get()
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.movieImage);
        holder.movieTitle.setText(movies.get(position).getTitle());
//        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
//        holder.rating.setText(movies.get(position).getVoteAverage().toString());
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return movies.size();
    }


}
