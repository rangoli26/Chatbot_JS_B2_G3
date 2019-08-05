package com.JSB2G3.ChatBot;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ChatBotClassTest {

    @Test
    public void mainMenu() {
        ChatBotClass g = new ChatBotClass();

        //positive test cases

        g.scanner=new Scanner(1+"\n"+1+"\n");
        assertEquals("G30E",g.mainMenu());

        g.scanner=new Scanner(1+"\n"+7+"\n");
        assertEquals("CM120",g.mainMenu());

        g.scanner=new Scanner(1+"\n"+2+"\n");
        assertEquals("CM150",g.mainMenu());




        //negative test cases

        g.scanner=new Scanner(1+"\n"+0+"\n"+2+"\n");
        assertNotEquals("G30E",g.mainMenu());


        g.scanner=new Scanner(1+"\n"+-1+"\n"+3+"\n");
        assertNotEquals("G30E",g.mainMenu());

        g.scanner=new Scanner(0+"\n"+1+"\n"+1+"\n");
        assertNotEquals("G50E",g.mainMenu());

        g.scanner=new Scanner(-1+"\n"+1+"\n"+4+"\n");
        assertNotEquals("G30E",g.mainMenu());

        g.scanner=new Scanner(6+"\n"+1+"\n"+1+"\n");
        assertNotEquals("CM12",g.mainMenu());

        g.scanner=new Scanner(1+"\n"+10+"\n"+1+"\n");
        assertNotEquals("",g.mainMenu());



    }

    @Test
    public void showAllMonitors() {

        ChatBotClass g = new ChatBotClass();

        //positive test cases

        g.scanner=new Scanner(1+"\n"+4+"\n");
        assertEquals("CM12",g.mainMenu());


        g.scanner=new Scanner(1+"\n"+10+"\n"+2+"\n");
        assertEquals("CM150",g.mainMenu());


        //negative test cases

        g.scanner=new Scanner(9+"\n"+(-1)+"\n"+1+"\n"+2+"\n");
        assertNotEquals("G30E",g.mainMenu());




    }

    @Test
    public void showByScreenType() {

        ChatBotClass g = new ChatBotClass();

        //positive test cases

        g.scanner=new Scanner(1+"\n"+4+"\n");
        assertEquals("CM12",g.mainMenu());


        g.scanner=new Scanner(1+"\n"+10+"\n"+2+"\n");
        assertEquals("CM150",g.mainMenu());


        //negative test cases


        g.scanner=new Scanner(9+"\n"+(-1)+"\n"+1+"\n"+2+"\n");
        assertNotEquals("G30E",g.mainMenu());
    }

    @Test
    public void modelMenu() {
        ChatBotClass g = new ChatBotClass();


        //positive test cases

        List<String> listTypes=g.featureMenu("");
        String[] TypeList={};
        assertEquals(Arrays.asList(TypeList),listTypes);


        List<String> list=g.modelMenu("All");
        String[] mlist={ "G30E","CM150","G40E","CM12","CM100","CM10","CM120"};
        assertEquals(Arrays.asList(mlist),list);


        List<String> listBrands=g.featureMenu("Brand");
        String[] brandsList={ "Goldway","Efficia"};
        assertEquals(Arrays.asList(brandsList),listBrands);



        List<String> listSizes=g.featureMenu("Screen Size");
        String[] sizesList={ "10","15","12"};
        assertEquals(Arrays.asList(sizesList),listSizes);



        List<String> listScreenTypes=g.featureMenu("Screen Type");
        String[] screenTypeList={ "Non-Touch","Touch"};
        assertEquals(Arrays.asList(screenTypeList),listScreenTypes);


        //Negative test cases

        List<String> listS=g.featureMenu("Screen Type");
        String[] sList={};
        assertNotEquals(Arrays.asList(sList),listS);




    }

    @Test
    public void confirmOrderDetails() {
        ChatBotClass g = new ChatBotClass();

        //positive test cases
        g.scanner=new Scanner(1+"\n");
        assertEquals(true,g.confirmOrderDetails(""));


        g.scanner=new Scanner(2+"\n");
        assertEquals(false,g.confirmOrderDetails(""));




        //negative test cases

        g.scanner=new Scanner(-1+"\n"+1+"\n");
        assertEquals(true,g.confirmOrderDetails(""));

        g.scanner=new Scanner(3+"\n"+1+"\n");
        assertEquals(true,g.confirmOrderDetails(""));






    }
}