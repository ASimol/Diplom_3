package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegPage {

    // локатор поля "Имя"
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement nameField;

    // локатор поля "Email"
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement emailField;

    // поле "Пароль"
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordField;

    //кнопка "Войти"
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement buttonEnterReg;

    //кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement buttonRegistration;

    // ошибка "Некорректный пароль"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Некорректный пароль')]")
    private SelenideElement errorPassword;

    //заполняем Имя
    public void nameEnter(String name) {
        nameField.click();
        nameField.setValue(name);
    }

    //заполняем Email
    public void emailEnter(String email) {
        emailField.click();
        emailField.setValue(email);
    }

    //заполняем Пароль
    public void passwordEnter(String password) {
        passwordField.click();
        passwordField.setValue(password);
    }

    //клик по кнопке Зарегистрироваться
    public void register() {
        buttonEnterReg.click();
    }

    //сообщение об ошибке
    public boolean errorPassword() {
        return errorPassword.isDisplayed();
    }

    //клик по кнопке Войти
    public LoginPage clickEnterReg() {
        buttonEnterReg.click();
        return page(LoginPage.class);
    }
}
