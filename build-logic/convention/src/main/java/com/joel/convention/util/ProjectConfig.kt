package com.joel.convention.util

import org.gradle.api.JavaVersion


object ProjectConfig {
    const val compileSdk = 34
    const val targetSdk = 34
    const val minSdk = 26
    val sourceCompatibility = JavaVersion.VERSION_17
    val targetCompatibility = JavaVersion.VERSION_17
    const val jvmTarget = "17"
    const val kotlinCompilerExtensionVersion = "1.5.3"
}