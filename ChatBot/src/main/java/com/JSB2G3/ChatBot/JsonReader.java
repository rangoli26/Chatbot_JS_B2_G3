package com.JSB2G3.ChatBot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonReader {
    String[] monitorArray;
    public JsonReader(Map<String, List<String>> monitorsFeatures) {

        JSONParser parser = new JSONParser();
        try {

            String currentDirectory = System.getProperty("user.dir");

            JSONArray a  = (JSONArray) parser.parse(new FileReader(currentDirectory+"\\src\\main\\java\\com\\JSB2G3\\ChatBot\\PM.json"));


            for (Object o : a)
            {

                JSONObject model = (JSONObject) o;

                String Name = (String) model.get("Name");

                String Brand = (String) model.get("Brand");

                String Size = (String) model.get("Size");

                String Type = (String) model.get("Type");

                monitorArray = new String[]{Brand, Size, Type};
                monitorsFeatures.put(Name, Arrays.asList(monitorArray));


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
