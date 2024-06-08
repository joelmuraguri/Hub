package com.joel.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.data.network.NetworkMonitor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ConnectivityViewModel(
    networkMonitor : NetworkMonitor
) : ViewModel() {


    private val _isOffline = MutableStateFlow(false)
    val isOffline: StateFlow<Boolean> = _isOffline.asStateFlow()

    init {
        viewModelScope.launch {
            networkMonitor.isOnline
                .map(Boolean::not)
                .collect {
                    _isOffline.value = it
                }
        }
    }

}