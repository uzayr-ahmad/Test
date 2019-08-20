package stepdefs;


import com.google.inject.Inject;
import connectors.ChromeDriverConnector;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SharedState;

import static org.assertj.core.api.Assertions.assertThat;

public class ChromeDriverSteps implements En {

    @Inject
    public ChromeDriverSteps(SharedState sharedState, ChromeDriverConnector chromeDriverConnector) {

        Given("^I fetch Chromedriver version$", () -> {
            sharedState.setChromeDriverVersion(chromeDriverConnector.fetchLatestChromeDriverVersion("https://chromedriver.storage.googleapis.com"));
        });
        Then("^I get the latest version (\\d{2}\\.\\d{1}\\.\\d{4}\\.\\d{2})$", (String version) -> {
            assertThat(sharedState.getChromeDriverVersion()).isEqualTo(version);
        });
    }
}
