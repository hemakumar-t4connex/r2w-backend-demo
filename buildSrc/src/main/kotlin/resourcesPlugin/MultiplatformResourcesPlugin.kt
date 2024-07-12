package resourcesPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.deleteRecursively

val Project.multiplatformBuildDir get() = buildDir
    .absolutePath.replace("\\","/") + "/multiplatform_resources"
val Project.multiplatformResourcesDir get() = "$multiplatformBuildDir/main"

val Project.multiplatformTestResourcesDir get() = "$multiplatformBuildDir/test"
class MultiplatformResourcesPlugin: Plugin<Project> {
    @OptIn(ExperimentalPathApi::class)
    override fun apply(target: Project) {
        println("Applying multiplatform resources plugin")
        // Create a task using the task type
        target.tasks.register<MultiplatformResourcesTask>("generateMultiplatformResources")
        target.tasks.withType<MultiplatformResourcesTask>().firstOrNull()?.let {
            it.run()
        }
    }




}