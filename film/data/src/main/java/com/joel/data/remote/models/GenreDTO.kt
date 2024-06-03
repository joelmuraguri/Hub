package com.joel.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class GenreDTO(
    val genres: List<Genre>
){

    @Serializable
    data class Genre(
        val id: Int,
        val name: String
    )
}