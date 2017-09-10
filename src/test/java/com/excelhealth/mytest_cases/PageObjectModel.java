package com.excelhealth.mytest_cases;

import java.util.concurrent.TimeUnit;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.*;

import org.openqa.selenium.chrome.ChromeDriver;

import com.excelhealth.page_objects.LoginPageObject;
import com.excelhealth.page_objects.MyPortalPageObject;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.bcel.generic.Select;



// Import package utility.*


public class PageObjectModel {
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

        LoginPageObject.fillOriginTextBox(driver, "EarlW");
        LoginPageObject.filldestinationTextBox(driver, "upwork");
        LoginPageObject.clickOnSearchButton(driver);

        Assert.assertTrue(MyPortalPageObject.myPortalObject(driver).isDisplayed());

    }

    @Test( priority = 2 )
    public void testAdd_task() throws Exception{

        MyPortalPageObject.clickOnAddTaskButton(driver);
        MyPortalPageObject.waitforstartDateTextBox(driver);
        MyPortalPageObject.fillstartDateTextBox(driver, "2017-09-25");
        MyPortalPageObject.fillduetDateTextBox(driver, "2017-12-25");
        MyPortalPageObject.filldescriptionTextBox(driver, "Task Added");
        MyPortalPageObject.fillnotesTextBox(driver,"Note: Inspection starts in 2 weeks");
        MyPortalPageObject.clickOnSubmitButton(driver);



        Thread.sleep(3000);

        Assert.assertTrue(driver.getPageSource().contains("Task Added"));


       // String TaskName = "Task Added";
//
//        String bodyText = driver.findElement(By.xpath("//*[@id='home_tasks']/tbody/tr/td[2]/span")).getText();
//        Assert.assertTrue("faddfaasdf", bodyText.contains("Task Added"));

     //   System.out.print(bodyText);



        // going to have to fix this as it won't wait to go to next step w/out sleep command

    }



    @Test( priority = 3 )
    public void testDelete_task() throws Exception{

        MyPortalPageObject.clickOnDescription(driver);
        MyPortalPageObject.waitforEditTaskandclick(driver);
        MyPortalPageObject.waitforstartDateTextBox(driver);
        MyPortalPageObject.clickOnDeleteButton(driver);
        MyPortalPageObject.waitforPortalPage(driver);

       // Assert.assertTrue(MyPortalPageObject.myPortalObject(driver).isDisplayed());
        // must be when text is present


      //  Thread.sleep(2000);
    }

    @Test( priority = 4 )
    public void testLogout() {

        MyPortalPageObject.clickonLogoutButton(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertTrue(LoginPageObject.originTextBox(driver).isDisplayed());

    }



    @AfterTest
    public void tearDown() throws Exception {

        driver.quit();
    }



}