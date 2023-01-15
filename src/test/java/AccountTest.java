import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ClientPage;
import pages.LoginPage;
import pages.MainPage;
import user.User;
import user.UserClient;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static pages.ClientPage.PROFILE_URL;
import static pages.LoginPage.LOGIN_URL;
import static pages.MainPage.MAIN_URL;

public class AccountTest {

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
    @DisplayName("Переход по клику в личный кабинет")
    public void accountTest() {
        mainPage.clickButtonPersonalAccount();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();

        mainPage.clickButtonPersonalAccount();
        webdriver().shouldHave(url(PROFILE_URL));
    }

    @Test
    @DisplayName("Переход по клику на `Конструктор`")
    public void constructorFromAccountTest() {
        mainPage.clickButtonPersonalAccount();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();
        mainPage.clickButtonPersonalAccount();

        ClientPage profilePage = page(ClientPage.class);
        profilePage.clickConstructorButton();
        webdriver().shouldHave(url(MAIN_URL));
    }

    @Test
    @DisplayName("Переход по клику на логотип")
    public void constructorLogoClickInAccountTest() {
        mainPage.clickButtonPersonalAccount();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();
        mainPage.clickButtonPersonalAccount();

        ClientPage profilePage = page(ClientPage.class);
        profilePage.clickLogoImage();
        webdriver().shouldHave(url(MAIN_URL));
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void exitAccountTest() {
        mainPage.clickButtonPersonalAccount();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();
        mainPage.clickButtonPersonalAccount();

        ClientPage profilePage = page(ClientPage.class);
        profilePage.clickExitButton();
        webdriver().shouldHave(url(LOGIN_URL));
    }

    @After
    public void tearDown() {
        if (auth != null) {
            userClient.deletUser(auth);
        }
    }
}
