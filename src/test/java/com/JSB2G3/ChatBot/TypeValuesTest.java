package com.JSB2G3.ChatBot;

import com.JSB2G3.utils.TypeValues;
import org.junit.Test;

import javax.lang.model.element.TypeElement;

import static junit.framework.TestCase.assertEquals;
public class TypeValuesTest {

    @Test
    public void whenOneSelected_shouldResturnOne() {
        assertEquals(0, TypeValues.ZERO);
    }

}
