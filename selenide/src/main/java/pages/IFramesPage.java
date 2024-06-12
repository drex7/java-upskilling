package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class IFramesPage {

    private SelenideElement newsletter = $(By.linkText("Newsletters"));

    @FindBy(linkText = "Support")
    private WebElement support;

    @FindBy(css = ".NewsletterSignup__Title")
    private WebElement frame1Heading;

    @FindBy(xpath = "div[class='GlobalFooter__CopyrightWrapper'] span:nth-child(1)")
    private WebElement frame1Copyright;

    @FindBy(xpath = "//small[contains(text(), 'All Rights Reserved')]")
    private WebElement frame2Copyright;

    @FindBy(css = ".ab-message-button:nth-child(2)")
    private WebElement OKBtn;

    @FindBy(linkText = "Iframes")
    private WebElement iframesLink;

    public IFramesPage navigateToPage() {
        $(By.linkText("Iframes")).click();
        return this;
    }

    public void clickSupport() {
        $(".nav-item:nth-child(5) span").click();
    }

    public void clickNewsletter() {
//        getCustomWait().until(ExpectedConditions.elementToBeClickable(this.newsletter));
        this.newsletter.click();
    }

    public void switchToIframe1() {
        switchFrames(1);
    }
    public void switchToIframe2() {
        // National Geographic
        switchFrames(1);
    }

    public String getCopyrightText() {
        return $(By.xpath("div[class='GlobalFooter__CopyrightWrapper'] span:nth-child(1)")).getText();
    }

    public void closeModal() {
        $(".ab-message-button:nth-child(2)").click();
    }

    public String getPageHeading_1() {
        return $(".NewsletterSignup__Title").getText();
    }

    public String getPageHeading_2() {
        return $(".d-1").getText();
    }

    public void switchFrames(int index) {
        switchTo().frame(index, Duration.ofSeconds(50));
    }

    public String getPageTitle() {
        return Selenide.title();
    }

    public void switchToDefaultFrame() {
        switchTo().defaultContent();
    }
}
