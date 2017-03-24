package ru.comita.esshop.tests.page;

import org.openqa.selenium.By;
import ru.comita.esshop.utils.TestUtils;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class LoginPage {
    public static String PAGE_URL = "http://ukk-eshop.comita.lan:8080/ccwe";

    public ContractorPage fillAllPage(String login, String password) throws IOException {
        openSignInMenu().setLogin(login)
                .setPassword(password);
        TestUtils.takeScreenshot();
        clickButtonSignIn();
        return page(ContractorPage.class);
    }

    @Step("Заполение логина")
    public LoginPage setLogin(String login) throws IOException {
        $(By.id("login"))
                .shouldBe(visible)
                .shouldBe(enabled)
                .setValue(login);
                return this;
    }

    @Step("Открытие меню входа")
    public LoginPage openSignInMenu() {
        $(By.xpath(".//*[@id=\"navbar\"]/ul[2]/li/a")).shouldBe(visible)
                .click();
        return this;
    }

    @Step("Заполнение пароля")
    public LoginPage setPassword(String password) throws IOException {
        $(By.id("pass")).shouldBe(visible)
                .shouldBe(enabled)
                .setValue(password);
        return this;
    }

    @Step("Кнопка входа")
    public LoginPage clickButtonSignIn() {
        $(By.xpath(".//*[@id=\"login-nav\"]/div[3]/button")).click();
        return this;
    }
}
