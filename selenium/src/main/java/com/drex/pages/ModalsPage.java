package com.drex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalsPage extends BasePage {

    @FindBy(linkText = "Modals")
    private WebElement modalsLink;

    @FindBy(id = "simpleModal")
    private WebElement simpleModalBtn;

    @FindBy(id = "formModal")
    private WebElement formModalBtn;

    @FindBy(id = "pum_popup_title_1318")
    private WebElement simpleModalHeading;

    @FindBy(id = "g1051-name")
    private WebElement name;

    @FindBy(id = "g1051-email")
    private WebElement email;

    @FindBy(id = "contact-form-comment-g1051-message")
    private WebElement message;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@id='popmake-1318']//button[@aria-label='Close'][normalize-space()='×']")
    private WebElement simpleModalCloseIcon;

    @FindBy(css = "div[id='popmake-674'] button[aria-label='Close']")
    private WebElement formModalCloseIcon;




    public ModalsPage sendMessage(String name, String email, String message) {
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.message.sendKeys(message);
        this.submitBtn.click();
        return this;
    }

    public ModalsPage openFormModal() {
        this.formModalBtn.click();
        return this;
    }

    public void openSimpleModal() {
        this.simpleModalBtn.click();
    }

    public boolean isModalOpened() {
        return waitForElementByText(this.simpleModalHeading, "Simple Modal");
    }

    public void closeSimpleModal() {
        this.simpleModalCloseIcon.click();
    }

    public void closeFormModal() {
        this.formModalCloseIcon.click();
    }


}
