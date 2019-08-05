package com.JSB2G3.ChatBot;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.InputStream;

public class MainMenuTest {

    MainMenu mainMenu = new MainMenu();

    public static void setIn(InputStream in) {
        System.setIn(in);
    }

    @Test(expected=NullPointerException.class)
    public void whenSwitchArgumentIsNull_thenNullPointerException() {
        String choice = null;
        assertEquals("Brands", mainMenu.featureMenu(choice));
    }

    @Test
    public void testArrayLengthOfMenu() {

        assertEquals(5,mainMenu.getMenuList().size());
    }
}
