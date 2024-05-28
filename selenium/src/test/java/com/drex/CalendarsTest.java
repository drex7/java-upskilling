package com.drex;

import com.drex.pages.CalendarsPage;
import com.drex.pages.FormFieldsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CalendarsTest extends BaseTest {

    @Test(description = "Select date from date picker")
    public void testEnterText() {
        String inputDate = "August 29 2009";
        CalendarsPage calendarsPage = new CalendarsPage();
        calendarsPage.setDate("August", "29", "2009");
        String date = calendarsPage.getDate();
        assertEquals(inputDate, date);
        assertTrue(calendarsPage.isMessageDisplayed("Your message has been sent"));
    }
}
