package com.joel.domain.mapping

import androidx.paging.PagingData
import androidx.paging.map
import com.joel.data.data.models.IssueDataInfo
import com.joel.domain.model.Comic

fun IssueDataInfo.toComicDomainModel() : Comic{
    return Comic(
        id = id,
        image = image,
        title = title,
        url = siteLink,
    )
}

fun PagingData<IssueDataInfo>.mapToComicDomainModel(): PagingData<Comic> {
    return this.map { issueDataInfo -> issueDataInfo.toComicDomainModel() }
}
