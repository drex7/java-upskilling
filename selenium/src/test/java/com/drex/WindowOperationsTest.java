package com.drex;

import com.drex.pages.WindowOperations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WindowOperationsTest extends BaseTest {


    @Test(description = "Test multiple open windows")
    public void testMultipleOpenWindows() {
        WindowOperations windowPage = new WindowOperations();

        windowPage.openNewWindow();
        windowPage.switchToNewWindowHandle();
        assertTrue(windowPage.waitForPageTitle("Home | automateNow"));
    }

    @Test(description = "Test multiple open tab")
    public void testMultipleOpenTabs() {
        WindowOperations windowPage = new WindowOperations();
        windowPage.openNewTab();
        windowPage.switchToNewWindowHandle();
        assertTrue(windowPage.waitForPageTitle("Home | automateNow"));
    }

    @Test(description = "Test replace windows")
    public void testReplaceTab() {
        WindowOperations windowPage = new WindowOperations();
        windowPage.replaceWindow();
        String title = windowPage.getPageTitle();
        assertEquals(title, "Home | automateNow");
    }
}
