package com.joel.hub.di.comic

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.joel.data.data.repo.ComicRepository
import com.joel.data.data.repo.DefaultComicRepository
import com.joel.data.remote.ComicService
import com.joel.data.remote.source.ComicRemoteSource
import com.joel.data.remote.source.DefaultComicRemoteSource
import com.joel.domain.use_case.ComicUseCases
import com.joel.domain.use_case.FetchLatestIssuesUseCase
import com.joel.hub.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

interface ComicDataContainer {
    val comicRemoteSource : ComicRemoteSource
    val comicRepository : ComicRepository
    val comicUseCases : ComicUseCases
}

class ComicDefaultAppDataContainer : ComicDataContainer{

    private val comicVineBaseUrl = "https://comicvine.gamespot.com/api/"

    private val json = Json { ignoreUnknownKeys = true }

    private val client : OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10L, TimeUnit.SECONDS)
        .writeTimeout(10L, TimeUnit.SECONDS)
        .readTimeout(30L, TimeUnit.SECONDS)
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(provideUserAgentInterceptor())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .client(client)
        .baseUrl(comicVineBaseUrl)
        .build()

    private val retrofitService: ComicService by lazy {
        retrofit.create(ComicService::class.java)
    }

    override val comicRemoteSource: ComicRemoteSource by lazy {
        DefaultComicRemoteSource(
            service = retrofitService,
            apiKey = BuildConfig.COMIC_VINE_API_KEY
        )
    }
    override val comicRepository: ComicRepository by lazy {
        DefaultComicRepository(comicRemoteSource)
    }
    override val comicUseCases: ComicUseCases by lazy {
        ComicUseCases(
            fetchLatestIssuesUseCase = FetchLatestIssuesUseCase(comicRepository)
        )
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else HttpLoggingInterceptor.Level.NONE
        return HttpLoggingInterceptor().also {
            it.level = level
        }
    }

    private fun provideUserAgentInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val requestWithUserAgent = originalRequest.newBuilder()
                .header("User-Agent", "mobile")
                .build()
            chain.proceed(requestWithUserAgent)
        }
    }
}