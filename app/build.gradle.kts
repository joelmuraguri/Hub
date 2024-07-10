import java.util.Properties

plugins {
    alias(libs.plugins.hub.android.application)
    alias(libs.plugins.hub.kotlin.android)
    alias(libs.plugins.hub.android.compose)
    alias(libs.plugins.hub.android.dataLibrary)

}

val localPropertiesFile = rootProject.file("local.properties")
val localProperties = Properties().apply {
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { stream ->
            load(stream)
        }
    }
}

android {
    namespace = "com.joel.hub"

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "COMIC_VINE_API_KEY", "\"${localProperties.getProperty("COMIC_VINE_API_KEY")}\"")
            buildConfigField("String", "TMDB_API_KEY", "\"${localProperties.getProperty("TMDB_API_KEY")}\"")
        }
        debug {
            // configuration for debug builds
            buildConfigField("boolean", "DEBUG", "true")
        }
    }
}


dependencies {
    implementation(project(":presentation:discover"))
    implementation(project(":presentation:profile"))
    implementation(project(":presentation:search"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:presentation"))
    implementation(project(":comic:presentation"))
    implementation(project(":comic:domain"))
    implementation(project(":comic:data"))
    implementation(project(":news:presentation"))
    implementation(project(":film:presentation"))
    implementation(libs.androidx.lifecycle.runtime.compose.android)
}
