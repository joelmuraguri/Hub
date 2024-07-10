package com.joel.domain.use_case

import androidx.paging.PagingData
import com.joel.data.data.repo.ComicRepository
import com.joel.data.data.utils.Resource
import com.joel.domain.mapping.mapToComicDomainModel
import com.joel.domain.model.Comic
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FetchLatestIssuesUseCase(
    private val repository: ComicRepository
) {

    suspend operator fun invoke(): Flow<Resource<Flow<PagingData<Comic>>>> {
        return repository.fetchIssues().map { resource ->
            when (resource) {
                is Resource.Success -> {
                    Resource.Success(resource.data.map { pagingData ->
                        pagingData.mapToComicDomainModel()
                    })
                }
                is Resource.Failure -> Resource.Failure(resource.error)
                is Resource.Loading -> Resource.Loading
            }
        }
    }
}


