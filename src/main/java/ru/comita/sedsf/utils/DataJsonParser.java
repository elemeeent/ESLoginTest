package ru.comita.sedsf.utils;

import com.google.gson.Gson;
import ru.comita.sedsf.entity.Contractor;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataJsonParser {

    /**
     * @param jsonFileName - set path to *.json file and the file itself;
     * @param tClass       - set object of Entity class;
     * @param <T>          - set Entity class;
     * @return - processed object of Entity class;
     * @throws FileNotFoundException
     */

    public static <T extends Object> T parseJsonToEntity(String jsonFileName, T tClass) throws FileNotFoundException {
        Gson gson = new Gson();
        tClass = gson.fromJson(new FileReader(jsonFileName), (Class<T>) tClass.getClass());
        return tClass;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Contractor contractor = new Contractor();
        contractor = DataJsonParser.parseJsonToEntity("src\\main\\resources\\data.json", contractor);
        System.out.println(contractor.getContractorPassword());

    }
}

