package com.excelhealth.datadriven;

import java.util.concurrent.TimeUnit;
import com.excelhealth.utilities.Video;
import com.excelhealth.page_objects.LoginPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.excelhealth.utilities.Constants;
import com.excelhealth.utilities.ExcelUtility;


public class InvalidLogin {
     WebDriver driver;
     Video videoReord = new Video ();

        @BeforeClass
        public void setUp() throws Exception {

            System.setProperty("webdriver.gecko.driver", "geckodriver");
            System.setProperty("webdriver.chrome.driver", "chromedriver2");

            ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");

            videoReord.startRecording();

            ChromeOptions options = new ChromeOptions();
            //   options.addArguments("headless");
            options.addArguments("window-size=1440x1280");

            driver = new ChromeDriver(options);

            /*
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile myprofile = profile.getProfile("SecondaryProfile");
            WebDriver driver = new FirefoxDriver(myprofile);
            */


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(Constants.URL);

        }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
        return testData;
    }

    @Test(dataProvider="loginData")
    public void testUsingExcel(String username, String password) throws Exception {
     // logger = extent.createTest("testInvalidLogin");
        LoginPageObject.fillUsernameTextBox (driver, username);
        LoginPageObject.fillpasswordTextBox(driver, password);
        LoginPageObject.clickOnLoginButton (driver);
       // Thread.sleep(1000);

        // Find if error messages exist
        boolean result = driver.findElements(By.xpath("//*[@id='maincontent']/p[1]/font/b")).size() != 0;
        Assert.assertTrue(result);
     // logger.log(Status.PASS, MarkupHelper.createLabel("User name input filled in", ExtentColor.GREEN));
    }

    @AfterClass
    public void tearDown() throws Exception {
        videoReord.stopRecording ();
        driver.quit();
    }
}
