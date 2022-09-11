package com.applaudo.homework0601;

import com.applaudo.homework0601.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    private HomePage homePage;

    @BeforeClass
    public void setupPages(){
        this.homePage = new HomePage(driver);
    }
    @Test(priority = 1)
    public void navigateToPage(){
        System.out.println("Executing Test 1 of HomePage");
        homePage.testOneHomePage("https://www.loc.gov/");
    }

    @Test(priority = 2)
    public void analyzeWithIRetry(){
        System.out.println("Executing Test 2 of HomePage");
    }

    @Test(priority = 2,dataProvider = "validateSearchesData")
    public void validateSearches(String buttonText,int index){
        System.out.println("Executing Test 3 of HomePage");
        homePage.testThreeHomePage(buttonText,index);
    }

    @Test(dependsOnMethods = {"navigateToPage","analyzeWithIRetry","validateSearches"})
    public void clickDigitalCollections(){
        System.out.println("Executing Test 4 of HomePage");
        homePage.testFourHomePage();
    }

    @DataProvider
    public Object[][] validateSearchesData(){
        return new Object[][]{
                {"Civil War",0},
                {"WPA",1},
                {"National Parks",2},
                {"Dust Bowl",3},
                {"Maps",4},
                {"Ukraine",5},
        };

    }
}
