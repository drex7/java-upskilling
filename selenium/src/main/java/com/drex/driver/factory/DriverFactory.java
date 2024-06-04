package com.drex.driver.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import io.github.bonigarcia.wdm.webdriver.OptionsWithArguments;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import com.drex.driver.factory.manager.ChromeDriverManager;
import com.drex.driver.factory.manager.EdgeDriverManager;
import com.drex.driver.factory.manager.FirefoxDriverManager;
import com.drex.driver.factory.manager.SafariDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.drex.driver.config.ConfigurationManager.getConfiguration;

public class DriverFactory {

    public static WebDriver createInstance(String browser) {
        WebDriver driver = null;

        try {
            driver = WebDriverManager.getInstance(browser).capabilities(getDriverOptions(browser)).create();
            applyCommonSetup(driver);
            return driver;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static WebDriver applyCommonSetup(WebDriver driver) {
        driver.manage().window().maximize();
        return driver;
    }

    private static AbstractDriverOptions<?> getDriverOptions(String browser) {
        AbstractDriverOptions<?> options;
        boolean headlessMode = getConfiguration().isHeadless();
        DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
        switch (driverManagerType) {
            case CHROME:
                options = new ChromeOptions().addArguments("--headless");
                break;
            case FIREFOX:
                options = new FirefoxOptions().addArguments("--headless");
                break;
            case EDGE:
                options = new EdgeOptions().addArguments("--headless");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + driverManagerType);
        }

        return options;
    }
}
