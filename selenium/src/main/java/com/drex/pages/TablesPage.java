package com.drex.pages;

import com.google.common.base.Verify;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TablesPage extends BasePage {


    @FindBy(linkText = "Tables")
    private WebElement tablesLink;

    @FindBy(css = ".column-2.sorting")
    private WebElement countrySort;

//    @FindBy(css = ".paginate_button.next.disabled")
    private final By disabledNextBtn = By.cssSelector(".paginate_button.next.disabled");

    @FindBy(xpath = "//a[normalize-space()='Next']")
    private WebElement nextBtn;

    @FindBy(css = ".dataTables_filter input")
    private WebElement search;

    @SneakyThrows
    public TablesPage() {
        scrollIntoViewAndClick(this.tablesLink);
        waitForPageTitle("Tables");
    }

    @SneakyThrows
    public void sortByCountry() {
        scrollBy(0, 550);
        Thread.sleep(50);
        this.countrySort.click();
    }


    @SneakyThrows
    public String getPopulation(String country) {
        boolean foundCountry = false;

        while (!foundCountry) {
            List<WebElement> countryListOnCurerntPage = findDynamicElements(By.xpath("//table[@id='tablepress-1']//td[normalize-space()='" + country + "']"));
            List<WebElement> disabledNextBtns = findDynamicElements(disabledNextBtn);

            if (!countryListOnCurerntPage.isEmpty()) {
                foundCountry = true;
            } else if (disabledNextBtns.isEmpty()) {
                scrollIntoViewAndClick(nextBtn);
            } else {
                return "-1";
            }
        }

        return getFieldText(
                findDynamicElement(By.xpath("//td[normalize-space()='" + country + "']//following-sibling::td"))
        );
    }

    public void searchForCountry(String country) {
        this.search.sendKeys(country);
    }

    public String getPopulationBySearch(String country) {
        this.search.clear();
        this.search.sendKeys(country);
        List<WebElement> countryFound = findDynamicElements(By.xpath("//td[normalize-space()='" + country + "']//following-sibling::td"));
        if (countryFound.isEmpty()) {
            return "-1";
        }
        return getFieldText(countryFound.get(0));
    }

    public String getItemPrice(String item) {
        return findDynamicElement(By.xpath("//td[text()='" + item + "']/following-sibling::td")).getText();
    }
}
