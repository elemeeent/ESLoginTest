package ru.comita.sedsf.tests.page;

import org.openqa.selenium.By;
import ru.comita.sedsf.utils.ScreenshotDate;

import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    public ContractorPage fillAllPage(String login, String password) {

        openSignInMenu().setLogin(login)
                .setPassword(password)
                .clickButtonSignIn();

        takeScreenShot("setLoginAndPass_" + ScreenshotDate.currentTime()+".png");
        return page(ContractorPage.class);
    }

    public LoginPage setLogin(String login) {
        $(By.id("login")).shouldBe(visible)
                .shouldBe(enabled)
                .setValue(login);
        return this;
    }

    public LoginPage openSignInMenu() {
        $(By.xpath(".//*[@id=\"navbar\"]/ul[2]/li/a")).shouldBe(visible)
                .click();
        return this;
    }

    public LoginPage setPassword(String password) {
        $(By.id("pass")).shouldBe(visible)
                .shouldBe(enabled)
                .setValue(password);

        return this;
    }

    public LoginPage clickButtonSignIn() {
        $(By.xpath(".//*[@id=\"login-nav\"]/div[3]/button")).click();
        return this;
    }

}
