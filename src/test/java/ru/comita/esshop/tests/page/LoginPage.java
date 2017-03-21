package ru.comita.esshop.tests.page;

import org.openqa.selenium.By;
import ru.comita.esshop.utils.TestUtils;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    public static String PAGE_URL = "http://ukk-eshop.comita.lan:8080/ccwe";

    public ContractorPage fillAllPage(String login, String password) {
        openSignInMenu().setLogin(login)
                .setPassword(password)
                .clickButtonSignIn();
        return page(ContractorPage.class);
    }

    @Step("Заполение логина")
    public LoginPage setLogin(String login) {
        $(By.id("login"))
                .shouldBe(visible)
                .shouldBe(enabled)
                .setValue(login);
        takeScreenShot("ES_LoginTest_setLogin_" + TestUtils.currentTime() + ".png");
        return this;
    }

    @Step("Открытие меню входа")
    public LoginPage openSignInMenu() {
        $(By.xpath(".//*[@id=\"navbar\"]/ul[2]/li/a")).shouldBe(visible)
                .click();
        return this;
    }

    @Step("Заполнение пароля")
    public LoginPage setPassword(String password) {
        $(By.id("pass")).shouldBe(visible)
                .shouldBe(enabled)
                .setValue(password);
        takeScreenShot("ES_LoginTest_setPassword_" + TestUtils.currentTime() + ".png");
        return this;
    }

    @Step("Кнопка входа")
    public LoginPage clickButtonSignIn() {
        $(By.xpath(".//*[@id=\"login-nav\"]/div[3]/button")).click();
        return this;
    }
}
