package com.JSB2G3.ChatBot;

import java.util.*;

public class StartUp {


    Map<String,List<String>> monitorsFeatures= new HashMap<String, List<String>>();


    public StartUp()
    {
        new JsonReader(monitorsFeatures);
    }

    public List<String> getMonitorsFeatures(String model) {
        return monitorsFeatures.get(model);
    }
    
    public List<String> getMonitorsList()
    {
        List<String> MonitorsList = new ArrayList<String>();
        for (String k : monitorsFeatures.keySet())
        {
            MonitorsList.add(k);
        }
        return MonitorsList;                
    }
}
