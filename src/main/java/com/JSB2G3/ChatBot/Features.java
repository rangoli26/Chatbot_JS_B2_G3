package com.JSB2G3.ChatBot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Features {

    List<String> Models;
    StartUp obj;
    List<String> modelFeatures;
    String[] feature={"Brand","Screen Size", "Screen Type","Show All","Back","Exit"};

    public Features()
    {
        obj = new StartUp();
        Models = obj.getMonitorsList();
        modelFeatures = Arrays.asList(feature);
    }
    public List<String> getScreenSize()
    {
        List<String> sizeList=new ArrayList<>();
        String size="";
        for( int i=0;i<Models.size();i++)
        {
            size=obj.getMonitorsFeatures(Models.get(i)).get(1);
            if(!sizeList.contains(size))
            {
                sizeList.add(size);
            }
        }
        return sizeList;
    }
    public List<String> getBrands()
    {
        List<String> brandList=new ArrayList<>();
        String brand="";
        for( int i=0;i<Models.size();i++)
        {
            brand=obj.getMonitorsFeatures(Models.get(i)).get(0);
            if(!brandList.contains(brand))
            {
                brandList.add(brand);
            }
        }
        return brandList;
    }
    public List<String> getScreenType()
    {
        List<String> typeList=new ArrayList<>();
        String type="";
        for( int i=0;i<Models.size();i++)
        {
            type=obj.getMonitorsFeatures(Models.get(i)).get(2);
            if(!typeList.contains(type))
            {
                typeList.add(type);
            }
        }
        return typeList;
    }
    public List<String> getModelsBySize(String size, List<String> inputs)
    {
        if(inputs==null)
        {
            inputs=Models;
        }
        List<String> output= new ArrayList<>();
        String screenSize="";
        for(int i=0;i<inputs.size();i++)
        {
            screenSize = obj.getMonitorsFeatures(inputs.get(i)).get(1);
            if(screenSize.equals(size))
            {
                output.add(inputs.get(i));
            }
        }
        return output;
    }

    public List<String> getModelsByTouchScreen(String type, List<String> inputs)
    {
        if(inputs==null)
        {
            inputs=Models;
        }
        List<String> output= new ArrayList<>();
        String screenType="";
        for(int i=0;i<inputs.size();i++)
        {
            screenType = obj.getMonitorsFeatures(inputs.get(i)).get(2);
            if(screenType.equals(type))
            {
                output.add(inputs.get(i));
            }
        }
        return output;
    }

    public List<String> getModelsByBrand(String type, List<String> inputs)
    {
        if(inputs==null)
        {
            inputs=Models;
        }
        List<String> output= new ArrayList<>();
        String Brand="";
        for(int i=0;i<inputs.size();i++)
        {
            Brand = obj.getMonitorsFeatures(inputs.get(i)).get(0);
            if(Brand.equals(type))
            {
                output.add(inputs.get(i));
            }
        }
        return output;
    }
}
