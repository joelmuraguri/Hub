package com.joel.domain.model

data class Anime(
    val id : Int,
    val title : String,
    val image : String,
    val genres : List<String>
)
