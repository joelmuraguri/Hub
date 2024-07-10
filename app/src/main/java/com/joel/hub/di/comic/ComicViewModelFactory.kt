package com.joel.hub.di.comic

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.joel.hub.HubApp
import com.joel.presentation.ComicViewModel

object ComicViewModelFactory {
    val Factory = viewModelFactory {
        initializer {
            ComicViewModel(
                comicUseCases = comiclyApplication().comicDataContainer.comicUseCases
            )
        }
    }
}

fun CreationExtras.comiclyApplication() : HubApp = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as HubApp)