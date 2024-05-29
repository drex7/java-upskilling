package com.drex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SlidersPage extends BasePage {


    @FindBy(linkText = "Sliders")
    private WebElement slidersLink;

    @FindBy(id = "slideMe")
    private WebElement slider;

    @FindBy(id = "value")
    private WebElement sliderValue;


    public SlidersPage() {
        scrollIntoViewAndClick(this.slidersLink);
        waitForPageTitle("Slider");
    }

    public void moveSlider(int x, int y) {
//        System.out.println("slider:: " + this.slider);
//        this.slider.click();
        int width = slider.getSize().getWidth();
        getActions().moveToElement(this.slider, (width/2) - 100, 0).click().build().perform();
    }

    public String getSliderValue() {
        return getFieldText(this.sliderValue);
    }
}
