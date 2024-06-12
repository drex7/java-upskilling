package specs;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static driver.config.ConfigurationManager.getConfiguration;

public abstract class BaseTest {

    @Step("Start the application")
    @BeforeMethod
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        Configuration.browser = browser;
        Configuration.baseUrl = getConfiguration().url();
        Configuration.headless = getConfiguration().isHeadless();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        open("/");
    }

    @Step("Stop the application")
    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        closeWebDriver();
    }
}
