package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        tags = "not @Ignore",
        plugin = "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
        glue = "steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}