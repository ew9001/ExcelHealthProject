package com.excelhealth.mytest_cases;

//package extentReports;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.excelhealth.mytest_cases.GetScreenShot;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;


import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import com.relevantcodes.extentreports.LogStatus;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.OutputType;
import java.util.Calendar;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class ExtentReportClass {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest logger;
    WebDriver driver;

    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());


    @BeforeSuite

    public void setupWebDriver() {

        /**
         * This test case will initialize the Webdriver Browser Instance
         */


        System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
        System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");
        System.setProperty("webdriver.safari.driver","//Users/earl.willis/applications/Safari.app");


        ChromeOptions options = new ChromeOptions();
        //  options.addArguments("headless");
        options.addArguments("window-size=1440x1280");

        driver = new ChromeDriver(options);
        //     driver = new SafariDriver();
//
//        FirefoxBinary firefoxBinary = new FirefoxBinary();
//        firefoxBinary.addCommandLineOptions("--headless");








        //   driver = new FirefoxDriver();

        //  baseUrl = "http://trial.excelhealthportal.com/";
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


    @BeforeTest
    public void startReport(){

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/ExtentReport.html");
        //  htmlReporter = new ExtentHtmlReporter("//Users/earl.willis/Desktop/testfolder/STMExtentReport.html");

        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Excel Health Portal");
        extent.setSystemInfo("Environment", "Automation Testing Framework");
        extent.setSystemInfo("User Name", "Excel Health");

        htmlReporter.config().setDocumentTitle("Automation Reports" + timeStamp);
        htmlReporter.config().setReportName("Excel QA Report" + timeStamp);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }



    //This method is to capture the screenshot and return the path of the screenshot.

//      public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
//        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
//        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
//        File finalDestination = new File(destination);
//        FileUtils.copyFile(source, finalDestination);
//        return destination;
//    }
//
//      public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//      //  String myTitle = driver.getTitle();
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            //  FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
//            FileUtils.copyFile(scrFile, new File("//Users/earl.willis/Desktop/testfolder/" + timeStamp + "/" + testResult.getName() + "-"
//                    + Arrays.toString(testResult.getParameters()) + "failed-test" + ".jpg"));
//        }




/*
    @Test
    public void passTest(){
        logger = extent.createTest("passTest");
        Assert.assertTrue(true);
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
    }
    @Test
    public void failTest(){
        logger = extent.createTest("failTest");
        Assert.assertTrue(false);
        logger.log(Status.PASS, "Test Case (failTest) Status is passed");
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN));
    }
    @Test
    public void skipTest(){
        logger = extent.createTest("skipTest");
        throw new SkipException("Skipping - This is not ready for testing ");
    }
*/
 /*   @AfterMethod
  public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            //logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
            //MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        }else if(result.getStatus() == ITestResult.SKIP){
            //logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
    }
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        String myTitle = driver.getTitle();
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //  FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
            FileUtils.copyFile(scrFile, new File("Y://Screenshots/PageLoads/" + timeStamp + "/" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + "failed-test" + ".jpg"));
        }
    }
*/

 @AfterMethod
 public void tearDown(ITestResult result)
 {

// Here will compare if test is failing then only it will enter into if condition
     if(ITestResult.FAILURE==result.getStatus())
     {
         try
         {
// Create refernce of TakesScreenshot
             TakesScreenshot ts=(TakesScreenshot)driver;

// Call method to capture screenshot
             File source=ts.getScreenshotAs(OutputType.FILE);

// Copy files to specific location here it will save all screenshot in our project home directory and
// result.getName() will return name of test case so that screenshot name will be same
             FileUtils.copyFile(source, new File("//Users/earl.willis/Desktop/testfolder/"+result.getName()+".png"));

             System.out.println("Screenshot taken");
         }
         catch (Exception e)
         {

             System.out.println("Exception while taking screenshot "+e.getMessage());
         }



     }
// close application
     driver.quit();
 }






    @AfterTest
    public void endReport(){
        extent.flush();
    }


    @AfterSuite
    public void tearDown() throws Exception {

        driver.quit();
    }

}

