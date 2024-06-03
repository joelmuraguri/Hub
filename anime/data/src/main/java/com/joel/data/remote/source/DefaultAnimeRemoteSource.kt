package com.joel.data.remote.source

import com.joel.data.remote.AnimeService
import com.joel.data.remote.models.AnimeDTO
import timber.log.Timber
import javax.inject.Inject

class DefaultAnimeRemoteSource @Inject constructor(
    private val service: AnimeService
) : AnimeRemoteSource {

    override suspend fun fetchTopAnime(
        filter: String,
        type: String,
        rating: String,
        page: Int,
        limit: Int
    ): AnimeDTO {
        val response =  service.fetchAnime(
            filter = filter,
            type = type,
            rating = rating,
            page = page,
            limit = limit
        )
        Timber.d("ANIME", response)
        return response
    }
}