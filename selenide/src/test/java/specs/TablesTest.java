package specs;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TablesPage;

import java.util.Arrays;
import java.util.HashMap;

import static org.testng.Assert.*;

public class TablesTest extends BaseTest {

    TablesPage tablesPage;

    @BeforeMethod
    public void gotoPage() {
        tablesPage = new TablesPage();
        tablesPage.navigateToPage();
    }


    @DataProvider(name = "tableItems")
    public Object[][] getTableItems() {
        return new Object[][] {
                {"Laptop", "$1200.00"},
                {"Marbles", "$1.25"},
                {"Oranges", "$3.99"}
        };
    }

    @Test(description = "Finds the price of an item on a table")
    public void test_item_price() {

        HashMap<String, String> tableItems = new HashMap<>(){{
            put("Laptop", "$1200.00");
            put("Marbles", "$1.25");
            put("Oranges", "$3.99");
        }};

        for (String item : tableItems.keySet() ) {
            String itemPrice = tablesPage.getItemPrice(item);
            assertEquals(itemPrice, tableItems.get(item), "Item's price was incorrect");

        }
    }

    @DataProvider(name = "countryPopulation")
    public Object[][] getPopulation() {
        return new Object[][] {
                {"Nigeria", "223.8"},
                {"Indonesia", "277.5"},
                {"United States", "340"}
        };
    }

    @Test(description = "Get population using pagination", dataProvider = "countryPopulation")
    public void test_pagination_search(String country, String population) {
        tablesPage.sortByCountry();
        String populationNG = tablesPage.getPopulation(country);
        assertEquals(populationNG, population);
        assertNotEquals(populationNG, "-1", "The country was not found on list!");
    }


    @Test(description = "Get population using pagination")
    public void test_search() {
        tablesPage.sortByCountry();

        for (Object[] countryData : getPopulation()) {
            String country = (String) countryData[0];
            String populationNG = tablesPage.getPopulationBySearch(country);
            assertNotEquals(populationNG, "-1", "The country was not found on list!");
        }

//        String populationGH = tablesPage.getPopulationBySearch("Ghana");
//        assertEquals(populationGH, "-1", "The country was not found on list!");
    }

}
