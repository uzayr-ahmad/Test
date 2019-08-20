package utils;

import com.google.gson.Gson;
import cucumber.runtime.java.guice.ScenarioScoped;
import models.BitcoinData;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class SharedState {
    private WebDriver driver;
    private String text;
    private String chromeDriverVersion;
    private BitcoinData bitcoinData;
    private Gson gson = new Gson();

    public void setBrowser(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getBrowser() {
        return driver;
    }

    public void setText(String text) {
        this.text = text;


    }

    public String getText() {
        return text;
    }

    public void setChromeDriverVersion(String fetchLatestChromeDriverVersion){
        chromeDriverVersion = fetchLatestChromeDriverVersion;

    }

    public String getChromeDriverVersion() {
        return chromeDriverVersion;
    }

    public void setBitcoinData(String data) {

        bitcoinData = gson.fromJson(data, BitcoinData.class);


    }

    public BitcoinData getBitcoinData() {
        return bitcoinData;
    }
}
