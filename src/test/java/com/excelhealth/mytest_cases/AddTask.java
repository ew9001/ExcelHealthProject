package com.excelhealth.mytest_cases;


import jxl.Sheet;
import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


@SuppressWarnings("unused")
public class AddTask {


    public WebDriver driver;

    Sheet s;

    private StringBuffer verificationErrors = new StringBuffer();

    static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());



    @BeforeClass
// @org.testng.annotations.Parameters(value={"browser","version","platform"})

    public void beforeClass() throws Exception {


// driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
        System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");

       // driver = new FirefoxDriver();
        driver = new ChromeDriver();
    }


    @Test
    public void usercanaddtask() throws Exception {

      //  FileInputStream fi = new FileInputStream("//Users/earl.willis/Desktop/all-base.xls");

      //  Workbook w = Workbook.getWorkbook(fi);

      //  s = w.getSheet(0);

      //  String myTitle = driver.getTitle();





        //    for(int row=1; row <=s.getRows();row++) {

         //       String urlname = s.getCell(0, row).getContents();


 driver.manage().window().setSize(new Dimension(1440,1280));
                driver.get("http://trial.excelhealthportal.com/");
//driver.get("http://Stage-HHD-Connecting:H4DC0n6898Pq!" + urlname);
//driver.get(urlname);

                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

                driver.findElement(By.name("Username")).clear();
                driver.findElement(By.name("Username")).sendKeys("EarlW");
                              driver.findElement(By.name("Password")).clear();
                driver.findElement(By.name("Password")).sendKeys("upwork");
                driver.findElement(By.name("Login")).click();

                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                Thread.sleep(1000);


                driver.findElement(By.xpath("//table[@id='reportmenutable2']/tbody/tr/td/span/i")).click();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                Thread.sleep(1000);

                driver.findElement(By.id("created")).clear();
                driver.findElement(By.id("created")).sendKeys("2017-09-25");

              //  driver.findElement(By.xpath("//*[@id='duedate']")).sendKeys("2018-08-22");

              //  driver.findElement(By.id("created")).sendKeys(Keys.TAB);
             //   driver.findElement(By.id("duedate")).sendKeys(Keys.ENTER);


            //    driver.findElement(By.id("duedate")).clear();

             //   driver.findElement(By.name("duedate")).sendKeys("2017-08-30");
              //  driver.findElement(By.id("duedate")).click();
              //  driver.findElement(By.id("duedate")).sendKeys("2018-06-15");

             //   WebElement objPh = driver.findElement(By.id("duedate"));
             //   objPh.click();
            //    Thread.sleep(1000);

                WebElement wb = driver.findElement(By.name("duedate"));
                JavascriptExecutor jse = (JavascriptExecutor)driver;
             //   jse.executeScript("arguments[0].value='(222)222-2222';", wb);
                jse.executeScript("document.getElementById('duedate').value='2018-06-15';");



                driver.findElement(By.id("description")).clear();
                driver.findElement(By.id("description")).sendKeys("First Task");
             // new Select(driver.findElement(By.id("status"))).selectByVisibleText("On Hold");
             // new Select(driver.findElement(By.id("priority"))).selectByVisibleText("Low");
                driver.findElement(By.id("notes")).clear();
                driver.findElement(By.id("notes")).sendKeys("Test Notes.");
                driver.findElement(By.id("save")).click();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                Thread.sleep(1000);




// driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            }











    @AfterClass

    public void tearDown() throws Exception {



        driver.quit();

        String verificationErrorString = verificationErrors.toString();



    }

}