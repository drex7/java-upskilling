package com.drex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

public class WindowOperations extends BasePage {

    @FindBy(linkText = "Window Operations")
    private WebElement windowsLink;

    @FindBy(xpath = "//b[normalize-space()='New Tab']")
    private WebElement newTab;

    @FindBy(xpath = "//b[normalize-space()='New Window']")
    private WebElement newWindow;

    @FindBy(xpath = "//b[normalize-space()='Replace Window']")
    private WebElement replaceWindow;

    public WindowOperations() {
        scrollIntoViewAndClick(this.windowsLink);
        waitForPageTitle("Window Operations");
    }

    public void openNewTab() {
        this.newTab.click();
    }

    public void openNewWindow() {
        this.newWindow.click();
    }

    public void replaceWindow() {
        this.replaceWindow.click();
    }

    public void switchToNewWindowHandle() {
//        Get current window handle
        String currentWindow = getWindowHandle();

        // Get all window handles
        Set<String> handles = getWindowHandles();

        //witch to new window
        Iterator<String> iter = handles.iterator();

        String newWindow = null;
        while (iter.hasNext()) {
            newWindow = iter.next();
            if (!currentWindow.equals(newWindow)) {
                switchToNewWindow(newWindow);
            }
        }
    }
}
