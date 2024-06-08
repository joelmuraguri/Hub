plugins {
    alias(libs.plugins.hub.android.application)
    alias(libs.plugins.hub.kotlin.android)
    alias(libs.plugins.hub.android.compose)
}

android {
    namespace = "com.joel.hub"
}


dependencies {
    implementation(project(":presentation:discover"))
    implementation(project(":presentation:profile"))
    implementation(project(":presentation:search"))
    implementation(project(":core:data"))
    implementation(project(":core:presentation"))
    implementation(libs.androidx.lifecycle.runtime.compose.android)

}
