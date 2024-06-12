package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;
import static pages.utils.Util.waitForPageTitle;

public class FileUploadPage {

    public FileUploadPage navigateToPage() {
        $(By.linkText("File Upload")).click();
        waitForPageTitle("File Upload");
        return this;
    }

    public FileUploadPage uploadFile(String filepath) {
        $(By.id("file-upload")).uploadFile(new File(filepath));
        $(xpath("//input[@value='Upload']")).click();
        return this;
    }

    public void assertUploadSuccess(String message) {
        $(xpath("//div[@class='wpcf7-response-output']")).shouldHave(text(message));
    }
}
