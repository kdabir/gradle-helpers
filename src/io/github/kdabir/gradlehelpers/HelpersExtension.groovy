package io.github.kdabir.gradlehelpers

import org.gradle.api.Project

class HelpersExtension {

    final Project project

    HelpersExtension(Project project) {
        this.project = project
    }

    /**
     * Lists available methods on an object
     *
     * @param obj
     * @return list of method names
     */
    List<String> methodsOf(obj) {
        obj.metaClass.methods*.name.sort().unique()
    }

    /**
     * Loads properties from file path relative to project root
     *
     * @param filename path as String
     * @return properties object
     */
    Properties loadProperties(String filename) {
        loadProperties(project.file(filename))
    }

    /**
     * Loads properties from given file object
     *
     * @param file File Object
     * @return loaded properties object
     */
    Properties loadProperties(File file) {
        Properties properties = new Properties()
        file.withInputStream { properties.load(it) }
        return properties
    }

}
