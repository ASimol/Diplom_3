import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegPage;
import user.User;
import user.UserClient;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private User user;
    private UserClient userClient;
    private MainPage mainPage;
    private String auth;

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        //тест в другом браузере: Configuration.browser = "edge";
        userClient = new UserClient();
        user = User.getRandom();
        mainPage = open(MainPage.MAIN_URL, MainPage.class);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegTest() {
        mainPage.clickButtonEnterAccount();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegButton();

        RegPage registrationPage = page(RegPage.class);
        registrationPage.nameEnter(user.getName());
        registrationPage.emailEnter(user.getEmail());
        registrationPage.passwordEnter(user.getPassword());
        registrationPage.register();
        Assert.assertEquals("Url отличается от ожидаемого", LoginPage.LOGIN_URL, url());
        Assert.assertEquals("Статус код отличается от ожидаемого", userClient.loginUser(user).extract().statusCode(), 200);
        auth = userClient.loginUser(user).extract().body().path("accessToken");
    }

    @Test
    @DisplayName("Ошибка регистрации, пароль меньше 6 символов")
    public void errorFieldPasswordTest() {
        mainPage.clickButtonEnterAccount();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegButton();

        RegPage registrationPage = page(RegPage.class);
        registrationPage.nameEnter(user.getName());
        registrationPage.emailEnter(user.getEmail());
        registrationPage.passwordEnter(RandomStringUtils.randomAlphabetic(5));
        registrationPage.register();
        if (userClient.loginUser(user).extract().statusCode() == 200) {
            auth = userClient.loginUser(user).extract().body().path("accessToken");

        }
        assertTrue("Error not displayed", registrationPage.errorPassword());
    }

    @After
    public void tearDown() {
        if (auth != null) {
            userClient.deletUser(auth);
        }
    }
}