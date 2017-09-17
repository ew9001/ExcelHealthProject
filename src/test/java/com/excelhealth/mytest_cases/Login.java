//package com.excelhealth.mytest_cases;
//
//
//
//import java.io.File;
//
//import java.io.FileInputStream;
//
//import org.openqa.selenium.Dimension;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.JavascriptExecutor;
//import org.testng.ITestResult;
//
//
//import java.util.concurrent.TimeUnit;
//
//
//
//import jxl.Sheet;
//
//import jxl.Workbook;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import java.util.Arrays;
//
//import org.testng.Assert;
//
//
//@SuppressWarnings("unused")
//public class Login{
//
//    public WebDriver driver;
//    Sheet s;
//    private StringBuffer verificationErrors = new StringBuffer();
//    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//
//
//    @BeforeClass
//    // @org.testng.annotations.Parameters(value={"browser","version","platform"})
//
//    public void beforeClass() throws Exception {
//
//
//
//        System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
//        System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");
//
//        driver = new ChromeDriver();
//
//  //    driver = new FirefoxDriver();
//
//    }
//
//
//    @Test
//    public void usercanlogintest() throws Exception {
//
//        FileInputStream fi = new FileInputStream("//Users/earl.willis/Desktop/all-base.xls");
//
//        Workbook w = Workbook.getWorkbook(fi);
//
//        s = w.getSheet(0);
//        String myTitle = driver.getTitle();
//
//
//
//            driver.manage().window().setSize(new Dimension(1440, 1280));
//
//
//            driver.get("http://trial.excelhealthportal.com/");
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//          driver.findElement(By.name("Username")).clear();
//            driver.findElement(By.name("Username")).sendKeys("EarlW");
//            Thread.sleep(500);
//            driver.findElement(By.name("Password")).clear();
//            driver.findElement(By.name("Password")).sendKeys("upwork");
//            driver.findElement(By.name("Login")).click();
//
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//            Thread.sleep(1000);
//
//
//
//
//            driver.findElement(By.linkText("Logout")).click();
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//            Thread.sleep(1000);
//
//
//            // Create the  JavascriptExecutor object
//             JavascriptExecutor jse = (JavascriptExecutor)driver;
//
//            String actual_text = driver.findElement(By.cssSelector("h5")).getText();
//
//            Assert.assertEquals(actual_text, "Welcome to the Excel Health:");
//            System.out.print("The test passed because: The text on the home screen was asserted after the test run " + "Output grabbed from Home Page: " + actual_text);
//
//
//             // GREAT: WebElement element = driver.findElement(By.xpath("//a[contains(text(),'I forgot my password')]"));
//            WebElement element = driver.findElement(By.xpath("html/body/table/tbody/tr[1]/td/h5"));
//            fnHighlightMe(driver,element);
//            Thread.sleep(3000);
//
//
//
//
//            // call the executeScript method
//          //  jse.executeScript("arguments[0].style.border='4px groove green'", actual_text);
//           // Thread.sleep(3000);
//
//
//
//    }
//
//    public static void fnHighlightMe(WebDriver driver,WebElement element) throws InterruptedException {
//        //Creating JavaScriptExecutor Interface
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        for (int iCnt = 0; iCnt < 1; iCnt++) {
//            //Execute javascript
//            js.executeScript("arguments[0].style.border='3px groove green'", element);
//            Thread.sleep(1000);
//            //   js.executeScript("arguments[0].style.border=''", element);
//        }
//
//    }
//
//    @AfterMethod
//    public void vewResult(ITestResult result)
//    {
//        System.out.print("Went to google.com");
//    }
//
//   public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        String myTitle = driver.getTitle();
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//           //  FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
//            FileUtils.copyFile(scrFile, new File("Y://Screenshots/PageLoads/" + timeStamp + "/" + testResult.getName() + "-"
//                    + Arrays.toString(testResult.getParameters()) + "failed-test" + ".jpg"));
//        }
//    }
//
//
//
//    @AfterClass
//
//    public void tearDown() throws Exception {
//
//
//
//        driver.quit();
//
//
//    }
//
//
//
//
//
//}