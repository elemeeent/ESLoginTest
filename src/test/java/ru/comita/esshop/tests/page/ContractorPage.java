package ru.comita.esshop.tests.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContractorPage {
    public ContractorPage checkCompanySuccessLogin() {
        $(By.xpath(".//*[@id=\"navbar\"]/ul[1]/li[1]/a")).shouldBe(visible)
                .shouldHave(text("Закупки"));
        return this;
    }

    public ContractorPage logout(){
        openContractorMenu();
        $(By.xpath(".//*[@id=\"navbar\"]/ul[2]/li/ul/li[8]/a"))
                .shouldBe(visible)
                .shouldHave(text("Выход"))
                .click();
        return this;
    }

    public ContractorPage openContractorMenu(){
        $(By.xpath(".//*[@id=\"navbar\"]/ul[2]/li/a")).shouldBe(visible)
                .click();
        return this;
    }
}
