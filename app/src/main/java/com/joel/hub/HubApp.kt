package com.joel.hub

import android.app.Application
import com.joel.data.di.CoreAppDataContainer
import com.joel.presentation.ViewModelFactory
import timber.log.Timber

class HubApp : Application() {

    override fun onCreate() {
        super.onCreate()
        plantDebugBuildLogger()
        ViewModelFactory.coreDataContainer = CoreAppDataContainer(this)
    }

    private fun plantDebugBuildLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}