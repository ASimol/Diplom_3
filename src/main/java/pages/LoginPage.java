package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";


    // Локатор поля Email
    @FindBy(how = How.XPATH, using = ".//input[@name ='name']")
    private SelenideElement emailField;

    // Локатор поля Пароль
    @FindBy(how = How.XPATH, using = ".//input[@name ='Пароль']")
    private SelenideElement passwordField;

    // кнопка Войти
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Войти')]")
    private SelenideElement enterButton;

    // кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Зарегистрироваться')]")
    private SelenideElement buttonRegistration;

    // кнопка Восстановить пароль
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Восстановить')]")
    private SelenideElement recoverPassword;

    @Step("Заполняем email")
    public LoginPage setEmailField(String email){
        emailField.setValue(email);
        return this;
    }

    @Step("Заполняем password")
    public LoginPage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Нажимаем Войти")
    public MainPage clickEnterButton() {
        enterButton.click();
        return page(MainPage.class);
    }

    @Step("Нажимаем Зарегистрироваться")
    public RegPage clickRegistrationButton() {
        buttonRegistration.click();
        return page(RegPage.class);
    }

    @Step("Нажимаем Восстановить пароль")
    public RecoverPage clickRecoverButton() {
        recoverPassword.click();
        return page(RecoverPage.class);
    }
}
