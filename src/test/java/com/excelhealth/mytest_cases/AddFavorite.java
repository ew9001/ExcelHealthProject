//package com.excelhealth.mytest_cases;
//
//
//import jxl.Sheet;
//import jxl.Workbook;
//import org.openqa.selenium.*;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.FileInputStream;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.concurrent.TimeUnit;
//
//
//
//@SuppressWarnings("unused")
//public class AddFavorite {
//
//    public WebDriver driver;
//    Sheet s;
//
//    private StringBuffer verificationErrors = new StringBuffer();
//    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//
//    @BeforeClass
//// @org.testng.annotations.Parameters(value={"browser","version","platform"})
//
//    public void beforeClass() throws Exception {
//
//
//        System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
//        System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");
//
//        driver = new ChromeDriver();
//
//        //    driver = new FirefoxDriver();
//        //
//
//    }
//
//
//    @Test
//
//
//    public void usercanaddfavorite() throws Exception {
//
//        FileInputStream fi = new FileInputStream("//Users/earl.willis/Desktop/all-base.xls");
//
//        Workbook w = Workbook.getWorkbook(fi);
//
//        s = w.getSheet(0);
//
//        String myTitle = driver.getTitle();
//
//
//     //   for (int row = 1; row <= s.getRows(); row++) {
//
//       //     String urlname = s.getCell(0, row).getContents();
//
//
//            driver.manage().window().setSize(new Dimension(1440, 1280));
//            driver.get("http://trial.excelhealthportal.com/");
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//            driver.findElement(By.name("Username")).clear();
//            driver.findElement(By.name("Username")).sendKeys("EarlW");
//            driver.findElement(By.name("Password")).clear();
//            driver.findElement(By.name("Password")).sendKeys("upwork");
//            driver.findElement(By.name("Login")).click();
//
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//            Thread.sleep(1000);
//
//
//            driver.findElement(By.linkText("Facilities")).click();
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//            Thread.sleep(1000);
//
//
//            // Turn ON Favorites
//            driver.findElement(By.cssSelector("span.switch-label")).click();
//            Thread.sleep(2000);
//
//            // Assert No data available in table after turning on favorites
//            String blank = driver.findElement(By.cssSelector("td.dataTables_empty")).getText();
//            Assert.assertEquals(blank, "No data available in table");
//            System.out.print(blank);
//            Thread.sleep(1000);
//
//             String recordnumber = driver.findElement(By.xpath("//*[@id='facilitieslookup_info']")).getText();
//             Assert.assertEquals(recordnumber, "Showing 1 to 5 of 5 entries (filtered from 316 total entries)" +
//                     "\n");
//             System.out.print(recordnumber);
//             Thread.sleep(1000);
//
//
//            //Turn OFF Favorites
//            driver.findElement(By.cssSelector("span.switch-label")).click();
//            Thread.sleep(2000);
//
//            //Click on Favorite for Adirondack Medical Center
//
//            driver.findElement(By.cssSelector("img.fav")).click();
//            driver.findElement(By.cssSelector("tr.even > td > div.noborder.favtbl > img.fav")).click();
//            driver.findElement(By.xpath("//img[@onclick='setFav(this,1376577247);']")).click();
//            driver.findElement(By.xpath("//img[@onclick='setFav(this,1659307817);']")).click();
//            driver.findElement(By.xpath("//img[@onclick='setFav(this,1871528620);']")).click();
//            Thread.sleep(2000);
//
//
//            // Turn ON Favorites
//            driver.findElement(By.cssSelector("span.switch-label")).click();
//
//            //  assertTrue(isElementPresent(By.linkText("ADIRONDACK MEDICAL CENTER")));
//
//            Thread.sleep(3000);
//
//            //Turn OFF Favorites to go back and clear out values
//             driver.findElement(By.cssSelector("span.switch-label")).click();
//            Thread.sleep(3000);
//
//
//            // Clear out values
//
//             driver.findElement(By.cssSelector("img.fav")).click();
//             driver.findElement(By.cssSelector("tr.even > td > div.noborder.favtbl > img.fav")).click();
//             driver.findElement(By.xpath("//img[@onclick='setFav(this,1376577247);']")).click();
//
//             driver.findElement(By.xpath("//img[@onclick='setFav(this,1659307817);']")).click();
//             driver.findElement(By.xpath("//img[@onclick='setFav(this,1871528620);']")).click();
//             Thread.sleep(1000);
//
//              // User Logs Out
//              driver.findElement(By.linkText("Logout")).click();
//              driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//              Thread.sleep(1000);
//
//
//    }
//
//
//    @AfterClass
//
//    public void tearDown() throws Exception {
//
//        driver.quit();
//
//    }
//
//}
