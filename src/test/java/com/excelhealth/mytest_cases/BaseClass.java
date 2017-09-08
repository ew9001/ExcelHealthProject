package com.excelhealth.mytest_cases;

import com.excelhealth.page_objects.MyPortalPage;
import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.Assert;
import com.excelhealth.page_objects.MyPortalPage;
import com.excelhealth.page_objects.Guru99Login;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import java.lang.String;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.VideoFormatKeys.*;


public class BaseClass {


    WebDriver driver;
    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());


    MyPortalPage objPortal;
    Guru99Login objLogin;


    @BeforeSuite
    public void setupWebDriver() {

        /**
         * This test case will initialize the Webdriver Browser Instance
         */

        System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
        System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");


        ChromeOptions options = new ChromeOptions();
        // options.addArguments("headless");
        options.addArguments("window-size=1440x1280");
        driver = new ChromeDriver(options);

        Reporter.log("=========== Browser Session Started ===========", true);

        /**
         * Fetch URL and validate application started successfully
         */

        driver.get("http://trial.excelhealthportal.com/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        Reporter.log("=========== Application Started ==========", true);

    }




    @BeforeClass

    public void setupApplication() {


        /**
         * Log-in to application
         */

        objLogin = new Guru99Login(driver);

        objLogin.loginToGuru99("EarlW", "upwork");


        Reporter.log("=========== User logged into Test Environment ===========", true);

    }

//    @AfterMethod
//    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        String myTitle = driver.getTitle();
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            //  FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
//            FileUtils.copyFile(scrFile, new File("Y://Screenshots/PageLoads/" + timeStamp + "/" + testResult.getName() + "-"
//                    + Arrays.toString(testResult.getParameters()) + "failed-test" + ".jpg"));
//        }
//    }

    @AfterClass
    public void close_Application () throws Exception    {
        /**
         * Log-out of application application
         */


        objPortal = new MyPortalPage(driver);
        objPortal.clickLogout();


        Reporter.log("===User is logged OUT of Test Environment ===", true);

        /**
         * Assertion on presence of home page object
         */

        objLogin.assertHomePage();


        driver.quit();

        Reporter.log("=====Browser Session End=====", true);

    }

}
