package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CalendarsPage {

    public CalendarsPage navigateToPage() {
        $(By.linkText("Calendars")).click();
        return this;
    }

    public void submitDate(String date) {
        $(By.id("g1065-selectorenteradate")).setValue(date);
        $(By.xpath( "//button[text()='Submit']")).click();
    }

    public String getDate() {
        return $(".field-value").getText();
    }

    public boolean isMessageDisplayed(String message) {
        return $(By.id("contact-form-success-header")).shouldHave(text(message)).isDisplayed();
    }
}
