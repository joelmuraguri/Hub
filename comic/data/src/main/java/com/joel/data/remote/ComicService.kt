package com.joel.data.remote

import com.joel.data.remote.models.IssuesDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicService {
    @GET("issues")
    suspend fun fetchIssues(
        @Query("api_key") apiKey : String,
        @Query("format") format: String = "json",
        @Query("sort") sort : String = "date_last_updated:desc",
        @Query("offset") offset : Int,
        @Query("limit") limit : Int
    ) : IssuesDTO
}