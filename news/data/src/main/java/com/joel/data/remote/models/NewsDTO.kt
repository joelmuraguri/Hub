package com.joel.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsDTO(
    val nextPage: String,
    val results: List<Result>,
    val status: String,
    val totalResults: Int
){

    @Serializable
    data class Result(
        @SerialName("ai_org")
        val aiOrg: String ?= null,
        @SerialName("ai_region")
        val aiRegion: String ?= null,
        @SerialName("ai_tag")
        val aiTag: String ?= null,
        @SerialName("article_id")
        val articleId: String ?= null,
        val category: List<String> = emptyList(),
        val content: String ?= null,
        val country: List<String> = emptyList(),
        val creator: String ?= null,  //ANY
        val description: String ?= null,
        @SerialName("image_url")
        val imageUrl: String ?= null,
        val keywords: List<String> = emptyList(),
        val language: String ?= null,
        val link: String ?= null,
        val pubDate: String ?= null,
        val sentiment: String ?= null,
        @SerialName("sentiment_stats")
        val sentimentStats: String ?= null,
        @SerialName("source_icon")
        val sourceIcon: String ?= null,
        @SerialName("source_id")
        val sourceId: String ?= null,
        @SerialName("source_priority")
        val sourcePriority: Int ?= null,
        @SerialName("source_url")
        val sourceUrl: String ?= null,
        val title: String ?= null,
        @SerialName("video_url")
        val videoUrl: String ?= null //ANY
    )
}