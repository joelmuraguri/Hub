package com.joel.domain.model

enum class FilterAnime(
    val filter : String
) {
    AIRING(
        filter = "airing"
    ),
    UPCOMING(
        filter = "upcoming"
    ),
    POPULARITY(
        filter = "bypopularity"
    ),
    FAVOURITE(
        filter = "favorite"
    )
}