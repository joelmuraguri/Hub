package com.joel.data.remote.service

import com.joel.data.remote.models.GenreDTO
import com.joel.data.remote.models.TvDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface TvService {

    @GET("discover/tv")
    suspend fun discoverTvs(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : TvDTO

    @GET("tv/airing_today")
    suspend fun fetchAiringTodayTvs(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : TvDTO

    @GET("trending/tv/day")
    suspend fun fetchTrendingTvs(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : TvDTO

    @GET("tv/on_the_air")
    suspend fun fetchOnTheAirTvs(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ) : TvDTO

    @GET("search/tv")
    suspend fun fetchSearchTvs(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int,
        @Query("query") query : String
    ) : TvDTO

    @GET("/genre/tv/list")
    suspend fun fetchTvGenres(
        @Query("api_key") apiKey : String,
    ) : GenreDTO

}