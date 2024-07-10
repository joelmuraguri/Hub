package com.joel.convention.config

import com.android.build.api.dsl.CommonExtension
import com.joel.convention.util.ProjectConfig
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureAndroidCompose(
    extension: CommonExtension<*, *, *, *, *, *>
) {
    extension.apply {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        defaultConfig {
            vectorDrawables {
                useSupportLibrary = true
            }
        }

        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = ProjectConfig.kotlinCompilerExtensionVersion
        }

        dependencies {
            val composeBom = libs.findLibrary("compose-bom").get()
            "implementation"(platform(composeBom))
            "implementation"(libs.findLibrary("ui").get())
            "implementation"(libs.findLibrary("ui-graphics").get())
            "implementation"(libs.findLibrary("ui-tooling-preview").get())
            "implementation"(libs.findLibrary("material3").get())
            "implementation"(libs.findLibrary("androidx-core-ktx").get())
            "implementation"(libs.findLibrary("androidx-paging-compose").get())
            "implementation"(libs.findLibrary("androidx-paging-runtime").get())
            "implementation"(libs.findLibrary("landscapist-coil").get())
            "implementation"(libs.findLibrary("lifecycle-runtime-ktx").get())
            "implementation"(libs.findLibrary("lifecycle-viewmodel-compose").get())
            "implementation"(libs.findLibrary("hilt-navigation-compose").get())
            "androidTestImplementation"(libs.findLibrary("androidx-junit").get())
            "androidTestImplementation"(libs.findLibrary("androidx-espresso-core").get())
            "androidTestImplementation"(platform(composeBom))
            "androidTestImplementation"(libs.findLibrary("ui-test-junit4").get())
            "debugImplementation"(libs.findLibrary("ui-tooling").get())
            "debugImplementation"(libs.findLibrary("ui-test-manifest").get())
        }
    }
}