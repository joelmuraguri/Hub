package com.joel.convention.config

import com.android.build.api.dsl.CommonExtension
import com.joel.convention.util.ProjectConfig
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureDataLibrary(
    extension: CommonExtension<*, *, *, *, *, *>
) {
    extension.apply {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
        compileSdk = ProjectConfig.compileSdk

        defaultConfig {
            minSdk = ProjectConfig.minSdk
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        dependencies {
            "implementation"(libs.findLibrary("timber").get())
            "implementation"(libs.findLibrary("hilt").get())
            "implementation"(libs.findLibrary("room-ktx").get())
            "implementation"(libs.findLibrary("room-runtime").get())
            "ksp"(libs.findLibrary("hilt-compiler").get())
            "ksp"(libs.findLibrary("room-compiler").get())
            "implementation"(libs.findLibrary("kotlin-coroutines").get())
            "implementation"(libs.findLibrary("retrofit-core").get())
            "implementation"(libs.findLibrary("retrofit-kotlin-serialization").get())
            "implementation"(libs.findLibrary("kotlinx-serialization-json").get())
            "implementation"(libs.findLibrary("okhttp-logging").get())
            "implementation"(libs.findLibrary("androidx-paging-compose").get())
            "implementation"(libs.findLibrary("androidx-paging-runtime").get())
            "testImplementation"(libs.findLibrary("kotlin-coroutines-test").get())
        }
    }
}