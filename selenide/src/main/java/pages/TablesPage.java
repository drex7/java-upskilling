package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TablesPage {

//    private final By disabledNextBtn = By.cssSelector(".paginate_button.next.disabled");

    private final SelenideElement search = $(".dataTables_filter input");

    public TablesPage navigateToPage() {
        $(By.linkText("Tables")).click();
        return this;
    }

    public void sortByCountry() {
//        scrollBy(0, 550);
        $(".column-2.sorting").click();
//        waitToBeClickableAndClick(this.countrySort);
    }




    public String getPopulation(String country) {
        boolean foundCountry = false;

        while (!foundCountry) {
            ElementsCollection countryListOnCurerntPage = $$(By.xpath("//table[@id='tablepress-1']//td[normalize-space()='" + country + "']"));
            ElementsCollection disabledNextBtns = $$(".paginate_button.next.disabled");

            if (!countryListOnCurerntPage.isEmpty()) {
                foundCountry = true;
            } else if (disabledNextBtns.isEmpty()) {
                $(By.xpath("//a[normalize-space()='Next']")).click();
//                scrollIntoViewAndClick(nextBtn);
            } else {
                return "-1";
            }
        }

        return $(By.xpath("//td[normalize-space()='" + country + "']//following-sibling::td")).getText();
    }

    public void searchForCountry(String country) {
        this.search.sendKeys(country);
    }

    public String getPopulationBySearch(String country) {
        this.search.clear();
        this.search.sendKeys(country);
        ElementsCollection countryFound = $$(By.xpath("//td[normalize-space()='" + country + "']//following-sibling::td"));
        if (countryFound.isEmpty()) {
            return "-1";
        }
        return countryFound.get(0).getText();
    }

    public String getItemPrice(String item) {
        return $(By.xpath("//td[text()='" + item + "']/following-sibling::td")).getText();
    }
}
