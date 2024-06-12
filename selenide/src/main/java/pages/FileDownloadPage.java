package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class FileDownloadPage {

    @FindBy(xpath = "//a[contains(text(),'File Download')]")
    private WebElement fileDownload;

    @FindBy(xpath = "//a[@class='wpdm-download-link download-on-click btn btn-primary']")
    private WebElement pdfDownloadBtn;

    @FindBy(css = ".wpdm-download-link.wpdm-download-locked.btn.btn-primary ")
    private WebElement docDownloadBtn;

    @FindBy(linkText = "File Download")
    private WebElement downloadLink;

    public FileDownloadPage navigateToPage() {
        $(By.linkText("File Download")).click();
        return this;
    }

    public void downloadPDF() {
        $(".download-on-click").click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void downloadLockedFile() {
        String password = "automateNow";
        $(".wpdm-download-locked").click();
        switchTo().frame("wpdm-lock-frame");
        $(By.name("password")).setValue(password);
        $(".wpdm_submit").click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
