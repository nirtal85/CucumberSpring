package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.network.Network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import pages.MyAnnotation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import static utilities.Location.VIDEO_PATH;

public class Hooks extends BaseSteps {

    @Autowired
    private WebDriver driver;

    /**
     * @see <a href="https://reflectoring.io/dont-use-spring-profile-annotation/">https://reflectoring.io/dont-use-spring-profile-annotation/</a>
     */
    @Value("${browser}")
    String browser;

    @Autowired(required = false)
    private DevTools devTools;

    @Autowired
    private ScreenRecorder screenRecorder;

    @BeforeAll
    public static void beforeAll() {
        try {
            Files.createDirectories(Paths.get(VIDEO_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    @MyAnnotation("ABC")
    public void enableNetwork() {
        System.out.println(browser);
        if (browser.equals("chrome")) {
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
            devTools.addListener(Network.requestWillBeSent(),
                    entry -> {
                        System.out.println("Request URI : " + entry.getRequest().getUrl() + "\n"
                                + " With method : " + entry.getRequest().getMethod() + "\n");
                        entry.getRequest().getMethod();
                    });
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "screenshot");
        }
    }
}
