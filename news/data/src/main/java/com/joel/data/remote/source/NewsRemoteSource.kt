package com.joel.data.remote.source

import com.joel.data.remote.models.NewsDTO

interface NewsRemoteSource {


    suspend fun fetchLatestNews(
         apiKey : String,
         category : String,
        country : String
    ) : NewsDTO

    suspend fun fetchNewsArchive(
         apiKey : String,
         category : String,
        country : String
    ) : NewsDTO

    suspend fun fetchCryptoNews(
         apiKey : String,
         category : String,
        country : String
    ) : NewsDTO


}