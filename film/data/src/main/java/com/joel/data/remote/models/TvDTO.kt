package com.joel.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvDTO(
    val page: Int,
    val results: List<Tv>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
){

    @Serializable
    data class Tv(
        val adult: Boolean = false,
        @SerialName("backdrop_path")
        val backdropPath: String ?= null,
        @SerialName("first_air_date")
        val firstAirDate: String ?= null,
        @SerialName("genre_ids")
        val genreIds: List<Int> = emptyList(),
        val id: Int ?= null,
        @SerialName("media_type")
        val mediaType: String ?= null,
        val name: String ?= null,
        @SerialName("origin_country")
        val originCountry: List<String> = emptyList(),
        @SerialName("original_language")
        val originalLanguage: String ?= null,
        @SerialName("original_name")
        val originalName: String ?= null,
        val overview: String ?= null,
        val popularity: Double ?= null,
        @SerialName("poster_path")
        val posterPath: String ?= null,
        @SerialName("vote_average")
        val voteAverage: Double ?= null,
        @SerialName("vote_count")
        val voteCount: Int ?= null
    )
}