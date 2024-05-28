package com.drex;

import com.drex.pages.BasePage;
import com.drex.pages.IFramesPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IFramesTest extends BasePage {
    @Test(description = "Works with iframes")
    public void testIframes() {
        IFramesPage iframes = new IFramesPage();
        switchFrames(0);
        iframes.wikiSearch("test automation");
        switchToDefaultFrame();
        String pageHeading = iframes.getPageHeading();
        assertEquals(pageHeading, "IFrames", "Page heading does not match.");
    }
}
