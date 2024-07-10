import com.joel.convention.config.kotlinOptions
import com.joel.convention.util.ProjectConfig

plugins {
    alias(libs.plugins.hub.kotlin.android)
    alias(libs.plugins.hub.android.library)
    alias(libs.plugins.hub.android.dataLibrary)

}

android {
    namespace = "com.joel.domain"

    compileOptions {
        sourceCompatibility = ProjectConfig.sourceCompatibility
        targetCompatibility = ProjectConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = ProjectConfig.jvmTarget
    }
}

dependencies {
    implementation(project(":comic:data"))
}

