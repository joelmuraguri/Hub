package com.joel.data.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.joel.data.data.models.CharacterDataInfo
import com.joel.data.data.models.ComicDetailsDataInfo
import com.joel.data.data.models.IssueDataInfo
import com.joel.data.data.models.VolumeDataInfo
import com.joel.data.data.paging.IssuesPagingSource
import com.joel.data.data.utils.CustomApiException
import com.joel.data.data.utils.Resource
import com.joel.data.remote.source.ComicRemoteSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

class DefaultComicRepository(
    private val remoteSource: ComicRemoteSource
) : ComicRepository {

    override suspend fun fetchIssues(): Flow<Resource<Flow<PagingData<IssueDataInfo>>>> {
        return flow {
            try {
                emit(Resource.Loading)
                val pagingDataFlow = Pager(
                    config = PagingConfig(enablePlaceholders = false, pageSize = 20),
                    pagingSourceFactory = { IssuesPagingSource(comicRemoteSource = remoteSource) }
                ).flow
                emit(Resource.Success(pagingDataFlow))
                Timber.d("ISSUES-PAGER", pagingDataFlow)
            } catch (e: CustomApiException) {
                emit(Resource.Failure(e))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

    override suspend fun fetchCharacterInfo(characterId: Int): Flow<Resource<CharacterDataInfo>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchIssuesInfo(issueId: Int): Flow<Resource<ComicDetailsDataInfo>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchVolumeInfo(issueId: Int): Flow<Resource<VolumeDataInfo>> {
        TODO("Not yet implemented")
    }
}