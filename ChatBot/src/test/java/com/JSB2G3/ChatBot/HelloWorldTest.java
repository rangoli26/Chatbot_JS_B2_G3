package com.JSB2G3.ChatBot;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {
    @Test
    public void testMethodHelloWorld()
    {
        HelloWorld mc=new HelloWorld();
        String S=mc.check(0);
        Assert.assertEquals("Hello World", S);
    }

    @Test
    public void testMethodGoodBye()
    {
        HelloWorld mc=new HelloWorld();
        String S=mc.check(1);
        Assert.assertEquals("Goodbye World", S);
    }


}