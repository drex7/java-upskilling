package com.drex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupPage extends BasePage {

    @FindBy(linkText = "Popups")
    private WebElement popupsLink;

    @FindBy(id = "alert")
    private WebElement alertButton;

    @FindBy(id = "confirm")
    private WebElement confirmButton;

    @FindBy(id = "prompt")
    private WebElement promptButton;

    @FindBy(css = "tooltip_1")
    private WebElement tooltipButton;

    @FindBy(id = "myTooltip")
    private WebElement tooltip;

    @FindBy(id = "confirmResult")
    private WebElement confirmResult;

    @FindBy(id = "promptResult")
    private WebElement promptResult;


    public PopupPage() {
        navigateToPage();
        waitForPageTitle("Popups");
    }

    public void navigateToPage() {
        scrollIntoViewAndClick(this.popupsLink);
    }

    public void clickAlert() {
        this.alertButton.click();
    }

    public void clickConfirmButton() {
        this.confirmButton.click();
    }

    public void clickPromptButton() {
        this.promptButton.click();
    }


    public void clickToolip() {
        this.tooltip.click();
    }

    public void fillName(String text) {
        this.getCurrentPopup().sendKeys(text);
    }


    public String getConfirmPopupResult() {
        return this.confirmResult.getText();
    }

    public String getPromptPopupResult() {
        return this.promptResult.getText();
    }

    public boolean waitForTooltip(String text) {
        return waitForElementByText(tooltip, text);
    }
}
