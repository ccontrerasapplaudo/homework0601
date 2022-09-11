package com.applaudo.homework0601.pages;

import com.applaudo.homework0601.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SurveyPageTest extends BaseTest {
    private SurveyPage surveyPage;

    @BeforeClass(alwaysRun = true)
    public void setupPages(){
        this.surveyPage = new SurveyPage(driver);
    }

    @Test(priority = 5,groups = "SurveyGroup")
    public void scrollToTakeOurSurvey() throws InterruptedException {
        System.out.println("Executing Test 8 of SurveyPage");
        surveyPage.testEightSurveyPage("https://www.loc.gov/");
        waitTime();
        System.out.println("Finishing Test 8 of SurveyPage");
    }

    @Test(priority = 6,groups = "SurveyGroup")
    public void verifyNumberOfQuestions() throws InterruptedException {
        System.out.println("Executing Test 9 of SurveyPage");
        surveyPage.testNineSurveyPage(3);
        waitTime();
        System.out.println("Finishing Test 9 of SurveyPage");
    }

}
