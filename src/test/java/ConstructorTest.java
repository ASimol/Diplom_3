import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static pages.MainPage.MAIN_URL;

public class ConstructorTest {

    private MainPage mainPage;

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        //тест в другом браузере: Configuration.browser = "edge";
        mainPage = open(MAIN_URL, MainPage.class);
    }

    @Test
    @DisplayName("Переход в раздел Булки")
    public void checkOfBunsButton() {
        MainPage main = open(MAIN_URL, MainPage.class);
        assertTrue("Block is invisible", main.clickButtonBunsAndCheck());
    }

    @Test
    @DisplayName("Переход в раздел Соусы")
    public void checkOfSaucesButton() {
        MainPage main = open(MAIN_URL, MainPage.class);
        assertTrue("Block is invisible", main.clickButtonSaucesAndCheck());
    }

    @Test
    @DisplayName("Переход в раздел Начинки")
    public void checkOfFillingButton() {
        MainPage main = open(MAIN_URL, MainPage.class);
        assertTrue("Block is invisible", main.clickButtonFillingAndCheck());
    }

}