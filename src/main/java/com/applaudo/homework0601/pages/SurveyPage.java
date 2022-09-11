package com.applaudo.homework0601.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SurveyPage extends BasePage{
    @FindBy(xpath = "//a[contains(text(),\"Take our survey\")]")
    WebElement aTakeOurSurvey;

    @FindBy(xpath = "//div[contains(@class, \"question vertical\")]")
    List<WebElement> divQuestions;

    public SurveyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void testEightSurveyPage(String url){
        navigateToPage(url);
        scrollToElement(aTakeOurSurvey);
        waitAndClickElement(aTakeOurSurvey);
    }
    public void testNineSurveyPage(int expectedNumber){
        verifyNumberOfElements(divQuestions,expectedNumber);
    }
    public void testTenSurveyPage(){

    }
    public void testElevenSurveyPage(){

    }
}
