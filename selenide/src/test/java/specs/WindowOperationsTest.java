package specs;

import org.testng.annotations.BeforeMethod;
import pages.WindowOperations;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.utils.Util.getPageTitle;

public class WindowOperationsTest extends BaseTest {

    WindowOperations windowPage;

    @BeforeMethod
    public void goToPage() {
        windowPage = new WindowOperations();
        windowPage.navigateToPage();
    }

    @Test(description = "Test multiple open windows")
    public void testMultipleOpenWindows() {
        windowPage.openNewWindow();
        windowPage.switchToNewWindowHandle();
        assertEquals(getPageTitle(), "Home | automateNow");
    }

    @Test(description = "Test multiple open tab")
    public void testMultipleOpenTabs() {
        windowPage.openNewTab();
        windowPage.switchToNewWindowHandle();
        assertEquals(getPageTitle(), "Home | automateNow");
    }

    @Test(description = "Test replace windows")
    public void testReplaceTab() {
        windowPage.replaceWindow();
        assertEquals(getPageTitle(), "Home | automateNow");
    }
}
