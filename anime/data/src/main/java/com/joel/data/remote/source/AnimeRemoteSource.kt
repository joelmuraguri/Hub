package com.joel.data.remote.source

import com.joel.data.remote.models.AnimeDTO

interface AnimeRemoteSource {

    suspend fun fetchTopAnime(
        filter : String,
        type : String,
        rating : String,
        page : Int,
        limit : Int
    ) : AnimeDTO

}