package com.drex.pages;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FormFieldsPage extends BasePage {


	@FindBy(partialLinkText = "form-fields") 
	private WebElement pageTitle;
	
	@FindBy(linkText = "Form Fields")
	private WebElement formFieldsLink;

	@FindBy(css = "[data-cy='name']")
	private WebElement name;

	@FindBy(name = "fav_drink")
	private List<WebElement> favDrinkOptions;

	@FindBy(name = "fav_color")
	private List<WebElement> favColors;

	@FindBy(id = "siblings")
	private WebElement siblings;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "message")
	private WebElement message;

	@FindBy(id = "submit-btn")
	private WebElement submitBtn;

	public FormFieldsPage() {
		navigateToFormFieldsPage();
	}

	public void navigateToFormFieldsPage() {
		this.formFieldsLink.click();
	}

	public void fillName(String name) {
		this.getCustomWait().until(ExpectedConditions.visibilityOf(this.name));
		this.name.clear();
		this.name.sendKeys(name);
	}

	public void fillEmail(String email) {
		this.getCustomWait().until(ExpectedConditions.visibilityOf(this.email));
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void fillMessage(String message) {
		this.getCustomWait().until(ExpectedConditions.visibilityOf(this.message));
		this.message.clear();
		this.message.sendKeys(message);
	}

	public void clickSubmit() {
		this.submitBtn.click();
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
		return this.getDriver().findElement(By.xpath("//input[@value='" + option + "']")).isSelected();
	}

	public void checkSingleField(String option) {
		this.getDriver().findElement(By.xpath("//input[@value='" + option + "']")).click();
	}

	public void selectfavDrinkOptions(List<String> options) {
        HashSet<String> optionsSet = new HashSet<>(options);
        for (WebElement checkbox : favDrinkOptions) {
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
        for (WebElement radioElement : favColors) {
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
		return getFieldText(this.name);
	}

	public String getEmail() {
		return getFieldText(this.email);
	}

	public String getMessage() {
		return getFieldText(this.message);
	}

	public void selectSingleFromDropdown(String option) {
		Select dropDown = new Select(siblings);
		dropDown.selectByValue(option);
	}

	public String getSelectedDropdown() {
		return getFieldText(this.siblings);
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

	private boolean isOptionSelected(List<WebElement> options, String selectedOtion) {
		for (WebElement option : options) {
			String value = option.getAttribute("value");
			if (selectedOtion.contains(value)) return true;
		}
		return false;
	}
}
