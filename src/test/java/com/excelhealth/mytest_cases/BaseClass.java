package com.excelhealth.mytest_cases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.Assert;
import com.excelhealth.page_objects.Guru99Home;
import com.excelhealth.page_objects.Guru99Login;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import java.lang.String;

public class BaseClass {


    WebDriver driver;
    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    Guru99Home objHome;
    Guru99Login objLogin;



    @BeforeSuite
    public void setupWebdriver() {

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
        //  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // driver.manage().window().setSize(new Dimension(1440, 1280));

        Reporter.log("=========== Application Started ==========", true);


        /**
         * Log-in to application
         */

    }


    @BeforeTest

    public void setupApplication() {

/*        driver.findElement(By.name("Username")).clear();
        driver.findElement(By.name("Username")).sendKeys("EarlW");
     //   Thread.sleep(500);
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("upwork");
        driver.findElement(By.name("Login")).click();*/

        objLogin = new Guru99Login(driver);

        //login to application
        objLogin.loginToGuru99("EarlW", "upwork");




        //login to application
      //  LoginPage.loginToGuru99("EarlW", "upwork");

        //  LoginPage.loginToGuru99("EarlW", "upwork");











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
    public void close_Application()
    {
        /**
         * Log-out of application application
         */

        objHome = new Guru99Home(driver);
        objHome.clickLogout();

        Reporter.log("===User is logged OUT of Test Environment ===", true);

        /**
         * Assertion on presence of home page object
         */

        //  LoginPage.assertHome();


        driver.quit();



//        String actual_text = driver.findElement(By.cssSelector("h5")).getText();
//        Assert.assertEquals(actual_text, "Welcome to the Excel Health:");
//
//       // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sb_ifc0")));

        // driver.findElement(By.linkText("Logout")).click();
        // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);



        Reporter.log("=====Browser Session End=====", true);

    }

}
