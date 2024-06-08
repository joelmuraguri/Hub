package com.joel.presentation

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.joel.data.di.CoreDataContainer

object ViewModelFactory {

    lateinit var coreDataContainer : CoreDataContainer

    val Factory = viewModelFactory {
        initializer {
            ConnectivityViewModel(
                networkMonitor = coreDataContainer.networkMonitor
            )
        }
    }
}