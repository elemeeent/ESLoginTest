package ru.comita.esshop.utils;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;

public class SettingsClass {

    private static SettingsClass instance;

    public static synchronized SettingsClass getConfig() {

        if (instance == null) {
            instance = new SettingsClass();
        }
        return instance;
    }


    private SettingsClass() {
        PropertyLoader.populate(this);
    }

    @Property("selenide.timeout")
    private String selenideTimeout = "120000";

    @Property("selenide.collectionsTimeout")
    private String selenideCollectionsTimeout = "12000";

    @Property("es.url")
    private String esUrl = "http://ukk-eshop.comita.lan:8080/ccwe";

    @Property("selenide.browser")
    private String selenideBrowser = "chrome";

    @Property("webdriver.chrome.driver")
    private String chromeDriver = "src\\main\\resources\\chromedriver.exe";


    public String getSelenideTimeout() {
        return selenideTimeout;
    }

    public String getSelenideCollectionsTimeout() {
        return selenideCollectionsTimeout;
    }

    public String getEsUrl() {
        return esUrl;
    }

    public String getSelenideBrowser() {
        return selenideBrowser;
    }

    public String getChromeDriver() {
        return chromeDriver;
    }
}
