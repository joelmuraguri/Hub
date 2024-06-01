pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")


rootProject.name = "Hub"
include(":app")
include(":presentation:discover")
include(":presentation:profile")
include(":core:data")
include(":core:presentation")
include(":core:domain")
include(":news:data")
include(":news:domain")
include(":film:data")
include(":film:domain")
include(":comic:data")
include(":comic:domain")
include(":anime:data")
include(":anime:domain")
