package com.applaudo.homework0601;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Objects;

public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
        driver = WebDriverManager.firefoxdriver().create();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void quitDriver(){
        if(Objects.nonNull(driver)){
            driver.quit();
        }
    }

}
