package com.JSB2G3.ChatBot;
import java.util.List;

public class Model {
    public String brand;
    public String name;
    public String screenSize;
    public String type;

    public Model(String name, List<String> details)
    {
        this.brand = details.get(0);
        this.name = name;
        this.screenSize = details.get(1);
        this.type = details.get(2);
    }
}
