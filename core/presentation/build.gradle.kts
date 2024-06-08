import com.joel.convention.util.ProjectConfig

plugins {
    alias(libs.plugins.hub.kotlin.android)
    alias(libs.plugins.hub.android.library)
    alias(libs.plugins.hub.android.compose)
}

android {
    namespace = "com.joel.presentation"

    compileOptions {
        sourceCompatibility = ProjectConfig.sourceCompatibility
        targetCompatibility = ProjectConfig.targetCompatibility
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(libs.androidx.lifecycle.runtime.compose.android)
}
