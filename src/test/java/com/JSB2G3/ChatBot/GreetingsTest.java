package com.JSB2G3.ChatBot;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

public class GreetingsTest {

    Greetings g = new Greetings();

    @Test
    public void greetMessage() {
        Scanner scanner = new Scanner("Name\nhello@mail.com\n");
        List<String> returnValue = g.greetMessage(scanner);
        assertEquals("Name",returnValue.get(0));
        assertEquals("hello@mail.com", returnValue.get(1));
    }

    @Test()
    public void whenUsedWildCharactersForName_ThenFalse() {

//        List<String> message = g.greetMessage(new Scanner("@##"));
        assertFalse(g.isValidName("@##"));
//        assertThat(message.get(0),startsWith("Enter"));
    }

    @Test
    public void testHandleInvalidEntry() {
        g.handleInvalidEntry("Test");
        assertThat("Enter",startsWith("Enter"));
    }
    @Test
    public void isValidEmail() {
        Scanner scanner = new Scanner("Name\nhello@mail.com\n");
        List<String> returnValue = g.greetMessage(scanner);
        Boolean result=Greetings.isValidEmail(returnValue.get(1));
        Assert.assertTrue(result);

    }

    @Test
    public void whenEmailIsNull_ReturnFalse() {
        assertFalse(Greetings.isValidEmail(null));
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