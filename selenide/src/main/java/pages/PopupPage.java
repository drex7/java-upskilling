package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.testng.Assert.assertEquals;

public class PopupPage {

    private SelenideElement tooltip = $(".tooltip_1");

    public PopupPage navigateToPage() {
        $(By.linkText("Popups")).click();
        return this;
    }

    public PopupPage clickAlert() {
        $(By.id("alert")).click();
//        this.alertButton.click();
        return this;
    }

    public PopupPage clickConfirmButton() {
        $(By.id("confirm")).click();
        return this;
    }

    public PopupPage clickPromptButton() {
        $(By.id("prompt")).click();
        return this;
    }


    public PopupPage clickToolip() {
        this.tooltip.click();
        return this;
    }

    public PopupPage submitName(String text) {
        switchTo().alert().sendKeys(text);
        this.acceptPopup();
        return this;
    }


    public String getConfirmPopupResult() {
        return $(By.id("confirmResult")).should(appear).getText();
    }

    public String getPromptPopupResult() {
        return  $(By.id("promptResult")).should(appear).getText();
    }

    public boolean waitForTooltip(String text) {
        return $(By.id("myTooltip")).isDisplayed();
//        return Wait().until(textToBePresentInElement(tooltip, text));
//        tooltip.shouldHave(text(text));
    }

    public void assertPopupText(String text) {
        String alertText = switchTo().alert().getText();
        assertEquals(alertText, text);
    }

    public void acceptPopup() {
        switchTo().alert().accept();
    }

    public void dismissPopup() {
        switchTo().alert().dismiss();
    }

}
