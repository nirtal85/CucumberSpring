package stpes;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static utilities.Location.VIDEO_PATH;

public class Hooks extends BaseSteps {

    @Autowired
    private WebDriver driver;

    @Autowired
    private ScreenRecorder screenRecorder;

    static {
        try {
            Files.createDirectories(Paths.get(VIDEO_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "screenshot");
        }
    }
}
