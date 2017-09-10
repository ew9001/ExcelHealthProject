package com.excelhealth.mytest_cases;

import java.util.concurrent.TimeUnit;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.junit.Assert;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.*;

import org.openqa.selenium.chrome.ChromeDriver;

import com.excelhealth.page_objects.LoginPageObject;
import com.excelhealth.page_objects.MyPortalPageObject;
import com.excelhealth.mytest_cases.plaeme1;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.bcel.generic.Select;



// Import package utility.*


public class PageObjectModel extends ExtentReportClass {
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setUp() throws Exception {

           System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
           System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");


        ChromeOptions options = new ChromeOptions();
       //  options.addArguments("headless");
         options.addArguments("window-size=1440x1280");

        driver = new ChromeDriver(options);

        baseUrl = "http://trial.excelhealthportal.com/";
        driver.get(baseUrl);


        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }




    @Test( priority = 1 )
    public void testLogin() {
        logger = extent.createTest("testLogin");
        LoginPageObject.fillOriginTextBox(driver, "EarlW");
        LoginPageObject.filldestinationTextBox(driver, "upwork");
        LoginPageObject.clickOnSearchButton(driver);

        Assert.assertTrue(MyPortalPageObject.myPortalObject(driver).isDisplayed());
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
    }

    @Test( priority = 2 )
    public void testAdd_task() throws Exception{
        logger = extent.createTest("testAddTask");
        MyPortalPageObject.clickOnAddTaskButton(driver);
        MyPortalPageObject.waitforstartDateTextBox(driver);
        MyPortalPageObject.fillstartDateTextBox(driver, "2017-09-25");
        MyPortalPageObject.fillduetDateTextBox(driver, "2017-12-25");
        MyPortalPageObject.filldescriptionTextBox(driver, "Task Added");
        MyPortalPageObject.fillnotesTextBox(driver,"Note: Inspection starts in 2 weeks");
        MyPortalPageObject.clickOnSubmitButton(driver);

        Thread.sleep(3000);
        // NEED TO DO ======:  Need to add an explicit wait ===== NEED TO DO - wait for text present

        Assert.assertTrue(driver.getPageSource().contains("Task Added"));
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));

    }



    @Test( priority = 3 )
    public void testDelete_task() throws Exception{
        logger = extent.createTest("testDeleteTask");
        MyPortalPageObject.clickOnDescription(driver);
        MyPortalPageObject.waitforEditTaskandclick(driver);
        MyPortalPageObject.waitforstartDateTextBox(driver);
        MyPortalPageObject.clickOnDeleteButton(driver);
        MyPortalPageObject.waitforPortalPage(driver);

    //    Assert.assertFalse(driver.getPageSource().contains("No data available in table"));
     //   Assert.assertTrue(driver.getPageSource().contains("Task Added"));
       // Assert.assertTrue(MyPortalPageObject.myPortalObject(driver).isDisplayed());
        // must be when text is present
       // try {
        Thread.sleep(1000);


        Assert.assertFalse(driver.getPageSource().contains("Task Added"));
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));



        Thread.sleep(2000);
        // NEED TO DO ======:  Need to add an explicit wait ===== NEED TO DO
    }

    @Test( priority = 4 )
    public void testLogout() {
        logger = extent.createTest("testLogout");
        MyPortalPageObject.clickonLogoutButton(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertTrue(LoginPageObject.originTextBox(driver).isDisplayed());
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));

    }



    @AfterTest
    public void tearDown() throws Exception {

        driver.quit();
    }



}