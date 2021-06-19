package steps;

import di.CucumberConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import pages.SearchPage;

@SpringBootTest(classes = {CucumberConfig.class, SearchPage.class})
@CucumberContextConfiguration
public class BaseSteps {
}
