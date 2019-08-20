package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Env {
    private static Config config = ConfigFactory.load();

    public static final String browserType = config.getString("browser-type");

    public static final String browserLocation = config.getString("browser-location");
}
