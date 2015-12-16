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
    List<String> methodsOf(Object obj) {
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

    /**
     * Returns all configured source directories
     *
     * @return list of {@link File} objects
     */
    List<File> getSourceDirs(){
        project.sourceSets*.allSource.srcDirs.flatten()
    }

    /**
     * Creates all the sourceSets directories
     *
     */
    def createSourceDirs(){
        sourceDirs*.mkdirs()
    }

}
