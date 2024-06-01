import com.android.build.api.dsl.LibraryExtension
import com.joel.convention.config.configureDataLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project

class DataAndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
                apply("kotlinx-serialization")
            }


            extensions.findByType(LibraryExtension::class.java)?.let {
                configureDataLibrary(it)
            }
        }
    }
}