package stpes;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks extends BaseSteps {

    @Autowired
    private WebDriver driver;

    @After
    public void afterScenario(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            scenario.attach(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png", "screenshot");
        }
    }
}
