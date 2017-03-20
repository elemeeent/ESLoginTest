package ru.comita.esshop.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotDate {
    public static String currentTime() {
        LocalDateTime now = LocalDateTime.now();
        String formatedTime = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        return formatedTime;
    }
}
