package com.applaudo.homework0601.pages;

import com.applaudo.homework0601.BaseTest;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setupPages(){
        this.homePage = new HomePage(driver);
    }

    @Test(priority = 1,groups = "homePageGroup")
    public void navigateToPage(){
        System.out.println("Executing Test 1 of HomePage");
        homePage.testOneHomePage("https://www.loc.gov/");
        System.out.println("Finishing Test 1 of HomePage");
    }

    @Test(priority = 2,groups = "homePageGroup")
    public void analyzeWithIRetry(){
        System.out.println("Executing Test 2 of HomePage");
        System.out.println("Finishing Test 2 of HomePage");
    }

    @Test(priority = 2,groups = "homePageGroup",dataProvider = "validateSearchesData")
    public void validateSearches(String buttonText,int index){
        System.out.println("Executing Test 3 of HomePage");
        homePage.testThreeHomePage(buttonText,index);
        System.out.println("Finishing Test 3 of HomePage");
    }

    @Test(dependsOnMethods = {"navigateToPage","analyzeWithIRetry","validateSearches"},groups = "homePageGroup")
    public void clickDigitalCollections(){
        System.out.println("Executing Test 4 of HomePage");
        homePage.testFourHomePage();
        System.out.println("Finishing Test 4 of HomePage");
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
