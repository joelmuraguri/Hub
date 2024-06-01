package com.joel.convention.config

import com.android.build.api.dsl.CommonExtension
import com.joel.convention.util.ProjectConfig
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

fun Project.configureKotlinAndroid(
    extension: CommonExtension<*, *, *, *, *, *>
) {
    extension.apply {
        compileOptions {
            sourceCompatibility = ProjectConfig.sourceCompatibility
            targetCompatibility = ProjectConfig.targetCompatibility
        }

        kotlinOptions {
            jvmTarget = ProjectConfig.jvmTarget
        }
    }
}

fun CommonExtension<*, *, *, *, *, *>.kotlinOptions(
    action: KotlinJvmOptions.() -> Unit
) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", action)
}