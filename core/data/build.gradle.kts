import com.joel.convention.util.ProjectConfig

plugins {
    alias(libs.plugins.hub.kotlin.android)
    alias(libs.plugins.hub.android.library)
    alias(libs.plugins.hub.android.dataLibrary)
}

android {
    namespace = "com.joel.data"

    compileOptions {
        sourceCompatibility = ProjectConfig.sourceCompatibility
        targetCompatibility = ProjectConfig.targetCompatibility
    }

}

