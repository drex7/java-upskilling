package pages.utils;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Util {

    public static void waitForPageTitle(String title) {

    }

    public static void switchFrames(int index) {
        switchTo().frame(index);
    }

    public static String getPageTitle() {
        return Selenide.title();
    }

    public static String getPopupText() { return switchTo().alert().getText();}

    public static void acceptPopup() {
        switchTo().alert().accept();
    }

}
