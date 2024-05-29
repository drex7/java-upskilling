package com.drex.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IFramesPage extends BasePage {


    @FindBy(css = ".d-1")
    private WebElement frame2Heading;

    @FindBy(id = "frame2")
    private WebElement frame2;

    @FindBy(id = "frame1")
    private WebElement frame1;

    @FindBy(css = ".entry-title")
    private WebElement pageHeading;

    @FindBy(linkText = "Newsletters")
    private WebElement newsletter;

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

    public IFramesPage() {
        scrollIntoViewAndClick(this.iframesLink);
        waitForPageTitle("Iframes");
    }

    public void clickSupport() {
        click(By.cssSelector(".nav-item:nth-child(5) span"));
    }

    public void clickNewsletter() {
        getCustomWait().until(ExpectedConditions.elementToBeClickable(this.newsletter));
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
        return getFieldText(this.frame1Copyright);
    }

    public void closeModal() {
        this.OKBtn.click();
    }

    public String getPageHeading_1() {
        return getFieldText(frame1Heading);
    }

    public String getPageHeading_2() {
        return getFieldText(frame2Heading);
    }
}
