package pages;

import io.cucumber.spring.ScenarioScope;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;


@ScenarioScope
@Component
@Getter
public class SearchPage extends BasePage {

    @FindBy(css = "q")
    private WebElement searchBar;
}
