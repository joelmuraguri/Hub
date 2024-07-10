package com.joel.presentation

import androidx.paging.PagingData
import com.joel.domain.model.Comic
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class ComicScreenState(
    val allNewComics : Flow<PagingData<Comic>> = emptyFlow(),
    val isLoading : Boolean = false,
    val error : String = ""
)
