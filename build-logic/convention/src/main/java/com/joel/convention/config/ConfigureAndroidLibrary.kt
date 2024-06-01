package com.joel.convention.config

import com.android.build.api.dsl.LibraryExtension
import com.joel.convention.util.ProjectConfig
import org.gradle.api.Project

fun Project.configureAndroidLibrary(
    extension: LibraryExtension
) {
    extension.apply {
        compileSdk = ProjectConfig.compileSdk

        defaultConfig {
            minSdk = ProjectConfig.minSdk

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            consumerProguardFiles("consumer-rules.pro")
        }

        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }


    }
}