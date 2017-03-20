package ru.comita.sedsf.tests.page;

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
        $(By.id("exitBtn")).click();
        $(By.xpath(""));
        $(By.cssSelector(".x-window.x-window-plain.x-window-dlg .x-btn-text")).shouldHave(text("ОК"));

        return this;
    }
}
