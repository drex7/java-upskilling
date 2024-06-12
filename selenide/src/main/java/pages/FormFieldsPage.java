package pages;

import java.util.HashSet;
import java.util.List;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FormFieldsPage {

	private SelenideElement name = $("[data-cy='name']");

	private ElementsCollection favDrinkOptions = $$(By.name("fav_drink"));

	private ElementsCollection favColors = $$(By.name("fav_color"));

	private SelenideElement siblings = $(By.id("siblings"));

	private SelenideElement email = $(By.id("email"));

	private SelenideElement message = $(By.id("message"));

	public FormFieldsPage navigateToFormFieldsPage() {
		$(By.linkText("Form Fields")).click();
		return this;
	}

	public void fillName(String name) {
//		this.getCustomWait().until(ExpectedConditions.visibilityOf(this.name));
		this.name.clear();
		this.name.sendKeys(name);
	}

	public void fillEmail(String email) {
//		this.getCustomWait().until(ExpectedConditions.visibilityOf(this.email));
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void fillMessage(String message) {
//		this.getCustomWait().until(ExpectedConditions.visibilityOf(this.message));
		this.message.clear();
		this.message.sendKeys(message);
	}

	public void clickSubmit() {
		$(By.id("submit-btn")).click();
	}

	public static String getPageTitle() {
		return $("title").getText();
	}
//	public String getPopText() {
//		return this.getMessage();
//	}

	public void selectMultipleCheckbox(String option) {
		favDrinkOptions.forEach(drink -> {
			if (drink.getText().equalsIgnoreCase(option)) {
				drink.click();
			} else {
				throw new NoSuchElementException(String.format("%s is not an option", option));
			}
		});
	}

	public boolean isCheckboxSelected(String option) {
		return $(By.xpath("//input[@value='" + option + "']")).isSelected();
	}

	public void checkSingleField(String option) {
		$(By.xpath("//input[@value='" + option + "']")).click();
	}

	public void selectfavDrinkOptions(List<String> options) {
        HashSet<String> optionsSet = new HashSet<>(options);
        for (SelenideElement checkbox : favDrinkOptions) {
            String value = checkbox.getAttribute("value");
            if (optionsSet.contains(value) && !checkbox.isSelected()) {
                checkbox.click();
            } 
			// else if (!optionsSet.contains(value) && checkbox.isSelected()) {
            //     checkbox.click();  // Uncheck if already checked but not in options
			// }
        }
    }

	public void selectFavColor(String option) {
        for (SelenideElement radioElement : favColors) {
            String value = radioElement.getAttribute("value");
            if (option.contains(value) && !radioElement.isSelected()) {
                radioElement.click();
            } 
        }
    }

	public void selectSibling(String sibling) {
		new Select(siblings).selectByValue(sibling);
	}

	public String getName() {
		return this.name.getValue();
	}

	public String getEmail() {
		return this.email.getValue();
	}

	public String getMessage() {
		return this.message.getValue();
	}

	public void selectSingleFromDropdown(String option) {
//		Select dropDown = new Select(siblings);
		siblings.selectOption(option);
//		dropDown.selectOption(option);
	}

	public String getSelectedDropdown() {
		return this.siblings.getValue();
	}

	public boolean isColorSelected(String color) {
		return isOptionSelected(favColors, color);
	}

//	public boolean isSiblingSelected(String option) {
//		return getSelectedDropdown();
//	}

	public boolean isDrinkSelected(String option) {
		return isOptionSelected(favDrinkOptions, option);
	}

	private boolean isOptionSelected(ElementsCollection options, String selectedOtion) {
		for (SelenideElement option : options) {
			if(option.isSelected() && option.getValue().equalsIgnoreCase(selectedOtion)) {
				System.out.println("checked:: " + option.isSelected());
				return true;
			}
		}
		return false;
	}
}
