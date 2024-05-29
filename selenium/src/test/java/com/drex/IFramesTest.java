package com.drex;

import com.drex.pages.IFramesPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IFramesTest extends BaseTest {

    @Test(description = "Works with iframes")
    public void testIframes() {
        IFramesPage iframes = new IFramesPage();
        iframes.switchFrames(0);
        iframes.closeModal();
        iframes.clickNewsletter();
        iframes.getPageTitle();
        String iframeHeading = iframes.getPageHeading_1();
        assertEquals(iframeHeading, "SIGN UP FOR NATIONAL GEOGRAPHIC NEWSLETTERS", "Page heading does not match.");

        iframes.switchToDefaultFrame();
        String pageHeading = iframes.getPageTitle();
        assertTrue(pageHeading.contains("Iframes"), "Page heading does not match.");
    }

    @Test(description = "Works with iframes")
    public void testIframes_2() {
        IFramesPage iframes = new IFramesPage();
        iframes.switchFrames(1);
        iframes.clickSupport();
        String iframeHeading = iframes.getPageHeading_2();
        assertTrue(iframeHeading.contains("Getting Help"), "Page heading does not match.");

        iframes.switchToDefaultFrame();
        String pageHeading = iframes.getPageTitle();
        assertTrue(pageHeading.contains("Iframes"), "Page heading does not match.");
    }
}
