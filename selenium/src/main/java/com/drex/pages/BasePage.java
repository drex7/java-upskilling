package com.drex.pages;

import static com.drex.driver.config.ConfigurationManager.getConfiguration;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.drex.driver.config.Configuration;
import com.drex.driver.factory.DriverManager;

import lombok.Getter;

public class BasePage {

	@Getter
	private final WebDriver driver;

	@Getter
	private final Wait<WebDriver> customWait;

	private final JavascriptExecutor js;

	protected BasePage() {
		this.driver = DriverManager.getDriver();
		Configuration configuration = getConfiguration();
		int timeout = Integer.parseInt(configuration.timeout());

		PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeout), this);

		customWait = new FluentWait<WebDriver>(this.driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		js = (JavascriptExecutor) driver;
//		this.customWait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}

	protected WebElement getElementByDataTest(String dataTestValue) {
		String xpath = "//*[@data-test='" + dataTestValue + "']";
		return DriverManager.getDriver().findElement(By.xpath(xpath));
	}

	public void click(By locator) { this.driver.findElement(locator).click(); }

	@SneakyThrows
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		Thread.sleep(50);
		element.click();
	}

	public void scrollIntoView(WebElement ele) {
		((JavascriptExecutor)this.driver).executeScript(String.format("window.scrollTo(%s,%s)", ele.getLocation().x, ele.getLocation().y));
	}

	public void setText(By locator, String text) {
		this.driver.findElement(locator).clear();
		this.driver.findElement(locator).sendKeys(text);
	}

	public boolean waitForPageTitle(String title) {
		return customWait.until(ExpectedConditions.titleContains(title));
	}

	public void dismissPopup() {
		this.driver.switchTo().alert().dismiss();
	}

	public void acceptPopup() {
		this.driver.switchTo().alert().accept();
	}

	public Alert getCurrentPopup() {
		return this.driver.switchTo().alert();
	}

	public String getPopupText() { return this.driver.switchTo().alert().getText();}

	public boolean waitForElementByText(WebElement element, String text) {
//		customWait.until(ExpectedConditions.textToBe(locator, text));
		return customWait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public String getElementText(By locator) {
		String displayedText = this.driver.findElement(locator).getText();
		if (displayedText.isEmpty()) {
			return this.driver.findElement(locator).getAttribute("value");
		} else {
			return displayedText;
		}
	}

	public String getPageTitle() {
		return this.driver.getTitle();
	}

	public String getFieldText(WebElement inputField) {
		String displayedText = inputField.getText();
		if (displayedText.isEmpty()) {
			return inputField.getAttribute("value");
		} else {
			return displayedText;
		}
	}

	public String getWindowHandle() {
		return this.driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return this.driver.getWindowHandles();
	}

	public void switchToNewWindow(String window) {
		this.driver.switchTo().window(window);
	}

	public void switchFrames(int frame) {
		this.driver.switchTo().frame(frame);
	}

	public void switchToDefaultFrame() {
		this.driver.switchTo().defaultContent();
	}

	public WebElement findDynamicElement(By locator) {
		return this.driver.findElement(locator);
	}

	public List<WebElement> findDynamicElements(By locator) {
		return this.driver.findElements(locator);
	}

	public void scrollBy(Integer x, Integer y) {

		js.executeScript(String.format("javascript:window.scrollBy(%s,%s)", x, y));
	}

	public void scrollElementIntoView(WebElement element) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}


}
