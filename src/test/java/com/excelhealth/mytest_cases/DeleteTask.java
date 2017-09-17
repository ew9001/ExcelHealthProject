//package com.excelhealth.mytest_cases;
//
//
//import jxl.Sheet;
//import jxl.Workbook;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.FileInputStream;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
//
//
//@SuppressWarnings("unused")
//public class DeleteTask {
//
//
//    public WebDriver driver;
//
//    Sheet s;
//
//    private StringBuffer verificationErrors = new StringBuffer();
//
//    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//
//
//    @BeforeClass
//// @org.testng.annotations.Parameters(value={"browser","version","platform"})
//
//    public void beforeClass() throws Exception {
//
//
//// driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
//        System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");
//
//        // driver = new FirefoxDriver();
//        driver = new ChromeDriver();
//    }
//
//
//    @Test
//    public void usercandeletetask() throws Exception {
//
//        FileInputStream fi = new FileInputStream("//Users/earl.willis/Desktop/all-base.xls");
//
//        Workbook w = Workbook.getWorkbook(fi);
//
//        s = w.getSheet(0);
//
//        String myTitle = driver.getTitle();
//
//        driver.manage().window().setSize(new Dimension(1440, 1280));
//        driver.get("http://trial.excelhealthportal.com/");
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.findElement(By.name("Username")).clear();
//        driver.findElement(By.name("Username")).sendKeys("EarlW");
//        driver.findElement(By.name("Password")).clear();
//        driver.findElement(By.name("Password")).sendKeys("upwork");
//        driver.findElement(By.name("Login")).click();
//
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        WebElement dude = driver.findElement(By.xpath("//*[@id='home_tasks']/tbody/tr/td[2]/span"));
//        dude.click();
//
//        WebElement dude3 = driver.findElement(By.cssSelector("div.ui-tooltip-content > div > div.tooltipedit > a.edittask"));
//        dude3.click();
//
//        //  WebDriverWait wait = new WebDriverWait(driver, 30);
//        //  WebElement dude3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ui-tooltip-content > div > div.tooltipedit > a.edittask")));
//
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        Thread.sleep(2000);
//
//        driver.findElement(By.id("delete")).click();
//        Thread.sleep(2000);
//
//    }
//
//        @AfterClass
//
//        public void tearDown () throws Exception {
//            driver.quit();
//
//            String verificationErrorString = verificationErrors.toString();
//
//        }
//
//    }
