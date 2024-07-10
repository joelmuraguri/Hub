package com.joel.data.remote

import com.joel.data.remote.models.CharacterInfoDTO
import com.joel.data.remote.models.IssueInfoDTO
import com.joel.data.remote.models.IssuesDTO
import com.joel.data.remote.models.VolumeDTO
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("issue/{id}")
    suspend fun fetchIssuesInfo(
        @Path("id") issueId : String,
        @Query("api_key") apiKey : String,
        @Query("format") format: String = "json",
    ) : IssueInfoDTO

    @GET("character/{id}/")
    suspend fun fetchCharactersInfo(
        @Path("id") characterId : String,
        @Query("api_key") apiKey : String,
        @Query("format") format: String = "json",
    ) : CharacterInfoDTO

    @GET("volume/{id}/")
    suspend fun fetchVolumeInfo(
        @Path("id") characterId : String,
        @Query("api_key") apiKey : String,
        @Query("format") format: String = "json",
    ) : VolumeDTO

}