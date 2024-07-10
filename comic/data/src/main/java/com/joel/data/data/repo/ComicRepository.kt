package com.joel.data.data.repo

import androidx.paging.PagingData
import com.joel.data.data.models.CharacterDataInfo
import com.joel.data.data.models.ComicDetailsDataInfo
import com.joel.data.data.models.IssueDataInfo
import com.joel.data.data.models.VolumeDataInfo
import com.joel.data.data.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ComicRepository {
    suspend fun fetchIssues() : Flow<Resource<Flow<PagingData<IssueDataInfo>>>>
    suspend fun fetchCharacterInfo(characterId: Int) : Flow<Resource<CharacterDataInfo>>
    suspend fun fetchIssuesInfo(issueId: Int) : Flow<Resource<ComicDetailsDataInfo>>
    suspend fun fetchVolumeInfo(issueId: Int) : Flow<Resource<VolumeDataInfo>>
}