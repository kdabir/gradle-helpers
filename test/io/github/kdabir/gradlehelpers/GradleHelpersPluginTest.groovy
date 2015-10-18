import io.github.kdabir.gradlehelpers.GradleHelpersPlugin
import io.github.kdabir.gradlehelpers.HelpersExtension
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class GradleHelpersPluginTest {

    @Test
    void "applying plugin adds helpers extension"() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply GradleHelpersPlugin

        assert project.extensions.getByName("helpers") instanceof HelpersExtension
        assert project.helpers instanceof HelpersExtension
    }

    @Test
    void "methodsOf lists method on an object"() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply GradleHelpersPlugin

        assert project.helpers.methodsOf(new Object()) == ["equals", "getClass", "hashCode",
                                                           "notify", "notifyAll", "toString", "wait"]
    }

    @Test
    void "loadProperties reads properties file"() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply GradleHelpersPlugin

        assert project.helpers.loadProperties(new File("test/test.properties")).testKey == 'value'
    }

}
