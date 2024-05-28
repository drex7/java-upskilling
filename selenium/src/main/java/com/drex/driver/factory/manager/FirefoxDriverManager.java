
package com.drex.driver.factory.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.drex.driver.factory.Factory;

// import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FirefoxDriverManager implements Factory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();

        return new FirefoxDriver();
    }
}
