package steps;

import di.CucumberConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.testng.Assert;
import pages.SearchPage;
import utilities.Aspects;

@SpringBootTest(classes = {CucumberConfig.class, SearchPage.class, Aspects.class})
@EnableAspectJAutoProxy
@CucumberContextConfiguration
public class Steps {

    @Value("${app.url}")
    private String appUrl;
    @Autowired
    private WebDriver driver;
    @Autowired
    private SearchPage searchPage;
    /**
     * @see <a href="https://reflectoring.io/dont-use-spring-profile-annotation/">https://reflectoring.io/dont-use-spring-profile-annotation/</a>
     */
    @Value("${browser}")
    String browser;
    @Autowired(required = false)
    private DevTools devTools;


    @Given("I navigate to google")
    public void iNavigateToGoogle() {
        driver.navigate().to(appUrl);
    }

    @And("I search for {string}")
    public void iSearchFor(String arg0) {
        searchPage.getSearchBar().sendKeys(arg0);
    }

    @Then("{int} results should be found")
    public void resultsShouldBeFound(int arg0) {
        Assert.fail();
    }
}
