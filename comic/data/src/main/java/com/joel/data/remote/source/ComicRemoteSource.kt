package com.joel.data.remote.source

import com.joel.data.remote.models.IssuesDTO

interface ComicRemoteSource {

    suspend fun fetchIssues(offset : Int, limit :Int) : IssuesDTO
}