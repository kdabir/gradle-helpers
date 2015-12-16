package io.github.kdabir.gradlehelpers

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

class GradleHelpersPluginSpec extends Specification {

    Project project = ProjectBuilder.builder().build()

    def setup() {
        project.pluginManager.apply GradleHelpersPlugin
    }

    def "applying plugin adds helpers extension"() {
        expect:
        project.extensions.getByName("helpers") instanceof HelpersExtension
        project.helpers instanceof HelpersExtension

    }

    def "methodsOf lists method on an object"() {
        when:
        def result = project.helpers.methodsOf(new Object())

        then:
        result == ["equals", "getClass", "hashCode", "notify", "notifyAll", "toString", "wait"]
    }

    def "loadProperties reads properties file"() {
        when:
        def loadedProperties = project.helpers.loadProperties(new File("testResources/test.properties"))

        then:
        loadedProperties.testKey == 'value'
    }

}
