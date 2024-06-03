package com.joel.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDTO(
    val dates: Dates ?= null,
    val page: Int,
    val results: List<Movie>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
){

    @Serializable
    data class Dates(
        val maximum: String ?= null,
        val minimum: String ?= null
    )

    @Serializable
    data class Movie(
        val adult: Boolean = false,
        @SerialName("backdrop_path")
        val backdropPath: String ?= null,
        @SerialName("genre_ids")
        val genreIds: List<Int> = emptyList(),
        val id: Int ?= null,
        @SerialName("original_language")
        val originalLanguage: String ?= null,
        @SerialName("original_title")
        val originalTitle: String ?= null,
        val overview: String ?= null,
        @SerialName("media_type")
        val mediaType: String ?= null,
        val popularity: Double ?= null,
        @SerialName("poster_path")
        val posterPath: String ?= null,
        @SerialName("release_date")
        val releaseDate: String,
        val title: String,
        val video: Boolean = false,
        @SerialName("vote_average")
        val voteAverage: Double ?= null,
        @SerialName("vote_count")
        val voteCount: Int ?= null
    )

}