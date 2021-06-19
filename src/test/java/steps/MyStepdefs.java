package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import pages.SearchPage;

public class MyStepdefs extends BaseSteps {

    @Value("${app.url}")
    private String appUrl;

    @Autowired
    private WebDriver driver;

    @Autowired
    private SearchPage searchPage;

    @Given("I navigate to google")
    public void iNavigateToGoogle() {
        driver.navigate().to(appUrl);
    }

    @And("I search for {string}")
    public void iSearchFor(String arg0) {
        searchPage.getSearchBar().sendKeys(arg0);

    }
}

