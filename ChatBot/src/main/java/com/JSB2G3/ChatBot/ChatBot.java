package com.JSB2G3.ChatBot;

import java.util.List;
import java.util.Scanner;

public class ChatBot {

    public static void main(String[] args)
    {
        List<String> customerDetails;
        Greetings greetings=new Greetings();
        Scanner scanner = new Scanner(System.in);
        customerDetails = greetings.greetMessage(scanner);

        ChatBotClass chatBotClass =new ChatBotClass();
        chatBotClass.scanner=new Scanner(System.in);
        String monitor= chatBotClass.mainMenu();
        customerDetails.add(monitor);


            if (chatBotClass.confirmOrderDetails(monitor)) {
                System.out.println("Thank You,"+" "+customerDetails.get(0)+" for choosing philips"
                                +" "+monitor +" "+"patient monitor."+
                        "\n" + "Your order details are processed." +
                        " Our team will contact you shortly");


        }





    }

}
