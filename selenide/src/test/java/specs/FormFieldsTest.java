package specs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pages.FormFieldsPage;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import static pages.utils.Util.*;

public class FormFieldsTest extends BaseTest {

	FormFieldsPage formPage = null;

	@BeforeMethod
	public void goToPage() {
		formPage = new FormFieldsPage();
		formPage.navigateToFormFieldsPage();
	}


	@Test(description = "Verify the page title")
	public void testPageTitle() {
//		FormFieldsPage formPage = new FormFieldsPage();
		String title = getPageTitle();
		assertEquals("Form Fields | Practice Automation", title);
	}

	@DataProvider(name = "names")
	public Object[][] getNames() {
		return new Object[][] {
				{"Larry"},
				{"Johnson"},
				{"Kojo"}
		};
	}

	@Test(description = "Enters name in an input field", dataProvider = "names")
	public void testEnterText(String name) {
		formPage.fillName(name);
		String inputText = formPage.getName();
		 assertEquals(name, inputText);
	}


	@Test(description = "Checks a checkbox")
	public void testCheckbox() {
		List<String> favDrinks = Arrays.asList("Water", "Wine", "Tea");
		formPage.checkSingleField(favDrinks.get(0));
		assertFalse(formPage.isDrinkSelected(favDrinks.get(1)), "Checkbox is not checked");
	}

	@Test(description = "Selects from a sibling from dropdown")
	public void testSelectFromDropdown() {
		String option = "Yes";
		formPage.selectSingleFromDropdown(option);
		String selectedOption = formPage.getSelectedDropdown();
		assertEquals(option.toLowerCase(), selectedOption);
		assertNotEquals("No".toLowerCase(), selectedOption);
	}

	@Test(description = "Selects a color from radio button")
	public void testSelectRadioButton() {
		String radio1 = "Red";
		String radio2 = "Blue";
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
		formPage.fillEmail(email);
		String inputText = formPage.getEmail();
		assertEquals(email, inputText);
	}

	@Ignore
	@Test(description = "Enters message in a textarea field")
	public void testTextarea() {
		String email = "kojo@mail.com";
		formPage.fillMessage(email);
		String inputText = formPage.getMessage();
		assertEquals(email, inputText);
	}

	@Ignore
	@Test(description = "Enters message in a textarea field")
	public void test_submit_without_required_ame() {
		String name = "Godsway";
		formPage.fillEmail(name);
		formPage.clickSubmit();
	}

	@Ignore
	@Test(description = "Enters message in a textarea field")
	public void test_submit_with_required_ame() {
		String name = "Godsway";
		formPage.fillName(name);
		formPage.clickSubmit();

		String alertText = getPopupText();
		assertTrue(alertText.contains("Message received!"));

		acceptPopup();
	}


	
}
