package com.drex;

import com.drex.pages.PopupPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class PopupsTest extends BaseTest {

    @Test(description = "Test handling of alert popup")
    public void test_alert_popup() {
        PopupPage popupPage = new PopupPage();

        popupPage.clickAlert();
        String text = popupPage.getPopupText();
        assertEquals("Hi there, pal!", text);
        popupPage.acceptPopup();
    }

    @Test(description = "Test clicking on OK on confirm popup")
    public void test_confirm_popup_ok() {
        PopupPage popupPage = new PopupPage();

        popupPage.clickConfirmButton();
        String text = popupPage.getPopupText();
        assertEquals("OK or Cancel, which will it be?", text);
        popupPage.acceptPopup();

        String result = popupPage.getConfirmPopupResult();
        assertEquals(result, "OK it is!");
    }

    @Test(description = "Test clicking on Cancel on confirm popup")
    public void test_confirm_popup_cancel() {
        PopupPage popupPage = new PopupPage();

        popupPage.clickConfirmButton();
        String text = popupPage.getPopupText();
        assertEquals("OK or Cancel, which will it be?", text);
        popupPage.dismissPopup();

        String result = popupPage.getConfirmPopupResult();
        assertEquals(result, "Cancel it is!");
    }

    @Test(description = "Test clicking on OK on prompt popup")
    public void test_prompt_popup_cancel() {
        String name = "Agogoli";
        PopupPage popupPage = new PopupPage();

        popupPage.clickPromptButton();
        String text = popupPage.getPopupText();
        assertEquals("Hi there, what's your name?", text);
        popupPage.fillName(name);
        popupPage.acceptPopup();

        String result = popupPage.getPromptPopupResult();
        assertTrue(result.contains("Nice to meet you, " + name));
    }

    @Test(description = "Test clicking on Cancel on prompt popup")
    public void test_prompt_popup_ok() {
        String name = "Kramer";
        PopupPage popupPage = new PopupPage();

        popupPage.clickPromptButton();
        String text = popupPage.getPopupText();
        assertEquals("Hi there, what's your name?", text);
        popupPage.fillName(name);
        popupPage.dismissPopup();

        String result = popupPage.getPromptPopupResult();
        assertTrue(result.contains("Fine, be that way"));
    }

    @Test(description = "Test tooltip")
    public void test_tooltip() {
        String name = "Kramer";
        PopupPage popupPage = new PopupPage();

        popupPage.clickToolip();
        assertTrue(popupPage.waitForTooltip("Cool text"));
        popupPage.clickToolip();
        assertFalse(popupPage.waitForTooltip("Cool text"));
        popupPage.fillName(name);
        popupPage.dismissPopup();
    }
}
