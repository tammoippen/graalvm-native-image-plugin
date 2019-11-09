/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.mikeneck.graalvm;

import org.gradle.api.Project;
import org.gradle.api.Plugin;
import org.gradle.api.tasks.TaskContainer;

public class GraalvmNativeImagePlugin implements Plugin<Project> {

    public void apply(Project project) {
        NativeImageExtension nativeImageExtension = new NativeImageExtension(project);
        project.getExtensions().add("nativeImage", nativeImageExtension);

        TaskContainer taskContainer = project.getTasks();
        taskContainer.create("nativeImage", NativeImageTask.class, task -> {
            task.setExtension(nativeImageExtension);
            task.dependsOn(nativeImageExtension.jarTask.get());
            task.setDescription("Creates native executable");
            task.setGroup("graalvm");
        });
    }
}
