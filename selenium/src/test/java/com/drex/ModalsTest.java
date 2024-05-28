package com.drex;

import com.drex.pages.ModalsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ModalsTest extends BaseTest {

    @Test(description = "Open simple modal")
    public void test_simple_modal() {
        ModalsPage modalsPage = new ModalsPage();
        modalsPage.openSimpleModal();
        assertTrue(modalsPage.isModalOpened());
        modalsPage.closeSimpleModal();
        assertFalse(modalsPage.isModalOpened());
    }

    @Test(description = "Open and submit form modal")
    public void test_form_modal() {
        ModalsPage modalsPage = new ModalsPage();
        modalsPage.openFormModal()
                .sendMessage(
                        "Joshua",
                        "josh@mail.com",
                        "Good to be here."
                );



    }
}
