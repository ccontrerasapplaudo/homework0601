package com.applaudo.homework0601.pages;

import com.applaudo.homework0601.BaseTest;
import com.google.common.base.Verify;
import org.testng.annotations.*;

public class DigitalCollectionsPageTest extends BaseTest {

    private DigitalCollectionsPage digitalCollectionsPage;

    @BeforeClass(alwaysRun = true)
    public void setupPages(){
        this.digitalCollectionsPage = new DigitalCollectionsPage(driver);
    }

    @Test(priority = 3,groups = "digitalCollectionsGroup")
    public void verifyWordIsPresent(){
        System.out.println("Executing Test 6 of HomePage");
        digitalCollectionsPage.testSixDigitalCollectionsPage();
        System.out.println("Finishing Test 6 of HomePage");
    }

    @Test(priority = 4,groups = "digitalCollectionsGroup",dataProvider = "performSearchData")
    public void performSearch(String search){
        System.out.println("Executing Test 7 of HomePage");
        digitalCollectionsPage.testSevenDigitalCollectionsPage(search);
        System.out.println("Finishing Test 7 of HomePage");
    }

    @DataProvider
    public Object[][] performSearchData(){
        return new Object[][]{
                {"Abraham Lincoln"},
                {"Benjamin Franklin Papers"},
                {"Earth Day"},
        };

    }
}
