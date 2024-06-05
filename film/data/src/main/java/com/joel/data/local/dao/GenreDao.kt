package com.joel.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.joel.data.local.entity.GenreEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GenreDao {

    @Query("SELECT * FROM GENRE_TABLE")
    fun fetchGenres() : Flow<List<GenreEntity>>

    @Upsert
    suspend fun updateGenresSaved(genres : List<GenreEntity>)

}