package io.github.kdabir.gradlehelpers

import org.gradle.api.Plugin
import org.gradle.api.Project

class GradleHelpersPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('helpers', HelpersExtension, project)
    }
}
