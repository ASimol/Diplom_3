package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    //Кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement buttonAccountEnter;
    //Кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement buttonPersonalAccount;
    //Кнопка "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement buttonBuns;
    //Заголовок "Булки" для верефикации
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement signBuns;
    //Кнопка "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement buttonSauces;
    //Заголовок "Соусы" для верефикации
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement signSauces;
    //Кнопка "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement buttonFillings;
    //Заголовок "Начинки" для верефикации
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement signFillings;
    //Последний элемент в конструкторе для проверки переходов
    @FindBy(how = How.XPATH, using = "//p[text()='Сыр с астероидной плесенью']")
    private SelenideElement lastIngredient;
    //Корзина для создания заказа
    @FindBy(how = How.CLASS_NAME, using = "BurgerConstructor_basket__list__l9dp_")
    private SelenideElement basketOrder;
    //Элемент из раздела булок для drag and drop
    @FindBy(how = How.XPATH, using = ".//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement bunForDrop;
    //Отображение булки после перемещения в корзину
    @FindBy(how = How.XPATH, using = ".//span[text()='Флюоресцентная булка R2-D3 (верх)']")
    private SelenideElement bunInBasket;
    //Элемент из раздела соусов для drag and drop
    @FindBy(how = How.XPATH, using = ".//p[text()='Соус Spicy-X']")
    private SelenideElement sauceForDrop;
    //Отображение соуса после перемещения в корзину
    @FindBy(how = How.XPATH, using = ".//span[text()='Соус Spicy-X']")
    private SelenideElement sauceInBasket;
    //Элемент из раздела начинок для drag and drop
    @FindBy(how = How.XPATH, using = ".//p[text()='Хрустящие минеральные кольца']")
    private SelenideElement fillingForDrop;
    //Отображение начинки после перемещения в корзину
    @FindBy(how = How.XPATH, using = ".//span[text()='Хрустящие минеральные кольца']")
    private SelenideElement fillingInBasket;

    @Step("Нажать на кнопку Войти")
    public void clickButtonEnterAccount() {
        buttonAccountEnter.click();
    }

    @Step("Нажать на кнопку Личный кабинет")
    public void clickButtonPersonalAccount() {
        buttonPersonalAccount.click();
    }

    @Step("Нажать на кнопку Начинки, проверить отображение в корзине")
    public void clickButtonFillingAndCheck() {
        buttonFillings.click();
    }

    @Step("Клик по Соусы, проверка отображения в корзине")
    public void clickButtonSaucesAndCheck() {
        lastIngredient.scrollIntoView(true);
        buttonSauces.click();
    }

    @Step("Клик на Булки, проверка отображения в корзине")
    public void clickButtonBunsAndCheck() {
        lastIngredient.scrollIntoView(true);
        buttonBuns.click();
    }

    @Step("Проверка в каком разделе нахожусь")
    public boolean selectInConstructorCheck(String name) {
        return $(By.xpath("//div[contains(@class, 'current') and //span[contains(text(), '" + name + "')]]")).exists();
    }
}
