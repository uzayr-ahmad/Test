package stepdefs;


import com.google.inject.Inject;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.SharedState;

import static org.assertj.core.api.Assertions.assertThat;

public class BrowserSteps implements En {

    @Inject
    public BrowserSteps(SharedState sharedState) {

/*        Given("^I go to (Google|DuckDuckGo|Wikipedia|Maps)$", (String searchEngine) -> {
            if (searchEngine.equalsIgnoreCase("Google")) {
                sharedState.getBrowser().get("https://google.co.uk");
            } else if (searchEngine.equalsIgnoreCase("DuckDuckGo")) {
                sharedState.getBrowser().get("https://duckduckgo.com");
            } else if (searchEngine.equalsIgnoreCase("Wikipedia")) {
                sharedState.getBrowser().get("https://wikipedia.org");
            } else {
                sharedState.getBrowser().get("https://google.com/maps");
            }

        });

        When("^I enter text (.+) into search bar of search engine (.+)$", (String text, String searchEngine) -> {

            WebElement searchbar;

            WebElement search;

            if (searchEngine.equalsIgnoreCase("google")) {
                sharedState.setText(text + " - Google Search");
                search = sharedState.getBrowser().findElement(By.name("f"));
                searchbar = sharedState.getBrowser().findElement(By.name("q"));
            } else if (searchEngine.equalsIgnoreCase("DuckDuckGo")) {
                sharedState.setText(text + " at DuckDuckGo");
                search = sharedState.getBrowser().findElement(By.name("x"));
                searchbar = sharedState.getBrowser().findElement(By.name("q"));
            } else if (searchEngine.equalsIgnoreCase("Wikipedia")) {
                sharedState.setText(text + " - Wikipedia");
                search = sharedState.getBrowser().findElement(By.name("family"));
                searchbar = sharedState.getBrowser().findElement(By.name("search"));
            } else {
                sharedState.setText(text + " - Google Maps");
                search = sharedState.getBrowser().findElement(By.id("searchbox_form"));
                searchbar = sharedState.getBrowser().findElement(By.name("q"));

            }
            searchbar.sendKeys(text);
            search.submit();
            if(searchEngine.equalsIgnoreCase("Maps")){
                sharedState.getBrowser().findElement(By.id("searchbox-searchbutton")).click();
            }
            Thread.sleep(5000);


        });
*/
        Given("^I go to Maps$", () -> {

            sharedState.getBrowser().get("https://google.com/maps");

        });
        When("^I enter location (.+) into Maps$", (String location) -> {

            WebElement search = sharedState.getBrowser().findElement(By.id("searchbox_form"));
            WebElement searchbar = sharedState.getBrowser().findElement(By.name("q"));
            sharedState.setText(location + " - Google Maps");
            searchbar.sendKeys(location);
            search.submit();
            sharedState.getBrowser().findElement(By.id("searchbox-searchbutton")).click();

            Thread.sleep(5000);

        });
        And("^I click on directions button$", () -> {
            sharedState.getBrowser().findElement(By.className("iRxY3GoUYUY__below-button-text gm2-caption")).click();
        });
        Then("^I type in work (.+) location$", (String work) -> {
            WebElement search2 = sharedState.getBrowser().findElement(By.id("searchbox_form"));
            WebElement searchbar2 = sharedState.getBrowser().findElement(By.className("tactile-searchbox-input"));
            sharedState.setText(work + " - Google Maps");

            searchbar2.sendKeys(work);
            search2.submit();

        });
        And("^I click on search button$", () -> {

            sharedState.getBrowser().findElement(By.className("suggest-left-cell")).click();
            Thread.sleep(5000);
        });
    }
}
