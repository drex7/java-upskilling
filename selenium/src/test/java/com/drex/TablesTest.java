package com.drex;

import com.drex.pages.ModalsPage;
import com.drex.pages.TablesPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TablesTest extends BaseTest {

    @Test(description = "Finds the price of an item on a table")
    public void test_item_price() {
        TablesPage tablesPage = new TablesPage();
        String itemPrice = tablesPage.getItemPrice("Laptop");
        assertEquals(itemPrice, "$1200.00", "Laptop price was incorrect");

        itemPrice = tablesPage.getItemPrice("Oranges");
        assertEquals(itemPrice, "$3.99", "Oranges price was incorrect");
    }

    @Test(description = "Get population using pagination")
    public void test_pagination_search() {
        TablesPage tablesPage = new TablesPage();
        tablesPage.sortByCountry();
        String populationNG = tablesPage.getPopulation("Nigeria");
        assertNotEquals(populationNG, "-1", "The country was not found on list!");
    }


    @Test(description = "Get population using pagination")
    public void test_search() {
        TablesPage tablesPage = new TablesPage();
        tablesPage.sortByCountry();
        String populationNG = tablesPage.getPopulationBySearch("Nigeria");
        assertNotEquals(populationNG, "-1", "The country was not found on list!");

        String populationGH = tablesPage.getPopulationBySearch("Ghana");
        assertEquals(populationGH, "-1", "The country was not found on list!");
    }

}
