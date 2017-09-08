package com.excelhealth.mytest_cases;

import org.openqa.selenium.WebDriver;
import com.excelhealth.page_objects.MyPortalPage;
import org.testng.annotations.Test;



import javafx.scene.layout.Priority;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeTest;

import com.excelhealth.page_objects.Guru99Login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;


@SuppressWarnings("unused")
public class Login_v2 extends BaseClass {

    WebDriver driver;
    MyPortalPage objPortal;
  //  Guru99Login objLogin;

/*
    @BeforeTest
*/
    /**
     * This test case will login in the base URL for Excel Health
     * Verify login page title as ....
     * Login to application
     * Verify the Welcome page using Dashboard message
     */



       @Test(description="This is my First Test Case after initializer",  priority = 1)
      public void add_task() throws Exception {

          objPortal = new MyPortalPage(driver);
         //  Thread.sleep(2000);

          objPortal.clickTaskstodo();



          System.out.print("I clicked tasks to do");



//       driver.findElement(By.xpath("//table[@id='reportmenutable2']/tbody/tr/td/span/i")).click();
       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       Thread.sleep(2000);

       driver.findElement(By.id("created")).clear();
       driver.findElement(By.id("created")).sendKeys("2017-09-25");
//
//        WebElement wb = driver.findElement(By.name("duedate"));
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        //   jse.executeScript("arguments[0].value='(222)222-2222';", wb);
//        jse.executeScript("document.getElementById('duedate').value='2018-06-15';");
//
//        driver.findElement(By.id("description")).clear();
//        driver.findElement(By.id("description")).sendKeys("First Task");
//        // new Select(driver.findElement(By.id("status"))).selectByVisibleText("On Hold");
//        // new Select(driver.findElement(By.id("priority"))).selectByVisibleText("Low");
//        driver.findElement(By.id("notes")).clear();
//        driver.findElement(By.id("notes")).sendKeys("Test Notes.");
//        driver.findElement(By.id("save")).click();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);




      }


//    @Test(description="This is my Second Test Case after initializer",  priority = 2)
//    public void delete_task() throws Exception {
//
//        Thread.sleep(1000);
//        WebElement dude = driver.findElement(By.xpath("//*[@id='home_tasks']/tbody/tr/td[2]/span"));
//        dude.click();
//
//        WebElement dude3 = driver.findElement(By.cssSelector("div.ui-tooltip-content > div > div.tooltipedit > a.edittask"));
//        dude3.click();
//        Thread.sleep(2000);
//
//        //  WebDriverWait wait = new WebDriverWait(driver, 30);
//        //  WebElement dude3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ui-tooltip-content > div > div.tooltipedit > a.edittask")));
//
//
//        driver.findElement(By.id("delete")).click();
//        Thread.sleep(2000);
//
//    }

/*
    @Test(description="I want to logout",  priority = 3)
    public void logout()   {
        //Create Logout Page object
        /* This won't work becuase UI has duplidate ID's
        objLogout = new Guru99Home(driver);
        objLogout.logoutGuru99();
        driver.findElement(By.linkText("Logout")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String actual_text = driver.findElement(By.cssSelector("h5")).getText();
        Assert.assertEquals(actual_text, "Welcome to the Excel Health:");
        System.out.print("The test passed because: The text on the home screen was asserted after the test run " + "Output grabbed from Home Page: " + actual_text);
*/


}