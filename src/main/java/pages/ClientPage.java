package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ClientPage {
    public static final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    // локатор поля "Имя"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Имя')]")
    private SelenideElement fieldOfName;

    // локатор поля "Логин"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Логин')]")
    private SelenideElement fieldOfLogin;

    // поле поля "Пароль"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Пароль')]")
    private SelenideElement fieldOfPassword;

    // кнопка "Профиль"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Профиль')]")
    private SelenideElement buttonProfile;

    // кнопка "История заказов"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'История заказов')]")
    private SelenideElement buttonHistoryOrders;

    // кнопка "Выход"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Выход')]")
    private SelenideElement buttonExit;

    // кнопка "Сохранить"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Сохранить')]")
    private SelenideElement buttonSave;

    // кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Конструктор')]")
    private SelenideElement buttonConstructor;

    // логотип "StellarBurgers"
    @FindBy(how = How.XPATH, using = "//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    // методы
    @Step("Установка значения имени")
    public ClientPage setNameField(String name) {
        fieldOfName.setValue(name);
        return this;
    }

    @Step("Установка знаничения логина")
    public ClientPage setLoginField(String login) {
        fieldOfLogin.setValue(login);
        return this;
    }

    @Step("Установка значения пароля")
    public ClientPage setPasswordField(String password) {
        fieldOfPassword.setValue(password);
        return this;
    }

    @Step("Клик на кнопку 'Профиль'")
    public ClientPage clickProfileButton() {
        buttonProfile.click();
        return this;
    }

    @Step("Клик на кнопку 'Выход'")
    public LoginPage clickExitButton() {
        buttonExit.click();
        return page(LoginPage.class);
    }

    @Step("Клик на кнопку 'Сохранить'")
    public ClientPage clickSaveButton() {
        buttonProfile.click();
        return this;
    }

    @Step("Клик на кнопку 'Конструктор'")
    public MainPage clickConstructorButton() {
        buttonConstructor.click();
        return page(MainPage.class);
    }

    @Step("Клик на лого")
    public MainPage clickLogoImage() {
        logo.click();
        return page(MainPage.class);
    }
}
