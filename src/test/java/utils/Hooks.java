package utils;

import com.google.inject.Inject;
import cucumber.api.java.Before;
import models.DriverType;

public class Hooks {

    @Inject
    private SharedState sharedState;

    @Before("@browser")
    public void startBrowser() {
        sharedState.setBrowser(Browser.getDriver(DriverType.valueOf(Env.browserType.toUpperCase())));
    }
}
