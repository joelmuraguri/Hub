package com.joel.data.di

import android.content.Context
import com.joel.data.network.ConnectivityNetworkMonitor
import com.joel.data.network.NetworkMonitor

interface CoreDataContainer {
    val networkMonitor : NetworkMonitor
}

class CoreAppDataContainer(
    private val context: Context
) : CoreDataContainer {

    override val networkMonitor: NetworkMonitor by lazy {
        ConnectivityNetworkMonitor(context)
    }

}