package com.drex;

import com.drex.pages.SlidersPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SlidersTest extends BaseTest {
    @Test(description = "Test sliders")
    public void testSliders() {
        SlidersPage slidersPage = new SlidersPage();

        slidersPage.moveSlider(500, 0);
        String sliderValue = slidersPage.getSliderValue();
        System.out.println("position:: " + sliderValue);
        assertEquals(sliderValue, "50");
    }
}