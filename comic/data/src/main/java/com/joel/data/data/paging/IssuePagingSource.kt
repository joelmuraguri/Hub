package com.joel.data.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.joel.data.data.mapping.toIssueDataModel
import com.joel.data.data.models.IssueDataInfo
import com.joel.data.data.utils.CustomApiException
import com.joel.data.data.utils.mapErrorCodeToException
import com.joel.data.remote.source.ComicRemoteSource
import retrofit2.HttpException
import java.io.IOException

class IssuesPagingSource(
    private val comicRemoteSource: ComicRemoteSource
) : PagingSource<Int, IssueDataInfo>() {

    override fun getRefreshKey(state: PagingState<Int, IssueDataInfo>): Int? {
        return state.anchorPosition?.let { anchor ->
            val closestPage = state.closestPageToPosition(anchor)
            closestPage?.prevKey?.plus(1) ?: closestPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, IssueDataInfo> {
        val page = params.key ?: 0 // If no key is provided, default to page 0
        val offset = page * 20 // Offset increments by 100 with each page

        return try {
            val response = comicRemoteSource.fetchIssues(offset = offset, limit = 20)

            if (response.statusCode != 1) {
                throw mapErrorCodeToException(response.statusCode)
            }

            val mappedData = response.results.map { it.toIssueDataModel() }

            // Set prevKey and nextKey
            val prevKey = if (page == 0) null else page - 1
            val nextKey = if (mappedData.isEmpty() || response.totalResults <= offset + 20) null else page + 1

            LoadResult.Page(
                data = mappedData,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e : CustomApiException){
            LoadResult.Error(e)
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}