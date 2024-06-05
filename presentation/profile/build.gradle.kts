import com.joel.convention.util.ProjectConfig

plugins {
    alias(libs.plugins.hub.kotlin.android)
    alias(libs.plugins.hub.android.library)
    alias(libs.plugins.hub.android.compose)
}

android {
    namespace = "com.joel.profile"

    compileOptions {
        sourceCompatibility = ProjectConfig.sourceCompatibility
        targetCompatibility = ProjectConfig.targetCompatibility
    }

}
