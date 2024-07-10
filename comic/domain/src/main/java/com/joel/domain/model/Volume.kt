package com.joel.domain.model

data class Volume(
    val id : String,
    val name : String,
    val url : String,
    val totalIssues : Int,
    val releaseDate : String,
    val lastDateUpdated : String,
    val issues : List<Issues>,
    val firstIssue : FirstIssue,
    val lastIssue : LastIssue,
    val description : String,
){
    data class Issues(
        val id : Int,
        val name : String,
        val issueNumber : String
    )

    data class FirstIssue(
        val id : Int,
        val name : String,
        val issueNumber : String
    )

    data class LastIssue(
        val id : Int,
        val name : String,
        val issueNumber : String
    )
}
