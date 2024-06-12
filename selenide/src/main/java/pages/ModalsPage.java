package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ModalsPage {

    private SelenideElement modalHeading = $(By.id("pum_popup_title_1318"));

    public ModalsPage navigateToPage() {
        $(By.partialLinkText("Modals")).click();
        return this;
    }

    public ModalsPage openModal() {
        $(By.id("formModal")).scrollTo().click();
        return this;
    }

    public ModalsPage sendMessage(String name, String email, String message) {
        $(By.id("g1051-name")).val(name);
        $(By.id("g1051-email")).val(email);
        $(By.id("contact-form-comment-g1051-message")).val(message);
        $(By.xpath("//button[normalize-space()='Submit']")).click();
        return this;
    }

    public void openSimpleModal() {
        $(By.id("simpleModal")).click();
    }


    public ModalsPage openFormModal() {
        $(By.id("formModal")).click();
        $(By.id("pum_popup_title_674")).shouldBe(visible);
        return this;
    }

    public boolean isModalOpened() {

        modalHeading.shouldBe(visible);
        return true;
//        return modalHeading.is(visible);
//        return modalHeading.isDisplayed();
    }

    public boolean isModalClosed() {

        modalHeading.shouldNotBe(visible);
        return true;
    }

    public void closeSimpleModal() {
        $(By.xpath("//div[@id='popmake-1318']//button[@aria-label='Close'][normalize-space()='×']")).click();
    }

}
