package com.JSB2G3.ChatBot;

import java.util.List;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args)
    {
        Greetings greetings=new Greetings();
        Scanner scanner = new Scanner(System.in);
        List<String> customerDetails = greetings.greetMessage(scanner);
        MainMenu menu=new MainMenu();

        if(menu.finalChoice !=null)
        {
            customerDetails.add(menu.finalChoice);
        }

        System.out.println("Thank You! We will contact you shortly");




    }

}
