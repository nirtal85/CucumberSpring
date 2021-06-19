package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        tags = "not @Ignore",
        glue = "steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
