package com.JSB2G3.ChatBot;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Greetings {

    List<String>  customerDetails;



    Greetings()
    {
        customerDetails=new ArrayList<String>();
    }

    public String getGreetMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter your name");
        String custName = sc.nextLine();
        return custName;
    }

    public List<String> greetMessage(Scanner scanner)
    {
        Boolean emailValidationFlag=false;
        Boolean nameValidationFlag=false;


        System.out.println("Hi, Enter is your name?");
        do {
            String customerName=scanner.nextLine();

            if (isValidName(customerName)) {
                nameValidationFlag=true;
                customerDetails.add(customerName);

            } else {
                System.out.println("Enter a valid name");

            }
        }while(!nameValidationFlag);





        System.out.println(customerDetails.get(0)+","+" Enter your email ID");
        do {
              String customerEmailID = scanner.nextLine();

            if (isValidEmail(customerEmailID)) {
                emailValidationFlag=true;
                customerDetails.add(customerEmailID);

            } else {
                System.out.println(customerDetails.get(0)+","+"Enter a valid email ID");

            }
        }while(!emailValidationFlag);


        return customerDetails;

    }


    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static boolean isValidName(String txt) {

        String regx = "^[a-zA-Z ]+$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();

    }

}
