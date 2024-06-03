package com.joel.data.remote.source

import com.joel.data.remote.NewsService
import com.joel.data.remote.models.NewsDTO
import javax.inject.Inject

class DefaultNewsRemoteSource @Inject constructor(
    private val apiKey: String,
    private val service: NewsService
) : NewsRemoteSource {


    override suspend fun fetchLatestNews(
        apiKey: String,
        category: String,
        country: String
    ): NewsDTO {
        return service.fetchLatestNews(apiKey, category, country)
    }

    override suspend fun fetchNewsArchive(
        apiKey: String,
        category: String,
        country: String
    ): NewsDTO {
        return service.fetchNewsArchive(apiKey, category, country)
    }

    override suspend fun fetchCryptoNews(
        apiKey: String,
        category: String,
        country: String
    ): NewsDTO {
        return service.fetchCryptoNews(apiKey, category, country)
    }
}