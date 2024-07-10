package com.joel.data.data.mapping

import com.joel.data.data.models.IssueDataInfo
import com.joel.data.remote.models.IssuesDTO

fun IssuesDTO.Issues.toIssueDataModel() : IssueDataInfo{
    return IssueDataInfo(
        id = id ?: 0,
        image = image.original.orEmpty(),
        siteLink = siteDetailUrl.orEmpty(),
        title = name.orEmpty()
    )
}