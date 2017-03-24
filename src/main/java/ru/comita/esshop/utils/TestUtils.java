package ru.comita.esshop.utils;

import com.google.gson.Gson;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * That class is developed for more comfortable using of
 * next combination of developer tools:
 * Maven + TestNG + Allure Report + Selenide;
 */


public class TestUtils {

    /**
     * @param jsonFileName - set *.json file;
     * @param tClass       - set instance of Entity class;
     * @param <T>          - set Entity class;
     * @return
     * @throws FileNotFoundException
     */

    public static <T extends Object> T parseJsonToEntity(String jsonFileName, T tClass) throws FileNotFoundException {
        Gson gson = new Gson();
        String jsonFileAndPath = TestUtils.class.getClassLoader().getResource(jsonFileName).getPath();
        tClass = gson.fromJson(new FileReader(jsonFileAndPath), (Class<T>) tClass.getClass());
        return tClass;
    }

    /**
     * Using for getting current method name;
     * @return      - ClassName.methodName()
     */
    public static String getCurrentMethodName(){
        try{
            throw new Exception("");
        }catch(Exception e){
            return e.getStackTrace()[0].toString();
        }
    }


    /**
     * Only with JDK 1.8 or higher
     * @return
     */
    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        String formatedTime = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        return formatedTime;
    }


    @Attachment()
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Text log")
    public static String attachText(String text){
        return text;
    }
}


