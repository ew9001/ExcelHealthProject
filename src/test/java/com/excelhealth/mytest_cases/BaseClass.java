package com.excelhealth.mytest_cases;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.chrome.ChromeOptions;
import java.lang.String;
import java.util.concurrent.TimeUnit;



public class BaseClass {

    WebDriver driver;
    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());




    @BeforeSuite
    public void setupWebDriver() {

        /**
         * This test case will initialize the Webdriver Browser Instance
         */

        System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
        System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");


        ChromeOptions options = new ChromeOptions();
        // options.addArguments("headless");
        // options.addArguments("window-size=1440x1280");

        driver = new ChromeDriver(options);

        // baseUrl = "http://trial.excelhealthportal.com/";
        driver.get("http://trial.excelhealthportal.com/");


        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Reporter.log("=========== Browser Session Started ===========", true);


/*
        driver.get("http://trial.excelhealthportal.com/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/


        Reporter.log("=========== Application Started ==========", true);

    }




    // @BeforeClass

    //  public void setupApplication() {


    /**
     * Log-in to application
     */

    //  objLogin = new Guru99Login(driver);

    //   objLogin.loginToGuru99("EarlW", "upwork");

    //   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


    //     Reporter.log("=========== User logged into Test Environment ===========", true);

    //  }

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

    @AfterSuite
    public void tearDown() throws Exception {

        driver.quit();
    }

}