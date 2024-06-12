package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SlidersPage {

    private SelenideElement slider = $(By.id("slideMe"));

    public SlidersPage navigateToPage() {
        $(By.linkText("Sliders")).click();
        return this;
    }

    public void moveSlider(int x, int y) {
        int width = slider.getSize().getWidth();
        int slope = 100 / width;
        int moveToZero = -(width/2);
        int moveAmount = (int) (slope * width * 0.5);
//        actions().moveToElement(slider, moveAmount, 0).click().perform();
        System.out.println("\n\n before slider value:: " + this.getSliderValue());
        actions()
                .moveToElement(slider)
                .click()
                .dragAndDropBy(slider, moveToZero, 0)
                .perform();
        sleep(5_000);
        System.out.println("location x:: " + this.slider.getLocation().getX());
        System.out.println("\n\n after slider value:: " + this.getSliderValue());
    }

    public void clickMiddle() {
        slider.click();
    }

    public String getSliderValue() {
        return $(By.id("value")).getText();
    }
}
