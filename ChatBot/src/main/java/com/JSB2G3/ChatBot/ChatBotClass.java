package com.JSB2G3.ChatBot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChatBotClass {

    String[] menu={"Show All","Brand","Screen Size","Screen Type","Exit"};
    Features features;
    List<String> models;
    List<String> modelFeatures;
    List<String> menuList;
    Scanner scanner;


    public ChatBotClass()
    {
        features=new Features();
        models = new ArrayList<>();
        modelFeatures = new ArrayList<>();
        menuList = new ArrayList<>();
        menuList = Arrays.asList(menu);

    }

    public String mainMenu() {

        String monitor= null;
        printMenu(menuList);
        int firstChoice = input(scanner,"Enter Choice");
        if(firstChoice <= menuList.size() && firstChoice > 0)
        {
            switch(firstChoice)
            {
                case 1:

                    monitor= showAllMonitors();
                    break;

                case 2:

                    monitor= showByBrand();
                    break;

                case 3:
                    monitor=showBySize();
                    break;

                case 4:
                    monitor= showByScreenType();
                    break;

                case 5:
                    System.out.println("Thank you, Have a nice day");
                    break;

            }

        }else{
            System.out.println("Invalid input, displaying menu again");
            mainMenu();
        }

        return monitor;
    }



    public String showAllMonitors()
    {
        String monitor;
        while(true){
            List<String> monitorList;
            monitorList = modelMenu("All");
            printMenu(monitorList);
            int secondChoice = input(scanner,"Enter Choice");

            if (secondChoice <= monitorList.size() && secondChoice > 0)
            {
                monitor = monitorList.get(secondChoice - 1);
                showModelDetails(monitor);
                break;

            }else
            {
                System.out.println("Invalid input, displaying menu again");

            }
        }
      return monitor;

    }



    private String showByBrand(){
        String monitor;
        while(true) {
            List<String> modelList = featureMenu(menuList.get(1));
            printMenu(modelList);
            int secondChoice = input(scanner, "Enter Choice");
            if (secondChoice <= modelList.size() && secondChoice > 0) {
                String model = modelList.get(secondChoice - 1);
                while(true) {
                    List<String> monitorList = features.getModelsByBrand(model, null);
                    printMenu(monitorList);
                    int thirdChoice = input(scanner, "Enter Choice");
                    if (thirdChoice <= monitorList.size() && thirdChoice > 0) {
                        monitor = monitorList.get(thirdChoice - 1);
                        showModelDetails(monitor);
                        break;

                    } else {
                        System.out.println("Invalid input, displaying menu again");

                    }
                }
                break;

            } else {
                System.out.println("Invalid input, displaying menu again");

            }
        }
        return monitor;
    }


    private String showBySize()
    {
        String monitor;
        while(true) {
            List<String> modelList = featureMenu(menuList.get(2));
            printMenu(modelList);
            int secondChoice = input(scanner, "Enter Choice");
            if (secondChoice <= modelList.size() && secondChoice > 0) {
                String model = modelList.get(secondChoice - 1);
                while(true) {
                    List<String> monitorList = features.getModelsBySize(model, null);
                    printMenu(monitorList);
                    int thirdChoice = input(scanner, "Enter Choice");
                    if (thirdChoice <= monitorList.size() && thirdChoice > 0) {
                        monitor = monitorList.get(thirdChoice - 1);
                        showModelDetails(monitor);
                        break;

                    } else {
                        System.out.println("Invalid input, displaying menu again");


                    }
                }
                break;

            } else {
                System.out.println("Invalid input, displaying menu again");

            }
        }
        return monitor;

    }


    public String showByScreenType()
    {
        String monitor;
        while(true) {
            List<String> modelList = featureMenu(menuList.get(3));
            printMenu(modelList);
            int secondChoice = input(scanner, "Enter Choice");
            if (secondChoice <= modelList.size() && secondChoice > 0) {
                String model = modelList.get(secondChoice - 1);
                while(true) {
                    List<String> monitorList = features.getModelsByTouchScreen(model, null);
                    printMenu(monitorList);
                    int thirdChoice = input(scanner, "Enter Choice");
                    if (thirdChoice <= monitorList.size() && thirdChoice > 0) {
                        monitor = monitorList.get(thirdChoice - 1);
                        showModelDetails(monitor);
                        break;

                    } else {
                        System.out.println("Invalid input, displaying menu again");


                    }
                }
                break;

            } else {
                System.out.println("Invalid input, displaying menu again");

            }

        }
        return monitor;

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
        return modelFeatures;
    }



    public List<String>  modelMenu(String choice)
    {
        switch (choice)
        {
            case "Brand":
                models=features.getModelsByBrand("",models);
                break;
            case "Screen Size":
                models=features.getModelsBySize("",models);
                break;
            case "Screen Type":
                models=features.getModelsByTouchScreen("",models);
                break;
            case "All":
                models=features.startUp.getMonitorsList();
                break;
            default:
                models=null;
        }

          return models;
    }


    private int input(Scanner sc,String text)
    {
             System.out.println(text);
            return sc.nextInt();
    }


    private void printMenu(List<String> menu) {

        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ") " + menu.get(i));
        }
    }


    private void showModelDetails(String model)
    {
        List<String> details = features.startUp.getMonitorsFeatures(model);

        System.out.println("Model Name : "+model);
        System.out.println("Model Brand : "+details.get(0));
        System.out.println("Model Screen Size : "+details.get(1));
        System.out.println("Model Screen Type : "+details.get(2));

    }


    public boolean confirmOrderDetails(String model)
    {
        boolean ordercnf = false;

        System.out.println("in oonfirm class"+model);

        if(model != null) {

            String[] order = {"Yes", "Exit"};
            List<String> orderMenu = new ArrayList<>(Arrays.asList(order));

            while (true) {
                System.out.println("Do you want to buy the Philips" +
                        " " + model + " monitor?");
                printMenu(orderMenu);
                int finalChoice = input(scanner, "Enter your choice");
                if (finalChoice <= orderMenu.size() && finalChoice > 0) {

                    if (finalChoice == 1) {

                        ordercnf = true;
                    } else {

                        ordercnf = false;
                        System.out.println("Thank you, Have a nice day");
                        break;

                    }
                    break;
                } else {

                    System.out.println("Invalid input, displaying menu again");


                }
            }
        }
            return ordercnf;


    }




}
