package com.applaudo.homework0601.pages;

import org.testng.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BasePage {
    public static final int SECONDS = 20;
    private WebDriver driver;
    private WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(SECONDS));
    }

    protected void visitWebPage(String url){
        driver.get(url);
    }

    protected void waitForElementVisibility(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (TimeoutException e){
            Assert.fail(e.getMessage());
        }
    }

    protected void sendKeysToElement(WebElement element,String text){
        waitForElementVisibility(element);
        element.clear();
        element.sendKeys();
    }

    protected void waitAndClickElement(WebElement element){
        waitForElementVisibility(element);
        element.click();
    }

    protected void validateURL(String expectedURL){
        Assert.assertEquals(expectedURL,driver.getCurrentUrl(),"The URL is not the same");
    }

    protected void validateText(WebElement element,String buttonText){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(buttonText,element.getText(),"The text is not the same");
        softAssert.assertAll();
    }


}
