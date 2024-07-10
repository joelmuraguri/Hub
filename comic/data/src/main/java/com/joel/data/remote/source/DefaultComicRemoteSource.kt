package com.joel.data.remote.source

import com.joel.data.remote.ComicService
import com.joel.data.remote.models.CharacterInfoDTO
import com.joel.data.remote.models.IssueInfoDTO
import com.joel.data.remote.models.IssuesDTO
import com.joel.data.remote.models.VolumeDTO
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
        return response
    }
    override suspend fun fetchCharacterInfo(characterId: Int): CharacterInfoDTO {
        return service.fetchCharactersInfo("4005 -$characterId", apiKey)
    }
    override suspend fun fetchIssuesInfo(issueId: Int): IssueInfoDTO {
        return service.fetchIssuesInfo("4000-$issueId", apiKey)
    }
    override suspend fun fetchVolumeInfo(volumeId: Int): VolumeDTO {
        return service.fetchVolumeInfo("4050-$volumeId", apiKey)
    }

    private suspend fun fetchVolumeImage(volumeId : Int){

    }
    private suspend fun fetchCharactersImage(volumeId : Int){

    }
}