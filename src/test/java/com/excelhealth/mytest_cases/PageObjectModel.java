package com.excelhealth.mytest_cases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.monte.screenrecorder.ScreenRecorder;
import org.testng.annotations.*;
import com.excelhealth.page_objects.LoginPageObject;
import com.excelhealth.page_objects.MyPortalPageObject;


public class PageObjectModel extends ExtentReportClass {



    @Test( priority = 1 )
    public void testLogin () {
        logger = extent.createTest("testLogin");
        LoginPageObject.fillOriginTextBox(driver, "EarlW");
        LoginPageObject.filldestinationTextBox(driver, "upwork");
        LoginPageObject.clickOnSearchButton(driver);

      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);



       // Assert.assertTrue(false);
       // Assert.assertTrue(MyPortalPageObject.myPortalObject(driver).isDisplayed());
        Assert.assertTrue(driver.getPageSource().contains("My Portal"));
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed - passTest", ExtentColor.GREEN));
    }

    @Test( priority = 2 )
    public void testAdd_task() throws Exception{
        logger = extent.createTest("testAddTask");
        Thread.sleep(2);
        MyPortalPageObject.clickOnAddTaskButton(driver);
        MyPortalPageObject.waitforstartDateTextBox(driver);
        MyPortalPageObject.fillstartDateTextBox(driver, "2017-09-25");
        MyPortalPageObject.fillduetDateTextBox(driver, "2017-12-25");
        MyPortalPageObject.setStatus(driver);
        MyPortalPageObject.setPriority(driver);
        MyPortalPageObject.filldescriptionTextBox(driver, "Task Added");
        MyPortalPageObject.fillnotesTextBox(driver,"Note: Inspection starts in 2 weeks");
        MyPortalPageObject.clickOnSubmitButton(driver);

        driver.navigate().refresh();

        Assert.assertTrue(driver.getPageSource().contains("Task Added"));
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
    }


    @Test( priority = 3 )
    public void testDelete_task() {
        logger = extent.createTest("testDeleteTask");
        MyPortalPageObject.clickOnDescription(driver);
        MyPortalPageObject.waitforEditTaskandclick(driver);
        MyPortalPageObject.waitforstartDateTextBox(driver);
        MyPortalPageObject.clickOnDeleteButton(driver);
        MyPortalPageObject.waitforPortalPage(driver);
        driver.navigate().refresh();

        Assert.assertFalse(driver.getPageSource().contains("Task Added"));
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));

    }

    @Test( priority = 4 )
    public void testLogout() {
        logger = extent.createTest("testLogout");
        MyPortalPageObject.clickonLogoutButton(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //  Assert.assertTrue(MyPortalPageObject.addTaskButton(driver).isDisplayed()); - FAIL THE TEST

        Assert.assertTrue(LoginPageObject.originTextBox(driver).isDisplayed());
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));

    }


    @AfterTest
    public void tearDown() throws Exception {

        driver.quit();
    }



}