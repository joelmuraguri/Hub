package com.joel.domain

data class Movie(
    val id : Int,
    val title : String,
    val image : String,
    val genres : List<String>
)
