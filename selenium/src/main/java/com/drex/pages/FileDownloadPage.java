package com.drex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'File Download')]")
    private WebElement fileDownload;

    @FindBy(xpath = "//a[@class='wpdm-download-link download-on-click btn btn-primary']")
    private WebElement pdfDownloadBtn;

    @FindBy(css = ".wpdm-download-link.wpdm-download-locked.btn.btn-primary ")
    private WebElement docDownloadBtn;

    @FindBy(linkText = "File Download")
    private WebElement downloadLink;

    public FileDownloadPage() {
        scrollIntoViewAndClick(this.downloadLink);
        waitForPageTitle("File Download");
    }

    public void downloadPDF() {
        this.pdfDownloadBtn.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
