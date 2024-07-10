package com.joel.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.data.data.utils.Resource
import com.joel.domain.use_case.ComicUseCases
import com.joel.presentation.nav.COMIC_ROUTE
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ComicViewModel(
    private val comicUseCases: ComicUseCases
) : ViewModel() {


    private val _state = mutableStateOf(ComicScreenState())
    val state: State<ComicScreenState> = _state

    private val _uiEvents = Channel<ComicUIEvents>()
    val uiEvents = _uiEvents.receiveAsFlow()


    init {
        fetchNewComics()
    }

    fun onEvents(events: ComicEvents){
        when(events){
            is ComicEvents.OnCharacterClick -> TODO()
            is ComicEvents.OnComicClick -> {
                viewModelScope.launch {
                    _uiEvents.send(ComicUIEvents.Navigate(COMIC_ROUTE + "?characterId=${events.comic.id}"))
                }
            }
            is ComicEvents.OnVolumeClick -> TODO()
        }
    }

    fun fetchNewComics(){
        viewModelScope.launch {
            comicUseCases.fetchLatestIssuesUseCase.invoke().collect{ resource ->
                when(resource){
                    is Resource.Failure -> {
                        _state.value = _state.value.copy(
                            error = resource.error.message ?: "An error occurred",
                            isLoading = false
                        )
                    }
                    Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true, error = "")
                    }
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            allNewComics = resource.data,
                            isLoading = false,
                            error = ""
                        )
                    }
                }
            }
        }
    }
}