package com.drex.driver.factory;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.drex.driver.factory.manager.ChromeDriverManager;
import com.drex.driver.factory.manager.EdgeDriverManager;
import com.drex.driver.factory.manager.FirefoxDriverManager;
import com.drex.driver.factory.manager.SafariDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DriverFactory {

    public static WebDriver createInstance(String browser) {
        WebDriver driver = null;

        driver = WebDriverManager.firefoxdriver().create();
        return driver;
    }
        /*
        try {
            driver = switch (browserType) {
                case CHROME -> new ChromeDriverManager().createDriver();
                case FIREFOX -> new FirefoxDriverManager().createDriver();
                case EDGE -> new EdgeDriverManager().createDriver();
                case SAFARI -> new SafariDriverManager().createDriver();
            };
        } catch (Exception e) {
            System.out.println("******-------------**************\n\n");
            System.out.println("e--driver -> " + driver);
            System.out.println("\n\n******-------------**************");
        }
        return driver;
    }

    /
    public WebDriver createInstance(String browser) {
        WebDriver driver;
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        driver = switch (browserType) {
            case CHROME -> new ChromeDriverManager().createDriver();
            case FIREFOX -> new FirefoxDriverManager().createDriver();
            case EDGE -> new EdgeDriverManager().createDriver();
            case SAFARI -> new SafariDriverManager().createDriver();
        };
        return driver;
    }
    */
}
