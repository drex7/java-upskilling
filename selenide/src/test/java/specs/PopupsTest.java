package specs;

import org.testng.annotations.DataProvider;
import pages.PopupPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class PopupsTest extends BaseTest {

    @Test(description = "Test handling of alert popup")
    public void test_alert_popup() {
        PopupPage popupPage = new PopupPage();

        popupPage
                .navigateToPage()
                .clickAlert()
                .assertPopupText("Hi there, pal!");

        popupPage.acceptPopup();
    }

    @Test(description = "Test clicking on OK on confirm popup")
    public void test_confirm_popup_ok() {
        PopupPage popupPage = new PopupPage();

        popupPage
                .navigateToPage()
                .clickConfirmButton()
                .assertPopupText("OK or Cancel, which will it be?");

        popupPage.acceptPopup();

        String result = popupPage.getConfirmPopupResult();
        assertEquals(result, "OK it is!");
    }

    @Test(description = "Test clicking on Cancel on confirm popup")
    public void test_confirm_popup_cancel() {
        PopupPage popupPage = new PopupPage();
        popupPage
                .navigateToPage()
                .clickConfirmButton()
                .assertPopupText("OK or Cancel, which will it be?");

        popupPage.dismissPopup();
        String response = popupPage.getConfirmPopupResult();
        assertEquals(response, "Cancel it is!");
    }

    @DataProvider(name = "names")
    public Object[][] getNames() {
        return new Object[][] {
                {"Larry"},
                {"Johnson"}
        };
    }

    @Test(description = "Test clicking on OK on prompt popup", dataProvider = "names")
    public void test_prompt_popup_cancel(String name) {
        PopupPage popupPage = new PopupPage();
        popupPage
                .navigateToPage()
                .clickPromptButton()
                .assertPopupText("Hi there, what's your name?");

        popupPage.submitName(name);
        String response = popupPage.getPromptPopupResult();
        assertEquals(response, String.format("Nice to meet you, %s!", name));
    }

    @Test(description = "Test tooltip")
    public void test_tooltip() {
        PopupPage popupPage = new PopupPage();
        popupPage
                .navigateToPage()
                .clickToolip();

        assertTrue(popupPage.waitForTooltip("Cool text"));
        popupPage.clickToolip();
        assertFalse(popupPage.waitForTooltip("Cool text"));
    }
}
