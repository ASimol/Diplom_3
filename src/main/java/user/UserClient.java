package user;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseSpec {

    private static final String USER_PATH = "/api/auth/";

    @Step("Создание клиента")
    public ValidatableResponse userCreate(User user) {
        return given()
                .spec(getSpecification())
                .body(user)
                .when()
                .post(USER_PATH + "register")
                .then().log().all();
    }

    @Step("Авторизация клиента")
    public ValidatableResponse loginUser(User user) {

        HashMap<String,String> dataBody = new HashMap<String,String>();

        dataBody.put("email", user.getEmail());
        dataBody.put("password", user.getPassword());

        return given()
                .spec(getSpecification())
                .body(dataBody)
                .when()
                .post(USER_PATH + "login")
                .then();
    }

    @Step("Выход клиента из кабинета")
    public ValidatableResponse logout(String refreshToken) {
        return given()
                .spec(getSpecification())
                .body(refreshToken)
                .when()
                .post(USER_PATH + "logout")
                .then().log().all();
    }

    @Step("Удаление клиента")

    public ValidatableResponse deletUser(String auth) {
        return given()
                .spec(getSpecification())
                .header("Authorization", auth)
                .when()
                .delete(USER_PATH + "user")
                .then();
    }
}
