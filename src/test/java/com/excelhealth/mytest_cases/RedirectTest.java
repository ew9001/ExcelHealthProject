// package com.excelhealth.mytest_cases;
//
//
//
//import java.io.FileInputStream;
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import java.text.SimpleDateFormat;
//
//import java.util.Calendar;
//
//import java.util.concurrent.TimeUnit;
//
//
//
//import jxl.Sheet;
//
//import jxl.Workbook;
//
//
//import org.openqa.selenium.By;
//
//import org.openqa.selenium.WebDriver;
//
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//
// @SuppressWarnings("unused")
//public class RedirectTest{
//
//	private static final SoftAssert Soft_Assert = null;
//	WebDriver driver;
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
//@BeforeTest
//// @org.testng.annotations.Parameters(value={"browser","version","platform"})
//
//public void beforeClass() throws Exception {
//
//
//    driver = new FirefoxDriver();
//
//
//}
//
//
//@Test
//
//public void redirecthepage() throws Exception {
//
//FileInputStream fi = new FileInputStream("allredirect.xls");
//
//Workbook w = Workbook.getWorkbook(fi);
//
//s = w.getSheet(0);
//
//// String myTitle = driver.getTitle();
//
////try {
//
//for(int row=1; row <=s.getRows();row++) {
//
//String urlname = s.getCell(0, row).getContents();
//String redirectname = s.getCell(1, row).getContents();
//
//driver.get(urlname);
//
//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//
//// driver.navigate().refresh();
//
//String redirecturl = driver.getCurrentUrl();
//System.out.println("URL name: " + urlname);
//System.out.println(redirectname);
//
//// System.out.println("");
//// System.out.println("------------------Header information------------------");
//
//
//
//
////driver.get("http://www.contentforest.com/seo-tools/redirect-checker");
////driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////driver.findElement(By.xpath("//input[@type='text']")).clear();
////driver.findElement(By.xpath("//input[@type='text']")).sendKeys(urlname);
////driver.findElement(By.id("button")).click();
//
////driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////String NewResults = driver.findElement(xpath("//html/body/div/div/div[2]/div[4]/div")).getText();
////System.out.println(NewResults);
//
//
//
//
//
//
// //if(redirectname.equals(redirecturl)) {
////	 System.out.println("");
////	 System.out.println("------------------------------------------------------");
////	 System.out.println("Redirect is working: " + urlname + " redirects to " + redirecturl);
////	 System.out.println("------------------------------------------------------");
////	 System.out.println("");
//
//// } else {
//// System.out.println("------------------------------------------------------");
// //System.out.println("Wrong Redirect: " + urlname + " should redirect to " + redirectname + ". It is currently redirecting to: " + redirecturl);
//// System.out.println("------------------------------------------------------");
//// System.out.println("");
//
////}
//
//
//
//
//
//
// //assertEquals(redirecturl + " should be " + redirectname, redirecturl, redirectname);
// //System.out.println(redirectname);
//
//
//
// // ------
//
//
//
//
// //driver.get(baseUrl + "/");
//
//
//
// // System.out.println("RESULTS");
//
// //System.out.println("------------------");
// //System.out.println(Results2);
//
//
//
//// }
//
//
//
////} //catch (Throwable T) {
//
//
////	 driver.quit();
//
////	System.out.println("End of the line");
//}
//
//
//
//}
//
//
//
//private By xpath(String string) {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//
//@AfterTest
//
//public void tearDown() throws Exception {
//
//
//
//    driver.quit();
//
//    String verificationErrorString = verificationErrors.toString();
//
//    if (!"".equals(verificationErrorString)) {
//
//      fail(verificationErrorString);
//
//    }
//
//  }
//
//
//private void fail(String verificationErrorString) {
//	// TODO Auto-generated method stub
//
//}
//
//}