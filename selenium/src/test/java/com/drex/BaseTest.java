package com.drex;

import static com.drex.driver.config.ConfigurationManager.getConfiguration;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.drex.driver.factory.DriverFactory;
import com.drex.driver.factory.DriverManager;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    @Step("Start the application")
    @BeforeMethod
    @Parameters("browser")
    public void preCondition(@Optional("firefox") String browser) {
        WebDriver driver = DriverFactory.createInstance(browser);
        DriverManager.setDriver(driver);
        driver.get(getConfiguration().url());
    }

    @Step("Stop the application")
    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }
}
