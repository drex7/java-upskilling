package specs;

import org.testng.annotations.Test;
import pages.ModalsPage;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class ModalsTest extends BaseTest {

    @Test(description = "Open simple modal")
    public void test_simple_modal() throws InterruptedException {
        ModalsPage modalsPage = new ModalsPage();
        modalsPage
                .navigateToPage()
                .openSimpleModal();

        assertTrue(modalsPage.isModalOpened());
        modalsPage.closeSimpleModal();
        assertTrue(modalsPage.isModalClosed());
    }

    @Test(description = "Open and submit form modal")
    public void test_form_modal() {
        ModalsPage modalsPage = new ModalsPage();
        modalsPage
                .navigateToPage()
                .openFormModal()
                .sendMessage(
                        "Joshua",
                        "josh@mail.com",
                        "Good to be here."
                );



    }
}
