package com.JSB2G3.ChatBot;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;

public class GreetingsTest {

    @Test
    public void greetMessage() {
        Scanner scanner = new Scanner("Name\nhello@mail.com\n");
        Greetings g = new Greetings();
        List<String> returnValue = g.greetMessage(scanner);
        assertEquals("Name",returnValue.get(0));
        assertEquals("hello@mail.com", returnValue.get(1));
    }

    @Test
    public void isValidEmail() {
        Scanner scanner = new Scanner("Name\nhello@mail.com\n");
        Greetings g = new Greetings();
        List<String> returnValue = g.greetMessage(scanner);
        Boolean result=Greetings.isValidEmail(returnValue.get(1));
        Assert.assertTrue(result);

    }

    @Test
    public void isValidName() {
        Scanner scanner = new Scanner("Name\nhello@mail.com\n");
        Greetings g = new Greetings();
        List<String> returnValue = g.greetMessage(scanner);
        Boolean result=Greetings.isValidName(returnValue.get(0));
        Assert.assertTrue(result);


    }
}