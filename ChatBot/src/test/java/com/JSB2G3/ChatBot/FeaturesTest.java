package com.JSB2G3.ChatBot;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class FeaturesTest {

    @Test
    public void getScreenSize() {

        Features features=new Features();
        List<String> sizeList=features.getScreenSize();

        //positive test cases
        String[] sizes={"10","15","12"};
        Assert.assertEquals(Arrays.asList(sizes),sizeList);


        //negative test cases
        String[] list={"10"};
        Assert.assertNotEquals(Arrays.asList(list),sizeList);

        String[] modelTyp={""};
        Assert.assertNotEquals(Arrays.asList(modelTyp),sizeList);

        String[] modelTy={"G30E"};
        Assert.assertNotEquals(Arrays.asList(modelTy),sizeList);

    }

    @Test
    public void getBrands() {

        Features features=new Features();
        List<String> brandList=features.getBrands();

        //positive test cases
        String[] brands={"Goldway","Efficia"};
        Assert.assertEquals(Arrays.asList(brands),brandList);

        //negative test cases
        String[] modelType={"G30E"};
        Assert.assertNotEquals(Arrays.asList(modelType),brandList);

        String[] modelTyp={""};
        Assert.assertNotEquals(Arrays.asList(modelTyp),brandList);

        String[] modelTy={"Goldway",""};
        Assert.assertNotEquals(Arrays.asList(modelTy),brandList);

    }

    @Test
    public void getScreenType() {

        Features features=new Features();
        List<String> screenTypeList=features.getScreenType();


        //positive test cases
        String[] screenType={"Non-Touch","Touch"};
         Assert.assertEquals(Arrays.asList(screenType),screenTypeList);



        //negative test cases
        String[] modelType={"G30E"};
        Assert.assertNotEquals(Arrays.asList(modelType),screenTypeList);

        String[] modelTyp={""};
        Assert.assertNotEquals(Arrays.asList(modelTyp),screenTypeList);

        String[] modelTy={"Goldway",""};
        Assert.assertNotEquals(Arrays.asList(modelTy),screenTypeList);



    }

    @Test
    public void getModelsBySize() {
        //positive test cases
        Features features=new Features();
        String[] modelType={"G40E","CM12","CM120"};
        List<String> modelTypeList=features.getModelsBySize("12",null);
        Assert.assertEquals(Arrays.asList(modelType),modelTypeList);


        //negative test cases
        String[] modelTypes={"G30E"};
        List<String> modelTypesList=features.getModelsBySize("Goldway",null);
        Assert.assertNotEquals(Arrays.asList(modelTypes),modelTypesList);

        String[] modelTyp={""};
        List<String> modelTypList=features.getModelsBySize("Model",null);
        Assert.assertNotEquals(Arrays.asList(modelTyp),modelTypList);

        String[] modelTy={"CM12","CM120"};
        List<String> modelTyList=features.getModelsBySize("Model",Arrays.asList(modelTy));
        Assert.assertNotEquals(Arrays.asList(modelTy),modelTyList);



    }

    @Test
    public void getModelsByTouchScreen() {
        Features features=new Features();

        //positive test cases
        String[] modelType={"G30E","G40E","CM12","CM10"};
        List<String> modelTypeList=features.getModelsByTouchScreen("Non-Touch",null);
        Assert.assertEquals(Arrays.asList(modelType),modelTypeList);

        //negative test cases

        String[] modelTypes={"G30E","G40E","CM12","CM10"};
        List<String> modelTypesList=features.getModelsByBrand("Goldway",null);
        Assert.assertNotEquals(Arrays.asList(modelTypes),modelTypesList);

        String[] modelTyp={""};
        List<String> modelTypList=features.getModelsByBrand("Model",null);
        Assert.assertNotEquals(Arrays.asList(modelTyp),modelTypList);

        String[] modelTy={"G30E"};
        List<String> modelTyList=features.getModelsByBrand("",Arrays.asList(modelTy));
        Assert.assertNotEquals(Arrays.asList(modelTy),modelTyList);


    }

    @Test
    public void getModelsByBrand() {
        Features features=new Features();

        //Positive test cases
        String[] modelTypeGoldway={"G30E","G40E"};
        List<String> GoldwayList=features.getModelsByBrand("Goldway",null);
        Assert.assertEquals(Arrays.asList(modelTypeGoldway),GoldwayList);

        String[] modelTypeEfficia={"CM150", "CM12", "CM100", "CM10", "CM120"};
        List<String> EfficiaList=features.getModelsByBrand("Efficia",null);
        Assert.assertEquals(Arrays.asList(modelTypeEfficia),EfficiaList);

        //negative test cases
        String[] modelType={"G30E"};
        List<String> modelTypeList=features.getModelsByBrand("Goldway",null);
        Assert.assertNotEquals(Arrays.asList(modelType),modelTypeList);

        String[] modelTyp={"G30E"};
        List<String> modelTypList=features.getModelsByBrand("Model",null);
        Assert.assertNotEquals(Arrays.asList(modelTyp),modelTypList);

        String[] modelTy={"G30E"};
        List<String> modelTyList=features.getModelsByBrand("Model",Arrays.asList(modelTy));
        Assert.assertNotEquals(Arrays.asList(modelTy),modelTyList);


    }
}