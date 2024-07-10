package com.joel.data.data.models

data class IssueDataInfo(
    val id : Int,
    val title : String,
    val image : String,
    val siteLink : String
)

data class ComicDetailsDataInfo(
    val id : Int,
    val title : String,
    val image : String,
    val producer : String,
    val url : String,
    val releaseDate : String,
    val lastDateUpdated : String,
    val description : String,
    val characters : List<Character>,
    val volume : Volume
){
    data class Volume(
        val id : Int,
        val name : String,
        val image : String
    )
    data class Character(
        val id : Int,
        val name : String,
        val image : String
    )
}
