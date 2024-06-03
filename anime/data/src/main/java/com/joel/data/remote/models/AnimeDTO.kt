package com.joel.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeDTO(
    @SerialName("`data`")
    val data: List<Data> = emptyList(),
    val pagination: Pagination
){
    @Serializable
    data class Data(
        val aired: Aired ?= null,
        val airing: Boolean = false,
        val approved: Boolean = false,
        val background: String ?= null,
        val broadcast: Broadcast ?= null,
        val demographics: List<Demographic> = emptyList(),
        val duration: String ?= null,
        val episodes: Int ?= null,
        @SerialName("explicit_genres")
        val explicitGenres: List<Genre> = emptyList(),  //ANY
        val favorites: Int ?= null,
        val genres: List<Genre> = emptyList(),
        val images: Images ?= null,
        val licensors: List<Licensor> = emptyList(),
        @SerialName("mal_id")
        val malId: Int ?= null,
        val members: Int ?= null,
        val popularity: Int ?= null,
        val producers: List<Producer> = emptyList(),
        val rank: Int ?= null,
        val rating: String ?= null,
        val score: Double ?= null,
        @SerialName("scored_by")
        val scoredBy: Int ?= null,
        val season: String ?= null,
        val source: String ?= null,
        val status: String ?= null,
        val studios: List<Studio> = emptyList(),
        val synopsis: String ?= null,
        val themes: List<Theme> = emptyList(),
        val title: String ?= null,
        @SerialName("title_english")
        val titleEnglish: String ?= null,
        @SerialName("title_japanese")
        val titleJapanese: String ?= null,
        @SerialName("title_synonyms")
        val titleSynonyms: List<String> = emptyList(),
        val titles: List<Title> = emptyList(),
        val trailer: Trailer ?= null,
        val type: String ?= null,
        val url: String ?= null,
        val year: Int ?= null
    ){

        @Serializable
        data class Trailer(
            @SerialName("embed_url")
            val embedUrl: String ?= null,
            val images: ImagesX ?= null,
            val url: String ?= null,
            @SerialName("youtube_id")
            val youtubeId: String ?= null
        ){


            @Serializable
            data class ImagesX(
                @SerialName("image_url")
                val image: String ?= null,
                @SerialName("large_image_url")
                val largeImage: String ?= null,
                @SerialName("maximum_image_url")
                val maximumImage: String ?= null,
                @SerialName("medium_image_url")
                val mediumImage: String ?= null,
                @SerialName("small_image_url")
                val smallImage: String ?= null
            )
        }

        @Serializable
        data class Title(
            val title: String ?= null,
            val type: String ?= null
        )

        @Serializable
        data class Theme(
            @SerialName("mal_id")
            val malId: Int ?= null,
            val name: String ?= null,
            val type: String ?= null,
            val url: String ?= null
        )

        @Serializable
        data class Studio(
            @SerialName("mal_id")
            val malId: Int ?= null,
            val name: String ?= null,
            val type: String ?= null,
            val url: String ?= null
        )

        @Serializable
        data class Producer(
            @SerialName("mal_id")
            val malId: Int ?= null,
            val name: String ?= null,
            val type: String ?= null,
            val url: String ?= null
        )

        @Serializable
        data class Licensor(
            @SerialName("mal_id")
            val malId: Int ?= null,
            val name: String ?= null,
            val type: String ?= null,
            val url: String ?= null
        )

        @Serializable
        data class Images(
            val jpg: Jpg ?= null,
            val webp: Webp ?= null
        ){

            @Serializable
            data class Jpg(
                @SerialName("image_url")
                val image: String,
                @SerialName("large_image_url")
                val largeImage: String,
                @SerialName("small_image_url")
                val smallImage: String
            )

            @Serializable
            data class Webp(
                @SerialName("image_url")
                val image: String,
                @SerialName("large_image_url")
                val largeImage: String,
                @SerialName("small_image_url")
                val smallImage: String
            )

        }

        @Serializable
        data class Genre(
            @SerialName("mal_id")
            val malId: Int ?= null,
            val name: String ?= null,
            val type: String ?= null,
            val url: String ?= null
        )

        @Serializable
        data class Demographic(
            @SerialName("mal_id")
            val malId: Int ?= null,
            val name: String ?= null,
            val type: String ?= null,
            val url: String ?= null
        )

        @Serializable
        data class Broadcast(
            val day: String ?= null,
            val string: String ?= null,
            val time: String ?= null,
            val timezone: String ?= null
        )

        @Serializable
        data class Aired(
            val from: String ?= null,
            val prop: Prop ?= null,
            val string: String ?= null,
            val to: String ?= null
        ){

            @Serializable
            data class Prop(
                val from: From ?= null,
                val to: To ?= null
            ){

                @Serializable
                data class From(
                    val day: Int ?= null,
                    val month: Int ?= null,
                    val year: Int ?= null
                )

                @Serializable
                data class To(
                    val day: Int ?= null,
                    val month: Int ?= null,
                    val year: Int ?= null
                )
            }
        }
    }

    @Serializable
    data class Pagination(
        @SerialName("current_page")
        val currentPage: Int,
        @SerialName("has_next_page")
        val hasNextPage: Boolean,
        val items: Items,
        @SerialName("last_visible_page")
        val lastVisiblePage: Int
    ){
        @Serializable
        data class Items(
            val count: Int,
            @SerialName("per_page")
            val perPage: Int,
            val total: Int
        )
    }
}