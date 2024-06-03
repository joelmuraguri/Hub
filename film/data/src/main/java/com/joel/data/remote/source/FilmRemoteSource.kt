package com.joel.data.remote.source

import com.joel.data.remote.models.GenreDTO
import com.joel.data.remote.models.MovieDTO
import com.joel.data.remote.models.TvDTO

interface FilmRemoteSource {

    suspend fun discoverMovies(
         apiKey : String, page : Int
    ) : MovieDTO

    suspend fun fetchNowPlayingMovies(
        apiKey : String, page : Int
    ) : MovieDTO

    suspend fun fetchTrendingMovies(
        apiKey : String, page : Int
    ) : MovieDTO

    suspend fun fetchUpcomingMovies(
        apiKey : String, page : Int
    ) : MovieDTO

    suspend fun searchMovies(
        apiKey : String, page : Int,query : String
    ) : MovieDTO

    suspend fun fetchMovieGenres(
        apiKey : String
    ) : GenreDTO

    suspend fun discoverTvs(
        apiKey : String, page : Int
    ) : TvDTO

    suspend fun fetchAiringTodayTvs(
        apiKey : String, page : Int
    ) : TvDTO

    suspend fun fetchTrendingTvs(
        apiKey : String, page : Int
    ) : TvDTO

    suspend fun fetchOnTheAirTvs(
        apiKey : String, page : Int
    ) : TvDTO

    suspend fun fetchSearchTvs(
        apiKey : String, page : Int, query : String
    ) : TvDTO

    suspend fun fetchTvGenres(
        apiKey : String
    ) : GenreDTO
}