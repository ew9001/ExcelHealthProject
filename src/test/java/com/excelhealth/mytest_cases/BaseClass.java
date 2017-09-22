package com.excelhealth.mytest_cases;


import com.excelhealth.utilities.Constants;
import com.excelhealth.utilities.ExcelUtility;
import com.excelhealth.utilities.Video;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.text.SimpleDateFormat;
import java.io.File;
import org.openqa.selenium.OutputType;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class BaseClass extends Video {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest logger;
    WebDriver driver;


    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    @BeforeSuite

    public void setupWebDriver() throws Exception {


        System.setProperty("webdriver.gecko.driver", "geckodriver");
        System.setProperty("webdriver.chrome.driver", "chromedriver2");

        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");

        ChromeOptions options = new ChromeOptions();
       // options.addArguments("headless");
        options.addArguments("window-size=1440x1280");

        driver = new ChromeDriver(options);
        driver.get(Constants.URL);

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Reporter.log("=========== Browser Session Started ===========", true);

        Reporter.log("=========== Application Started ==========", true);

    }

    @BeforeTest
    public void startReport() throws Exception{

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/ExtentReport.html");
        //  htmlReporter = new ExtentHtmlReporter("//Users/earl.willis/Desktop/testfolder/STMExtentReport.html");

        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Excel Health Portal");
        extent.setSystemInfo("Environment", "Test Environment");
        extent.setSystemInfo("User Name", "Excel Health");

        htmlReporter.config().setDocumentTitle("Automation Reports - " + timeStamp);
        htmlReporter.config().setReportName("Excel QA Report - "  + timeStamp);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

        screenRecorder.start();
    }


    /**
     * These methods @Test, will run some random pass/fail/skip scenarios with the Extent Reports, not related to the real tests
     */


    @Test
    public void passTest(){
        logger = extent.createTest("passTest");
        Assert.assertTrue(true);
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
    }
/*    @Test
    public void failTest(){
        logger = extent.createTest("failTest");
        Assert.assertTrue(false);
        logger.log(Status.PASS, "Test Case (failTest) Status is passed");
        logger.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN));
    }
    */
    @Test
    public void skipTest(){
        logger = extent.createTest("skipTest");
        throw new SkipException("Skipping - This is not ready for testing ");
    }



    @AfterMethod

   public void getResult(ITestResult result) {
        if (result.getStatus () == ITestResult.FAILURE) {
            logger.log (Status.FAIL, MarkupHelper.createLabel (result.getName () + " - Test Case Failed", ExtentColor.RED));
            logger.log (Status.FAIL, MarkupHelper.createLabel (result.getThrowable () + " - Test Case Failed", ExtentColor.RED));
        } else if (result.getStatus () == ITestResult.SKIP) {
            //logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
            logger.log (Status.SKIP, MarkupHelper.createLabel (result.getName () + " - Test Case Skipped", ExtentColor.ORANGE));
        }


        /**
         * This method will take a screenshot after a failed test case
         */

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
                FileUtils.copyFile(source, new File("fail/"+result.getName()+".png"));

                System.out.println("Screenshot taken");
            }
            catch (Exception e)
            {

                System.out.println("Exception while taking screenshot "+e.getMessage());
            }

        }

    }


    @AfterTest
    public void endReport() throws Exception{

        extent.flush();
        screenRecorder.stop();

    }

    @AfterSuite
    public void tearDown() throws Exception {


        driver.quit();
    }

}