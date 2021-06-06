package stpes;

import di.CucumberConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CucumberConfig.class)
@CucumberContextConfiguration
public class BaseSteps {
}
