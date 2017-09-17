//package com.excelhealth.mytest_cases;
//
//
//import java.io.File;
//
//import java.io.FileInputStream;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import java.text.SimpleDateFormat;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.Calendar;
//
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//
//
//import jxl.Sheet;
//
//import jxl.Workbook;
//import org.testng.Assert;
//
//
//
//import org.apache.commons.io.FileUtils;
//
//import org.openqa.selenium.OutputType;
//
//import org.openqa.selenium.TakesScreenshot;
//
//import org.openqa.selenium.WebDriver;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//@SuppressWarnings("unused")
//public class AllPagesLocal{
//
//
//	public WebDriver driver;
//
//
//Sheet s;
//
//private StringBuffer verificationErrors = new StringBuffer();
//
//static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//
//
//@BeforeClass
//// @org.testng.annotations.Parameters(value={"browser","version","platform"})
//
//
//public void beforeClass() throws Exception {
//
//// driver = new ChromeDriver();
//
//System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
//System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");
//
////ChromeOptions chromeOptions = new ChromeOptions();
////chromeOptions.addArguments(Arrays.asList("--test-type"));
////DesiredCapabilities capabilities = DesiredCapabilities.chrome();
////capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
////capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//
// driver = new ChromeDriver();
//
//}
//
//
//@Test
//
//public void Login() throws Exception {
//
//
//FileInputStream fi = new FileInputStream("//Users/earl.willis/Desktop/all.xls");
//
//Workbook w = Workbook.getWorkbook(fi);
//    s = w.getSheet(0);
//
//String myTitle = driver.getTitle();
//
// try {
//
//for(int row=1; row <=s.getRows();row++) {
//
//String urlname = s.getCell(0, row).getContents();
//
//
//driver.get(urlname);
//
// //   WebDriverWait wait = new WebDriverWait(dr, 30);
// //   wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
////Functions.waitForPageLoaded(driver);
//
//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//
//String browserurlname = driver.getCurrentUrl();
//
//System.out.println(browserurlname);
//// assertEquals(driver.findElement(By.cssSelector("body")).getText(), "patient 404 error page as HTML file");
//
//File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//FileUtils.copyFile(scrFile1, new File("Y://Screenshots/PageLoads/" + timeStamp + "/" + row + "-" + myTitle + "-" + "-webpage.png"));
//
//
//    if (urlname != null) {
//       System.out.println("Continue");
//    }
//    else {
//        System.out.println("Driver quit because I hit the last line in the spreadsheet and it as null");
//        driver.quit();
//    }
//}
//
//} catch (Throwable t) {
// 	 driver.quit();
//
//	System.out.println("");
//}
//
//}
//    //interacted with Functions.above
//    public static void waitForPageLoaded(WebDriver driver) {
//
//        ExpectedCondition<Boolean> expectation = new
//                ExpectedCondition<Boolean>() {
//                    public Boolean apply(WebDriver driver) {
//                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
//                    }
//                };
//
//        WebDriverWait wait = new WebDriverWait(driver,30);
//        try {
//            wait.until(expectation);
//        } catch(Throwable error) {
//            Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
//        }
//    }
//
//
//    @AfterClass
//public void tearDown() throws Exception {
//
//    driver.quit();
//
//    String verificationErrorString = verificationErrors.toString();
//
//  }
//
//}