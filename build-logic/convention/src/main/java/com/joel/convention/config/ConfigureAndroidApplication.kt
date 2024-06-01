package com.joel.convention.config

import com.android.build.api.dsl.ApplicationExtension
import com.joel.convention.util.ProjectConfig
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.provideDelegate

fun Project.configureAndroidApplication(
    extension: ApplicationExtension
) {
    extension.apply {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
        val appVersionCode: String by project
        val appVersionName: String by project

        compileSdk = ProjectConfig.compileSdk

        defaultConfig {
            applicationId = "com.joel.hub"

            targetSdk = ProjectConfig.targetSdk
            minSdk = ProjectConfig.minSdk
            versionCode = 1
            versionName = "1.0"

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables {
                useSupportLibrary = true
            }
        }

        buildFeatures {
            buildConfig = true
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

        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }

        dependencies {
            "implementation"(libs.findLibrary("activity-compose").get())
            "implementation"(libs.findLibrary("timber").get())
            "implementation"(libs.findLibrary("hilt").get())
            "ksp"(libs.findLibrary("hilt-compiler").get())
        }
    }
}