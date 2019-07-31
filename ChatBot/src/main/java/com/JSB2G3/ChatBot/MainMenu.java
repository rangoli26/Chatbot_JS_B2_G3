package com.JSB2G3.ChatBot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private String[] menu={"Show All","Brand","Screen Size","Screen Type","Exit"};
    Features features;
    List<String> models;
    List<String> modelFeatures;
    List<String> menuList;
    public String finalChoice=null;

    public MainMenu()
    {
        features=new Features();
        models = new ArrayList<>();
        modelFeatures = new ArrayList<>();
        menuList = new ArrayList<>();
        menuList = Arrays.asList(menu);

        mainMenu(menuList);
    }


    private void mainMenu(List<String> asList) {

        printMenu(asList);
        List<String> currentList;


        int choice=0;

            choice = input("Enter Choice");
            if (choice == 1) {

                currentList=modelMenu("All", "");
                String monitor=currentList.get(input("Enter Choice")-1);
                showModelDetails(monitor);


            }
            else if (choice == 2 || choice == 3 || choice == 4) {

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


    private List<String>  featureMenu(String choice)
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

    private List<String>  modelMenu(String choice,String selectedFeature)
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
