package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RecoverPage {

    public static final String RECOVER_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    // Кнопка Восстановить
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Восстановить')]")
    private SelenideElement buttonRecover;

    // Кнопка Войти
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Войти')]")
    private SelenideElement buttonEnter;


    @Step("Click button 'Войти'")
    public LoginPage clickEnterButton () {
        buttonEnter.click();
        return page(LoginPage.class);
    }
}
