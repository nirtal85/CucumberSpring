package stpes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class MyStepdefs extends BaseSteps {
    @Value("${app.url}")
    private String appUrl;

    @Autowired
    private WebDriver driver;

    @Given("I navigate to google")
    public void iNavigateToGoogle() {
        driver.navigate().to(appUrl);
    }

    @And("I search for {string}")
    public void iSearchFor(String arg0) {
    }
}

