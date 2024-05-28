package com.drex;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.drex.pages.FormFieldsPage;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FormFieldsTest extends BaseTest {

	@Ignore
	@Test(description = "Verify the page title")
	public void testPageTitle() {
		FormFieldsPage formPage = new FormFieldsPage();
//		formPage.navigateToFormFields();
		String title = formPage.getPageTitle();
		assertEquals("Form Fields | Practice Automation", title);
	}

	@Ignore
	@Test(description = "Enters name in an input field")
	public void testEnterText() {
		String name = "Godsway";
		FormFieldsPage formPage = new FormFieldsPage();
		formPage.fillName(name);
		String inputText = formPage.getName();
		 assertEquals(name, inputText);
	}


	@Test(description = "Checks a checkbox")
	public void testCheckbox() {
		FormFieldsPage formPage = new FormFieldsPage();
		List<String> favDrinks = Arrays.asList("Water", "Wine", "Tea");
		formPage.checkSingleField(favDrinks.get(0));
		assertTrue(formPage.isDrinkSelected(favDrinks.get(0)), "Checkbox is checked");
		assertFalse(formPage.isDrinkSelected(favDrinks.get(1)), "Checkbox is not checked");
	}

	@Ignore
	@Test(description = "Selects from a sibling from dropdown")
	public void testSelectFromDropdown() {
		String option = "Yes";
		FormFieldsPage formPage = new FormFieldsPage();
		formPage.selectSingleFromDropdown(option);
		String selectedOption = formPage.getSelectedDropdown();
		assertEquals(option, selectedOption, "Select option is selected");
		assertEquals("No", selectedOption, "Select option is not selected");
	}

	@Ignore
	@Test(description = "Selects a color from radio button")
	public void testSelectRadioButton() {
		String radio1 = "Red";
		String radio2 = "Blue";
		FormFieldsPage formPage = new FormFieldsPage();
		formPage.selectFavColor(radio1);
		assertTrue(formPage.isColorSelected(radio1));

		formPage.selectFavColor(radio2);
		assertTrue(formPage.isColorSelected(radio2));
		assertFalse(formPage.isColorSelected(radio1));
	}

	@Ignore
	@Test(description = "Enters email in an input field")
	public void testEmail() {
		String email = "kojo@mail.com";
		FormFieldsPage formPage = new FormFieldsPage();
		formPage.fillEmail(email);
		String inputText = formPage.getEmail();
		assertEquals(email, inputText);
	}

	@Ignore
	@Test(description = "Enters message in a textarea field")
	public void testTextarea() {
		String email = "kojo@mail.com";
		FormFieldsPage formPage = new FormFieldsPage();
		formPage.fillMessage(email);
		String inputText = formPage.getMessage();
		assertEquals(email, inputText);
	}

	@Ignore
	@Test(description = "Enters message in a textarea field")
	public void test_submit_without_required_ame() {
		String name = "Godsway";
		FormFieldsPage formPage = new FormFieldsPage();
		formPage.fillEmail(name);
		formPage.clickSubmit();
	}

	@Ignore
	@Test(description = "Enters message in a textarea field")
	public void test_submit_with_required_ame() {
		String name = "Godsway";
		FormFieldsPage formPage = new FormFieldsPage();
		formPage.fillName(name);
		formPage.clickSubmit();

		String alertText = formPage.getPopupText();
		assertTrue(alertText.contains("Message received!"));

		formPage.acceptPopup();
	}


	
}
