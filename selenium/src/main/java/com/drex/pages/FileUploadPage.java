package com.drex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {


    @FindBy(linkText = "File Upload")
    private WebElement uploadLink;

    @FindBy(id = "file-upload")
    private WebElement chooseFileBtn;

    @FindBy(xpath = "//input[@value='Upload']")
    private WebElement uploadBtn;

    @FindBy(xpath = "//div[@class='wpcf7-response-output']")
    private WebElement uploadStatus;


    public FileUploadPage() {
        scrollIntoViewAndClick(this.uploadLink);
        waitForPageTitle("File Upload");
    }

    public void uploadFile(String filepath) {
        this.chooseFileBtn.sendKeys(filepath);
        this.uploadBtn.click();

    }

    public boolean isUploadSuccess() {
        return waitForElementByText(uploadStatus, "Thank you for your message. It has been sent.");
    }
}
