package com.joel.data.remote

import com.joel.data.remote.models.NewsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("latest")
    suspend fun fetchLatestNews(
        @Query("apikey") apiKey : String,
        @Query("category") category : String,
        @Query("country") country : String
    ) : NewsDTO

    @GET("archive")
    suspend fun fetchNewsArchive(
        @Query("apikey") apiKey : String,
        @Query("category") category : String,
        @Query("country") country : String
    ) : NewsDTO

    @GET("crypto")
    suspend fun fetchCryptoNews(
        @Query("apikey") apiKey : String,
        @Query("category") category : String,
        @Query("country") country : String
    ) : NewsDTO

}