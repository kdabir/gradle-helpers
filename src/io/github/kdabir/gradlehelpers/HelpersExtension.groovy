package io.github.kdabir.gradlehelpers

import org.gradle.api.Project

class HelpersExtension {

    final Project project

    HelpersExtension(Project project) {
        this.project = project
    }

    def methodsOf(obj) {
        obj.metaClass.methods*.name.sort().unique()
    }

    def loadProperties(String filename) {
        loadProperties(project.file(filename))
    }

    def loadProperties(File file) {
        Properties properties = new Properties()
        file.withInputStream { properties.load(it) }
        return properties
    }

}
