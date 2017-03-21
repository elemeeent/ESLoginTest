package ru.comita.esshop.tests.page;

import org.openqa.selenium.By;
import ru.comita.esshop.utils.TestUtils;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selenide.$;

public class ContractorPage {
    public ContractorPage checkCompanySuccessLogin() {
        $(By.xpath(".//*[@id=\"navbar\"]/ul[1]/li[1]/a")).shouldBe(visible)
                .shouldHave(text("Закупки"));
        return this;
    }

    @Step("Выход из ЛК")
    public ContractorPage logout() {
        openContractorMenu();
        $(By.xpath(".//*[@id=\"navbar\"]/ul[2]/li/ul/li[8]/a"))
                .shouldBe(visible)
                .shouldHave(text("Выход"))
                .click();
        return this;
    }

    @Step("Открытие меню Личного кабинета")
    public ContractorPage openContractorMenu() {
        $(By.xpath(".//*[@id=\"navbar\"]/ul[2]/li/a")).shouldBe(visible)
                .click();
        takeScreenShot("ES_LoginTest_openContractorMenu_" + TestUtils.currentTime() + ".png");
        return this;
    }
}
