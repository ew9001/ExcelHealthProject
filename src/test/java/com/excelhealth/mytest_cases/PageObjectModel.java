package com.excelhealth.mytest_cases;

import java.util.concurrent.TimeUnit;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import org.openqa.selenium.chrome.ChromeDriver;

import com.excelhealth.page_objects.LoginPageObject;
import com.excelhealth.page_objects.MyPortalPageObject;
import org.openqa.selenium.chrome.ChromeOptions;



// Import package utility.*


public class PageObjectModel {
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
   public void setUp() throws Exception {


        System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
        System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");


        ChromeOptions options = new ChromeOptions();
       // options.addArguments("headless");
       // options.addArguments("window-size=1440x1280");

        driver = new ChromeDriver(options);

         baseUrl = "http://trial.excelhealthportal.com/";


        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() {
        driver.get(baseUrl);
        LoginPageObject.fillOriginTextBox(driver, "EarlW");
        LoginPageObject.filldestinationTextBox(driver, "upwork");
        LoginPageObject.clickOnSearchButton(driver);
    }

    @Test
    public void testLogout() {

        MyPortalPageObject.clickonLogoutButton(driver);
     //   MyPortalPageObject.assertHomePageTitle(driver);
    }



    @AfterTest
    public void tearDown() throws Exception {

        driver.quit();
    }

}
