package com.joel.domain

data class News(
    val id : Int,
    val title : String,
    val image : String,
    val genres : List<String>,
    val url : String
)
