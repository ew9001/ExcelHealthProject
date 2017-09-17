//package com.excelhealth.mytest_cases;
//
//
//import jxl.Sheet;
//import jxl.Workbook;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.concurrent.TimeUnit;
//
//
//@SuppressWarnings("unused")
//public class AllPagesLocalHeadless {
//
//
//	public WebDriver driver;
//
//
//
//
//
//Sheet s;
//
//private StringBuffer verificationErrors = new StringBuffer();
//
//static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//
//
//
//@BeforeClass
//// @org.testng.annotations.Parameters(value={"browser","version","platform"})
//
//public void beforeClass() throws Exception {
//
//
//
//
//// driver = new ChromeDriver();
//
//System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
//System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");
//
//
//
//
////ChromeOptions chromeOptions = new ChromeOptions();
////chromeOptions.addArguments(Arrays.asList("--test-type"));
////DesiredCapabilities capabilities = DesiredCapabilities.chrome();
////capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
////capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//
//// driver = new FirefoxDriver();
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
//
//s = w.getSheet(0);
//
//String myTitle = driver.getTitle();
//
////String browserName = caps.getBrowserName();
//
////String browserVersion = caps.getVersion();
//
////System.out.println(browserName+" "+browserVersion);
//
////System.out.println("==========");
//
//try {
//
//for(int row=1; row <=s.getRows();row++) {
//
//String urlname = s.getCell(0, row).getContents();
//
//
//// driver.manage().window().setSize(new Dimension(375,1280));
//
//driver.get(urlname);
//
//
////driver.get("http://Stage-HHD-Connecting:H4DC0n6898Pq!" + urlname);
////driver.get(urlname);
//
//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//
//
//
//
//// driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
////driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//String browserurlname = driver.getCurrentUrl();
//
//System.out.println(browserurlname);
//// assertEquals(driver.findElement(By.cssSelector("body")).getText(), "patient 404 error page as HTML file");
//
//
//
//
//File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//FileUtils.copyFile(scrFile1, new File("Y://Screenshots/PageLoads/" + timeStamp + "/" + row + "-" + myTitle + "-" + "-webpage.png"));
//
//
//
//}
//
//} catch (Throwable T) {
//
//
//	 driver.quit();
//
//	System.out.println("End of the line");
//}
//
//}
//
//
//
//@AfterClass
//
//public void tearDown() throws Exception {
//
//
//
//    driver.quit();
//
//    String verificationErrorString = verificationErrors.toString();
//
//
//
//  }
//
//}