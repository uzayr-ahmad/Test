package utils;

import models.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    public static WebDriver getDriver(DriverType driverType) {
        // todo move to config location of the driver

        ChromeOptions chromeOptions = new ChromeOptions();

        if (driverType == DriverType.CHROME) {
            chromeOptions.setHeadless(false);
        } else {
            chromeOptions.setHeadless(true);
        }

        System.setProperty("webdriver.chrome.driver", Env.browserLocation);
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        Runtime.getRuntime().addShutdownHook(new Thread(chromeDriver::quit));
        return chromeDriver;

    }
}
