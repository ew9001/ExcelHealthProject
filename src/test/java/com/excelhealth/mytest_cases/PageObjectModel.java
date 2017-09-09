package com.excelhealth.mytest_cases;

import java.util.concurrent.TimeUnit;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import org.openqa.selenium.chrome.ChromeDriver;

import com.excelhealth.page_objects.LoginPageObject;
import com.excelhealth.page_objects.MyPortalPageObject;
import org.openqa.selenium.chrome.ChromeOptions;



// Import package utility.*


public class PageObjectModel  {
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "//Users/earl.willis/Downloads/chromedriver2");
        System.setProperty("webdriver.gecko.driver", "//Users/earl.willis/Downloads/geckodriver");


        ChromeOptions options = new ChromeOptions();
        // options.addArguments("headless");
        // options.addArguments("window-size=1440x1280");

        driver = new ChromeDriver(options);

        baseUrl = "http://trial.excelhealthportal.com/";
        driver.get(baseUrl);


        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test( priority = 1 )
    public void testLogin() {

        LoginPageObject.fillOriginTextBox(driver, "EarlW");
        LoginPageObject.filldestinationTextBox(driver, "upwork");
        LoginPageObject.clickOnSearchButton(driver);

        if(driver.getPageSource().contains("My Portal")){
            System.out.println("User logged in successfully");

        }else{
            System.out.println("User failed logging im");
        }
    }


    @Test( priority = 2 )
    public void testAddtask() throws Exception{
        driver.findElement(By.tagName("i")).click();
        Thread.sleep(2000);

        MyPortalPageObject.fillstartDateTextBox(driver, "2017-09-25");
        MyPortalPageObject.fillduedateTextBox(driver, "2017-12-25");

     //  driver.findElement(By.xpath("//table[@id='reportmenutable2']/tbody/tr/td/span/i")).click();
      //  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


     //   driver.findElement(By.id("created")).clear();
     //   driver.findElement(By.id("created")).sendKeys("2017-09-25");

     //   driver.findElement(By.xpath("//*[@id='duedate']")).sendKeys("2018-08-22");

        //   driver.findElement(By.id("created")).sendKeys(Keys.TAB);
        //   driver.findElement(By.id("duedate")).sendKeys(Keys.ENTER);


        driver.findElement(By.id("duedate")).clear();

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





// driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }






    @Test( priority = 3 )
    public void testLogout() {

        MyPortalPageObject.clickonLogoutButton(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


      //  Assert.assertThat(LoginPageObject.homepageHeading(driver), is(equalTo("About us!"));
     //   Assert.assertEquals("Welcome to the Excel Health:", driver.findElement(By.cssSelector("h5")));

        if(driver.getPageSource().contains("Welcome to the Excel Health:")){
            System.out.println("User logged out successfully ");

        }else{
            System.out.println("User did not make it to HomePage after logging out");
        }

            //    assertThat(element.getText(), is(equalTo("Welcome to the Excel Health:"));
        //   MyPortalPageObject.assertHomePageTitle(driver);
    }



    @AfterTest
    public void tearDown() throws Exception {

        driver.quit();
    }

}