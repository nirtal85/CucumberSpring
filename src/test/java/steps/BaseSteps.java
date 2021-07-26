package steps;

import di.CucumberConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pages.SearchPage;
import utilities.Aspects;

@SpringBootTest(classes = {CucumberConfig.class, SearchPage.class, Aspects.class})
@EnableAspectJAutoProxy
@CucumberContextConfiguration
public class BaseSteps {
}
