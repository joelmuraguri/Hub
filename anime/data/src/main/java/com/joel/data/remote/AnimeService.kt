package com.joel.data.remote

import com.joel.data.remote.models.AnimeDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeService {

    @GET("top/anime")
    suspend fun fetchAnime(
        @Query("page") page : Int,
        @Query("limit") limit : Int,
        @Query("page") filter : String,
        @Query("type") type : String,
        @Query("rating") rating : String
    ) : AnimeDTO
}