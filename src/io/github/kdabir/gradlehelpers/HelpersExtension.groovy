package io.github.kdabir.gradlehelpers

import org.gradle.api.Project

class HelpersExtension {

    final Project project

    HelpersExtension(Project project) {
        this.project = project
    }

    /**
     * lists available methods on an object
     *
     * @param obj
     * @return list of method names
     */
    def methodsOf(obj) {
        obj.metaClass.methods*.name.sort().unique()
    }

    /**
     * loads properties from relative to project root
     *
     * @param filename - String
     * @return properties object
     */
    Properties loadProperties(String filename) {
        loadProperties(project.file(filename))
    }

    /**
     * loads properties from file
     *
     * @param file - File Object
     * @return properties object
     */
    Properties loadProperties(File file) {
        Properties properties = new Properties()
        file.withInputStream { properties.load(it) }
        return properties
    }

}
