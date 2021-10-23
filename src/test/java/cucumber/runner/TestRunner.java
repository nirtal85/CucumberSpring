package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        tags = "not @Ignore",
        glue = "cucumber/steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}