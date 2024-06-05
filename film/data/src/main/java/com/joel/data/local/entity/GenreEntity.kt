package com.joel.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("genre_table")
data class GenreEntity(
    @PrimaryKey(autoGenerate = false) val id : Int,
    val name : String
)
