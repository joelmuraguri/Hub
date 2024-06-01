plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

group = "com.joel"

dependencies {
    compileOnly(libs.agp)
    compileOnly(libs.kgp)
}

gradlePlugin {
    plugins {
        create("androidApplication") {
            id = "hub.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        create("kotlinAndroid") {
            id = "hub.kotlin.android"
            implementationClass = "KotlinAndroidConventionPlugin"
        }

        create("androidCompose") {
            id = "hub.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }

        create("androidLibrary") {
            id = "hub.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        create("dataAndroidLibrary") {
            id = "hub.android.dataLibrary"
            implementationClass = "DataAndroidLibraryConventionPlugin"
        }

    }
}
