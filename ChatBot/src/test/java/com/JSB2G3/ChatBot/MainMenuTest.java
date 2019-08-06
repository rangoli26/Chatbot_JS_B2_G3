package com.JSB2G3.ChatBot;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

import com.JSB2G3.utils.TypeValues;
import org.junit.Test;
import sun.applet.Main;

import java.io.InputStream;
import java.lang.reflect.Member;
import java.util.Arrays;

public class MainMenuTest {

    MainMenu mainMenu = new MainMenu();

    public static void setIn(InputStream in) {
        System.setIn(in);
    }

    @Test
    public void whenSwitchArgIsAll_thenGetMonitorsList() {
        String choice = "All";
        assertEquals(Arrays.asList("G30E", "CM150", "G40E", "CM12", "CM100", "CM10", "CM120"),
                mainMenu.modelMenu(choice,""));
    }

    @Test(expected=NullPointerException.class)
    public void whenSwitchArgumentIsNull_thenNullPointerException() {
        String choice = null;
        assertEquals("Brands", mainMenu.featureMenu(choice));
    }

    @Test
    public void whenCompareStrings_thenByEqual() {
        String choice = new String("Brand");
        assertEquals(Arrays.asList("Goldway","Efficia"), mainMenu.featureMenu(choice));
    }
    @Test
    public void testArrayLengthOfMenu() {

        assertEquals(5,mainMenu.getMenuList().size());
    }
}
