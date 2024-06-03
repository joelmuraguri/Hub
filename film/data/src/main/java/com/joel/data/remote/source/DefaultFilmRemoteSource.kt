package com.joel.data.remote.source

import com.joel.data.remote.models.GenreDTO
import com.joel.data.remote.models.MovieDTO
import com.joel.data.remote.models.TvDTO
import com.joel.data.remote.service.MovieService
import com.joel.data.remote.service.TvService

class DefaultFilmRemoteSource(
    private val apiKey: String,
    private val tvService: TvService,
    private val movieService: MovieService
) : FilmRemoteSource {

    override suspend fun discoverMovies(apiKey: String, page: Int): MovieDTO {
        return movieService.discoverMovies(apiKey, page)
    }

    override suspend fun fetchNowPlayingMovies(apiKey: String, page: Int): MovieDTO {
        return movieService.fetchNowPlayingMovies(apiKey, page)
    }

    override suspend fun fetchTrendingMovies(apiKey: String, page: Int): MovieDTO {
        return movieService.fetchTrendingMovies(apiKey, page)
    }

    override suspend fun fetchUpcomingMovies(apiKey: String, page: Int): MovieDTO {
        return movieService.fetchUpcomingMovies(apiKey, page)
    }

    override suspend fun searchMovies(apiKey: String, page: Int, query: String): MovieDTO {
        return movieService.searchMovies(apiKey, page, query)
    }

    override suspend fun fetchMovieGenres(apiKey: String): GenreDTO {
        return movieService.fetchMovieGenres(apiKey)
    }

    override suspend fun discoverTvs(apiKey: String, page: Int): TvDTO {
        return tvService.discoverTvs(apiKey, page)
    }

    override suspend fun fetchAiringTodayTvs(apiKey: String, page: Int): TvDTO {
        return tvService.fetchAiringTodayTvs(apiKey, page)
    }

    override suspend fun fetchTrendingTvs(apiKey: String, page: Int): TvDTO {
        return tvService.fetchTrendingTvs(apiKey, page)
    }

    override suspend fun fetchOnTheAirTvs(apiKey: String, page: Int): TvDTO {
        return tvService.fetchOnTheAirTvs(apiKey, page)
    }

    override suspend fun fetchSearchTvs(apiKey: String, page: Int, query: String): TvDTO {
        return tvService.fetchSearchTvs(apiKey, page, query)
    }

    override suspend fun fetchTvGenres(apiKey: String): GenreDTO {
        return tvService.fetchTvGenres(apiKey)
    }
}