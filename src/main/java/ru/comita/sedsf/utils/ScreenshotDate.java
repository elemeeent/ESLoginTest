package ru.comita.sedsf.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by viacheslavs on 16.03.2017.
 */
public class ScreenshotDate {
    public static String currentTime() {
        LocalDateTime now = LocalDateTime.now();
        String formatedTime = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        return formatedTime;
    }
}
