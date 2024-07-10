package com.joel.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeDTO(
    val error: String,
    val limit: Int,
    @SerialName("number_of_page_results")
    val pageResults: Int,
    @SerialName("number_of_total_results")
    val totalResults: Int,
    val offset: Int,
    val results: List<Volume> = emptyList(),
    @SerialName("status_code")
    val statusCode: Int,
    val version: String
) {

    @Serializable
    data class Volume(
        val aliases: String ?= null,
        @SerialName("api_detail_url")
        val apiDetailUrl: String ?= null,
        val characters: List<Character> = emptyList(),
        val concepts: List<Concept> = emptyList(),
        @SerialName("count_of_issues")
        val countOfIssues: Int ?= null,
        @SerialName("date_added")
        val dateAdded: String ?= null,
        @SerialName("date_last_updated")
        val dateLastUpdated: String ?= null,
        val deck: String ?= null,
        val description: String ?= null,
        @SerialName("first_issue")
        val firstIssue: FirstIssue ?= null,
        val id: Int ?= null,
        val image: Image ?= null,
        val issues: List<Issue> = emptyList(),
        @SerialName("last_issue")
        val lastIssue: LastIssue ?= null,
        val locations: List<Location> = emptyList(),
        val name: String ?= null,
        val objects: List<Object> = emptyList(),
        val people: List<People> = emptyList(),
        val publisher: Publisher,
        @SerialName("site_detail_url")
        val siteDetailUrl: String ?= null,
        @SerialName("start_year")
        val startYear: String ?= null
    ) {

        @Serializable
        data class Object(
            @SerialName("api_detail_url")
            val apiDetailUrl: String ?= null,
            val count: String ?= null,
            val id: Int ?= null,
            val name: String ?= null,
            @SerialName("site_detail_url")
            val siteDetailUrl: String ?= null
        )

        @Serializable
        data class Character(
            @SerialName("api_detail_url")
            val apiDetailUrl: String ?= null,
            val count: String ?= null,
            val id: Int ?= null,
            val name: String ?= null,
            @SerialName("site_detail_url")
            val siteDetailUrl: String ?= null
        )

        @Serializable
        data class Concept(
            @SerialName("api_detail_url")
            val apiDetailUrl: String ?= null,
            val count: String ?= null,
            val id: Int ?= null,
            val name: String ?= null,
            @SerialName("site_detail_url")
            val siteDetailUrl: String ?= null
        )

        @Serializable
        data class FirstIssue(
            @SerialName("api_detail_url")
            val apiDetailUrl: String ?= null,
            val id: Int ?= null,
            @SerialName("issue_number")
            val issueNumber: String ?=null,
            val name: String ?= null
        )

        @Serializable
        data class LastIssue(
            @SerialName("api_detail_url")
            val apiDetailUrl: String ?= null,
            val id: Int ?= null,
            @SerialName("issue_number")
            val issueNumber: String ?=null,
            val name: String ?= null
        )

        @Serializable
        data class Image(
            @SerialName("icon_url")
            val icon: String? = null,
            @SerialName("image_tags")
            val imageTags: String ?= null,
            @SerialName("medium_url")
            val medium: String ?= null,
            @SerialName("original_url")
            val original: String ?= null,
            @SerialName("screen_large_url")
            val screenLarge: String ?= null,
            @SerialName("screen_url")
            val screen: String ?= null,
            @SerialName("small_url")
            val small: String ?= null,
            @SerialName("super_url")
            val superUrl: String ?= null,
            @SerialName("thumb_url")
            val thumb: String ?= null,
            @SerialName("tiny_url")
            val tiny: String ?= null
        )

        @Serializable
        data class Publisher(
            @SerialName("api_detail_url")
            val apiDetailUrl: String ?= null,
            val id: Int ?= null,
            val name: String ?= null
        )

        @Serializable
        data class Location(
            @SerialName("api_detail_url")
            val apiDetailUrl: String ?= null,
            val count: String ?= null,
            val id: Int ?= null,
            val name: String ?= null,
            @SerialName("site_detail_url")
            val siteDetailUrl: String ?= null
        )

        @Serializable
        data class Issue(
            @SerialName("api_detail_url")
            val apiDetailUrl: String ?= null,
            val id: Int ?= null,
            @SerialName("issue_number")
            val issueNumber: String ?= null,
            val name: String ?= null,
            @SerialName("site_detail_url")
            val siteDetailUrl: String
        )

        @Serializable
        data class People(
            @SerialName("api_detail_url")
            val apiDetailUrl: String ?= null,
            val id: Int ?= null,
            @SerialName("issue_number")
            val issueNumber: String ?= null,
            val name: String ?= null,
            @SerialName("site_detail_url")
            val siteDetailUrl: String
        )
    }
}