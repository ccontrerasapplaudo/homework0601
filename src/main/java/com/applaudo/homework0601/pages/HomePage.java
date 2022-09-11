package com.applaudo.homework0601.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePage extends BasePage{
    @FindBy(xpath = "//a[contains(.,'Digital Collections')]")
    WebElement aDigitalCollectionsButton;

    @FindBy(css = "div.trending-top-searches a")
    List<WebElement> buttonTopSearches;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void testOneHomePage(String url){
        visitWebPage(url);
        validateURL(url);
    }

    public void testThreeHomePage(String buttonText,int index){
        validateText(buttonTopSearches.get(index),buttonText);
    }

    public void testFourHomePage(){
        waitAndClickElement(aDigitalCollectionsButton);
    }
}
