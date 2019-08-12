package com.JSB2G3.ChatBot;

import com.JSB2G3.utils.TypeValues;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Getter @Setter
public class MainMenu {

    private List<String> models = new ArrayList<>();
    private List<String> modelFeatures = new ArrayList<>();
    private List<String> menuList = new ArrayList<>
            (Arrays.asList("Show All","Brand","Screen Size","Screen Type","Exit"));
    public String finalChoice=null;

    Features features=new Features();


    public MainMenu()
    {

    }



    public void generateMenu(List<String> asList) {

        printMenu(asList);
        List<String> currentList;


        int choice = TypeValues.ZERO;

        choice = input("Enter Choice");
        if (choice == TypeValues.ONE) {

            currentList=modelMenu("All", "");
            String monitor=currentList.get(input("Enter Choice")-1);
            showModelDetails(monitor);


        }
        else if (choice == TypeValues.TWO || choice == TypeValues.THREE || choice == TypeValues.FOUR) {

            String monitors;
            List<String> cList=featureMenu(menuList.get(choice - 1));
            int option=input("Enter Choice")-1;
            String monitor=cList.get(option);



            if (choice == 2)
            {
                currentList=features.getModelsByBrand(monitor,null);

            }else if(choice ==3)
            {
                currentList=features.getModelsBySize(monitor,null);

            }else{
                currentList=features.getModelsByTouchScreen(monitor,null);

            }


            printMenu(currentList);
            monitors=currentList.get(input("Enter Choice")-1);
            showModelDetails(monitors);

        }
        else if (choice == 5) {
            System.out.println("Thank you, Have a nice day! ");
            System.exit(0);
        }

        else {
            System.out.println("Please enter a valid choice");

        }

    }


    public List<String>  featureMenu(String choice)
    {
        switch (choice)
        {
            case "Brand":
                modelFeatures=features.getBrands();
                break;
            case "Screen Size":
                modelFeatures=features.getScreenSize();
                break;
            case "Screen Type":
                modelFeatures=features.getScreenType();
                break;
        }
        printMenu(modelFeatures);
        return modelFeatures;

    }

    public List<String>  modelMenu(String choice,String selectedFeature)
    {
        switch (choice)
        {
            case "Brand":
                models=features.getModelsByBrand(selectedFeature,models);
                break;
            case "Screen Size":
                models=features.getModelsBySize(selectedFeature,models);
                break;
            case "Screen Type":
                models=features.getModelsByTouchScreen(selectedFeature,models);
                break;
            case "All":
                models=features.obj.getMonitorsList();
                break;

        }

        printMenu(models);
        return models;



    }

    private int input(String text)
    {
        System.out.println(text);
        Scanner sc = new Scanner(System.in); //Reply from the user
        return sc.nextInt();
    }

    private void printMenu(List<String> menu)
    {
        List<String> output = new ArrayList<>();
        for(int i=0; i < menu.size();i++)
        {
            output.add(menu.get(i));
            System.out.println((i+1)+") "+menu.get(i));
        }

    }

    private void showModelDetails(String model)
    {
        List<String> details = features.obj.getMonitorsFeatures(model);

        System.out.println("Model Name : "+model);
        System.out.println("Model Brand : "+details.get(0));
        System.out.println("Model Screen Size : "+details.get(1));
        System.out.println("Model Screen Type : "+details.get(2));
        if(confirmOrderDetails(model))
        {
            finalChoice=model;
        }

    }

    private boolean confirmOrderDetails(String model)
    {
        boolean ordercnf=false;
        System.out.println("Do you want to buy the Philips" +
                " "+model+" monitor?");
        String[] order={"Yes","Exit"};
        printMenu(Arrays.asList(order));

        switch(input("Enter your choice"))
        {
            case 1:
                ordercnf=true;
                break;
            case 2:
                System.out.println("Thank you, Have a nice day! ");
                System.exit(0);


        }

        return ordercnf;

    }




}