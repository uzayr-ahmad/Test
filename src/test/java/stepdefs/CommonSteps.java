package stepdefs;

import com.google.inject.Inject;
import cucumber.api.java8.En;
import utils.SharedState;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps implements En {
    @Inject
    public CommonSteps(SharedState sharedState) {

        Then("^I land on correct page$", () -> {

            Thread.sleep(1000);
            String currenttitle = sharedState.getBrowser().getTitle();
            assertThat(currenttitle).isEqualTo(sharedState.getText());
        });
    }
}
