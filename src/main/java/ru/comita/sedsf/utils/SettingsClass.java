package ru.comita.sedsf.utils;

public class SettingsClass {

    private static SettingsClass instance;

    public static synchronized SettingsClass getConfig() {

        if (instance == null) {
            instance = new SettingsClass();
        }
        return instance;
    }

    private SettingsClass() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("selenide.browser", "chrome");
        System.setProperty("selenide.baseUrl", "http://ukk-eshop.comita.lan:8080/ccwe");
    }


}
