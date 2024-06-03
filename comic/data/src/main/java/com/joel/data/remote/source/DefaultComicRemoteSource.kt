package com.joel.data.remote.source

import com.joel.data.remote.ComicService
import com.joel.data.remote.models.IssuesDTO
import timber.log.Timber
import javax.inject.Inject

class DefaultComicRemoteSource @Inject constructor(
    private val service: ComicService,
    private val apiKey : String
) : ComicRemoteSource {

    override suspend fun fetchIssues(offset: Int, limit: Int): IssuesDTO {
        val response =  service.fetchIssues(
            apiKey = apiKey, offset = offset, limit = limit
        )
        Timber.d("ISSUES", response)
        return response
    }
}