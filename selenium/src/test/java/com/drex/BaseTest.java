package com.drex;

import static com.drex.driver.config.ConfigurationManager.getConfiguration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.drex.driver.factory.DriverFactory;
import com.drex.driver.factory.DriverManager;

public abstract class BaseTest {



    @BeforeMethod
    public void preCondition() {
        WebDriver driver = DriverFactory.createInstance(getConfiguration().browser());
        DriverManager.setDriver(driver);
        driver.get(getConfiguration().url());
    }

    @AfterMethod
    public void postCondition() {
        DriverManager.quit();
    }
}
