package com.joel.hub

import android.app.Application
import com.joel.data.di.CoreAppDataContainer
import com.joel.hub.di.comic.ComicDataContainer
import com.joel.hub.di.comic.ComicDefaultAppDataContainer
import com.joel.presentation.ViewModelFactory
import timber.log.Timber

class HubApp : Application() {

    lateinit var comicDataContainer : ComicDataContainer

    override fun onCreate() {
        super.onCreate()
        plantDebugBuildLogger()
        ViewModelFactory.coreDataContainer = CoreAppDataContainer(this)
        comicDataContainer = ComicDefaultAppDataContainer()
    }

    private fun plantDebugBuildLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}