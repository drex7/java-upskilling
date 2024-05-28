package com.drex.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarsPage extends BasePage {

    @FindBy(linkText = "Calendars")
    private WebElement calenderLink;

    @FindBy(xpath = "//span[@class='ui-datepicker-year']")
    private WebElement calendarYear;
    @FindBy(xpath = "//span[@class='ui-datepicker-month']")
    private WebElement calendarMonth;

    @FindBy(id = "g1065-selectorenteradate")
    private WebElement calendarField;

    @FindBy(id = "contact-form-success-header")
    private WebElement dateMessage;

    @FindBy(xpath = "//button[text()='Submit'")
    private WebElement submitBtn;

    @FindBy(xpath = "//a[@title='Next']")
    private WebElement calendarRightArrow;


    public void clickCalendars() {
        this.calenderLink.click();
    }


    public void setDate(String month, String day, String year) {
//        month
        calendarField.click();

        while (true) {
            String currentMonth = calendarMonth.getText();
            String currentYear = calendarYear.getText();
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            calendarRightArrow.click();
        }

        click(By.xpath("//table//a[text()='" + day + "']"));
    }

    public String getDate() {
        return getFieldText(calendarField);
    }

    public void submitDate() {
        this.submitBtn.click();
    }

    public boolean isMessageDisplayed(String message) {
        return waitForElementByText(this.dateMessage, message);
    }
}
