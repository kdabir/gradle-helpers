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
        def loadedProperties = project.helpers.loadProperties(new File("src/test/resources/test.properties"))

        then:
        loadedProperties.testKey == 'value'
    }

    def "getSourceDirs throws exception when no sourceSet defined on project"() {
        given: "no java like plugin is applied"

        when: "try to access sourceDirs"
        project.helpers.sourceDirs

        then:
        thrown RuntimeException
    }

    def "getSourceDirs returns list of source directories"() {
        given: "java like plugins are applied"
        project.pluginManager.apply pluginName

        when: "try to access sourceDirs"
        def dirs = project.helpers.sourceDirs

        then:
        dirs.size() == expectedLength

        where:
        pluginName || expectedLength
        'java'     || 4
        'groovy'   || 6
        'scala'    || 6
    }

    def "createSourceDirs creates directories"() {
        given: "java like plugins is applied"
        project.pluginManager.apply 'java'

        assert !project.helpers.sourceDirs.any { it.exists() }

        when: "method is called"
        def result = project.helpers.createSourceDirs()

        then:
        project.helpers.sourceDirs.every { it.exists() }

    }

}
