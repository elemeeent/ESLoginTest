package ru.comita.esshop.utils;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestUtils {

    /**
     * @param jsonFileName - set path to *.json file and the file itself;
     * @param tClass       - set object of Entity class;
     * @param <T>          - set Entity class;
     * @return - processed object of Entity class;
     * @throws - FileNotFoundException
     */


    public static <T extends Object> T parseJsonToEntity(String jsonFileName, T tClass) throws FileNotFoundException {
        Gson gson = new Gson();
        String jsonFileAndPath = TestUtils.class.getClassLoader().getResource(jsonFileName).getPath();
        tClass = gson.fromJson(new FileReader(jsonFileAndPath), (Class<T>) tClass.getClass());
        return tClass;
    }


    public static String currentTime() {
        LocalDateTime now = LocalDateTime.now();
        String formatedTime = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        return formatedTime;
    }
}



