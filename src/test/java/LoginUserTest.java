import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RecoverPage;
import pages.RegPage;
import user.User;
import user.UserClient;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static pages.MainPage.MAIN_URL;

public class LoginUserTest {

    private User user;
    private UserClient userClient;
    private String auth;
    private MainPage mainPage;

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        //тест в другом браузере: Configuration.browser = "edge";
        userClient = new UserClient();
        user = User.getRandom();
        ValidatableResponse response = userClient.userCreate(user);
        auth = response.extract().path("accessToken");
        mainPage = open(MAIN_URL, MainPage.class);
    }

    @Test
    @DisplayName("Вход по кнопке `Войти` на главной странице")
    public void enterButtonMainPageTest() {
        mainPage.clickButtonEnterAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();
        webdriver().shouldHave(url(MAIN_URL));
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void accountButtonMainPageTest() {
        mainPage.clickButtonPersonalAccount();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();
        webdriver().shouldHave(url(MAIN_URL));
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void enterButtonRegPageTest() {
        mainPage.clickButtonEnterAccount();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegButton();
        RegPage registrationPage = page(RegPage.class);
        registrationPage.clickEnterReg();

        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();
        webdriver().shouldHave(url(MAIN_URL));
    }

    @Test
    @DisplayName("Вход через кнопку востановления пароля")
    public void enterFromRecoverPageTest() {
        mainPage.clickButtonEnterAccount();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRecoverButton();
        RecoverPage recoverPage = page(RecoverPage.class);
        recoverPage.clickEnterButton();

        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();
        webdriver().shouldHave(url(MAIN_URL));
    }

    @After
    public void tearDown() {
        if (auth != null) {
            userClient.deletUser(auth);
        }
    }
}