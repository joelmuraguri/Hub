package com.joel.convention.config

import com.android.build.api.dsl.LibraryExtension
import com.joel.convention.util.ProjectConfig
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureDataLibrary(
    extension: LibraryExtension
) {
    extension.apply {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
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

        dependencies {
            "implementation"(libs.findLibrary("timber").get())
            "implementation"(libs.findLibrary("hilt").get())
            "ksp"(libs.findLibrary("hilt-compiler").get())
            "implementation"(libs.findLibrary("kotlin-coroutines").get())
            "implementation"(libs.findLibrary("retrofit-core").get())
            "implementation"(libs.findLibrary("retrofit-kotlin-serialization").get())
            "implementation"(libs.findLibrary("kotlinx-serialization-json").get())
            "implementation"(libs.findLibrary("okhttp-logging").get())
            "testImplementation"(libs.findLibrary("kotlin-coroutines-test").get())

        }

    }
}