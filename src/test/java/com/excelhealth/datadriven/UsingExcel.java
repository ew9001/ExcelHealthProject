package com.excelhealth.datadriven;


import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.excelhealth.mytest_cases.BaseClass;
import com.excelhealth.page_objects.LoginPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

        import com.excelhealth.utilities.Constants;
        import com.excelhealth.utilities.ExcelUtility;

public class UsingExcel{
     WebDriver driver;

        @BeforeClass
        public void setUp() throws Exception {

            System.setProperty("webdriver.gecko.driver", "geckodriver");
            System.setProperty("webdriver.chrome.driver", "chromedriver2");

            ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");


            ChromeOptions options = new ChromeOptions();
            //   options.addArguments("headless");
            options.addArguments("window-size=1440x1280");

            driver = new ChromeDriver(options);
          //  driver = new ChromeDriver ();


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(Constants.URL);
       //     driver.findElement(By.xpath("//span[text()='Learn Now']")).click();


        }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
        return testData;
    }

    @Test(dataProvider="loginData")
    public void testUsingExcel(String username, String password) throws Exception {
        LoginPageObject.fillOriginTextBox(driver, username);
        LoginPageObject.filldestinationTextBox(driver, password);
        LoginPageObject.clickOnSearchButton(driver);
        Thread.sleep(2000);

        // Find if error messages exist
        boolean result = driver.findElements(By.xpath("//*[@id='maincontent']/p[1]/font/b")).size() != 0;
        Assert.assertTrue(result);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}