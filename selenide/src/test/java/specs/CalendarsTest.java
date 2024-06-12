package specs;

import org.testng.annotations.DataProvider;
import pages.CalendarsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CalendarsTest extends BaseTest {

    @DataProvider(name = "dates")
    public Object[][] getDates() {
        return new Object[][] {
                {"2009-12-25"},
                {"2025-02-05"},
                {"1998-09-16"}
        };
    }

    @Test(description = "Select date from date picker", dataProvider = "dates")
    public void testEnterText(String inputDate) {
//        2020-11-26
        String[] dateArray = inputDate.split(" ");
        CalendarsPage calendarsPage = new CalendarsPage();
        calendarsPage
                .navigateToPage()
                .submitDate(inputDate);
        String date = calendarsPage.getDate();
        assertEquals(inputDate, date);
        assertTrue(calendarsPage.isMessageDisplayed("Your message has been sent"));
    }
}
