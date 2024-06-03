package com.joel.data.remote.service

import com.joel.data.remote.models.GenreDTO
import com.joel.data.remote.models.MovieDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("discover/movie")
    suspend fun discoverMovies(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : MovieDTO

    @GET("movie/now_playing")
    suspend fun fetchNowPlayingMovies(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : MovieDTO

    @GET("trending/movie")
    suspend fun fetchTrendingMovies(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : MovieDTO

    @GET("movie/upcoming")
    suspend fun fetchUpcomingMovies(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : MovieDTO

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int,
        @Query("query") query : String
    ) : MovieDTO

    @GET("/genre/movie/list")
    suspend fun fetchMovieGenres(
        @Query("api_key") apiKey : String,
    ) : GenreDTO
}