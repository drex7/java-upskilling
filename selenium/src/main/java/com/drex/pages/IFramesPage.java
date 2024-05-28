package com.drex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramesPage extends BasePage {


    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"search-form\"]/fieldset/button/i")
    private WebElement magnifyingGlass;

    @FindBy(css = ".entry-title")
    private WebElement pageHeading;

    public void wikiSearch(String searchQuery) {
        this.searchBox.sendKeys("test automation");
        this.magnifyingGlass.click();
    }

    public String getPageHeading() {
        return getFieldText(pageHeading);
    }
}
