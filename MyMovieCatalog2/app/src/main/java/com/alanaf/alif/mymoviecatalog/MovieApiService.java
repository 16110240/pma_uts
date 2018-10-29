package com.alanaf.alif.mymoviecatalog;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/now_playing")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);
}
