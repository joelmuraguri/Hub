package com.joel.data.remote.source

import com.joel.data.remote.models.CharacterInfoDTO
import com.joel.data.remote.models.IssueInfoDTO
import com.joel.data.remote.models.IssuesDTO
import com.joel.data.remote.models.VolumeDTO

interface ComicRemoteSource {

    suspend fun fetchIssues(offset : Int, limit :Int) : IssuesDTO
    suspend fun fetchCharacterInfo(characterId: Int) : CharacterInfoDTO
    suspend fun fetchIssuesInfo(issueId: Int) : IssueInfoDTO
    suspend fun fetchVolumeInfo(volumeId: Int) : VolumeDTO

}