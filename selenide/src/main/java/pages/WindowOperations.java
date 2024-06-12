package pages;

import org.openqa.selenium.By;
import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WindowOperations {

    public WindowOperations navigateToPage() {
        $(By.linkText("Window Operations")).click();
        return this;
    }

    public void openNewTab() {
        $(By.xpath("//b[normalize-space()='New Tab']")).click();
    }

    public void openNewWindow() {
        $(By.xpath("//b[normalize-space()='New Window']")).click();
    }

    public void replaceWindow() {
        $(By.xpath("//b[normalize-space()='Replace Window']")).click();
    }

    public void switchToNewWindowHandle() {
        // Get current window handle
        String currentWindow = getWebDriver().getWindowHandle();

        // Get all window handles
        Set<String> handles = getWebDriver().getWindowHandles();

        //witch to new window
        Iterator<String> iter = handles.iterator();

        String newWindow = null;
        while (iter.hasNext()) {
            newWindow = iter.next();
            if (!currentWindow.equals(newWindow)) {
                switchTo().window(newWindow);
            }
        }
    }

}
