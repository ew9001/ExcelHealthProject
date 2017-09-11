package com.excelhealth.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyPortalPageObject {
    public static WebElement element = null;


    /**
     * Returns the flight destination text box element
     * @param driver
     * @return
     */
    public static WebElement logoutButton(WebDriver driver) {
        element = driver.findElement(By.linkText("Logout"));

        return element;
    }


    /**
     * Click on logout button
     * @param driver
     */
    public static void clickonLogoutButton(WebDriver driver) {
        element = logoutButton(driver);
        element.click();

    }

    /**
     * Returns Add Task button
     * @param driver
     * @return
     */
    public static WebElement addTaskButton(WebDriver driver) {
        element = driver.findElement(By.tagName("i"));

        return element;
    }


    /**
     * Click on Add Task button
     * @param driver
     */
    public static void clickOnAddTaskButton (WebDriver driver) {
        element = addTaskButton(driver);

        element.click();
    }

    /**
     * Returns MyPortal Object
     * @param driver
     * @return
     */
    public static WebElement myPortalObject(WebDriver driver) {
        element = driver.findElement(By.id("home_myfac_filter"));
         return element;

    }

    public static void waitforPortalPage(WebDriver driver) {

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);
        myWaitVar.until(ExpectedConditions.presenceOfElementLocated(By.id("home_myfac_filter")));


    }



    /**
     * Returns Created Date
     * @param driver
     * @return
     */
    public static WebElement startdateTextBox(WebDriver driver) {
        element = driver.findElement(By.name("created"));
        return element;

    }


    public static void waitforstartDateTextBox(WebDriver driver) {

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);
        WebElement el = myWaitVar.until(ExpectedConditions.elementToBeClickable(startdateTextBox(driver)));
        el.clear();
     //   el.sendKeys(origin);

        //  element.sendKeys(origin);
    }



    public static void fillstartDateTextBox(WebDriver driver, String origin) {


        element = startdateTextBox(driver);

     //   WebDriverWait myWaitVar = new WebDriverWait(driver,20);
     //   WebElement el = myWaitVar.until(ExpectedConditions.elementToBeClickable(startdateTextBox(driver)));
     //   el.clear();
       // element.clear();

        element.sendKeys(origin);
    }


    /**
     * Returns Due Date
     * @param driver
     * @return
     */
    public static WebElement duedateTextBox(WebDriver driver) {
        element = driver.findElement(By.name("duedate"));
        return element;
       // element.clear();

    }

    public static void fillduetDateTextBox(WebDriver driver, String origin) {
        element = duedateTextBox(driver);
        element.clear();
        element.sendKeys(origin);
    }


    /**
     * Returns Due Date
     * @param driver
     * @return
     */
    public static WebElement descrioptionTextBox(WebDriver driver) {
        element = driver.findElement(By.id("description"));

        return element;
    }

    public static void filldescriptionTextBox(WebDriver driver, String origin) {
        element = descrioptionTextBox(driver);
        element.sendKeys(origin);
    }




    /**
     * Returns Notes
     * @param driver
     * @return
     */
    public static WebElement notesTextBox(WebDriver driver) {
        element = driver.findElement(By.id("notes"));
        return element;
    }

    public static void fillnotesTextBox(WebDriver driver, String origin) {
        element = notesTextBox(driver);
        element.sendKeys(origin);
    }

    /**
     * Click onSubmit button
     * @param driver
     */
    public static void clickOnSubmitButton (WebDriver driver) {
        element =  driver.findElement(By.id("save"));
        element.click();
    }


    /**
     * Returns EditTask Button
     * @param driver
     * @return
     */
    public static WebElement EditTaskButton(WebDriver driver) {
        element = driver.findElement(By.cssSelector("div.ui-tooltip-content > div > div.tooltipedit > a.edittask"));
        return element;
    }



    /**
     * Click on Desription in list
     * @param driver
     */
    public static void clickOnDescription (WebDriver driver) {
        element =  driver.findElement(By.xpath("//*[@id='home_tasks']/tbody/tr/td[2]/span"));
        element.click();

    }


   public static void waitforEditTaskandclick (WebDriver driver) {

       WebDriverWait myWaitVar = new WebDriverWait(driver,20);
       WebElement el = myWaitVar.until(ExpectedConditions.elementToBeClickable(EditTaskButton(driver)));
       el.click();

    }


    /**
     * Click on Delete button
     * @param driver
     */
    public static void clickOnDeleteButton (WebDriver driver) {
        element =   driver.findElement(By.id("delete"));
        element.click();
    }



//    /**
//     * Returns the flight origin text box element
//     * @param driver
//     * @return
//     */
//    public static WebElement originTextBox(WebDriver driver) {
//        element = driver.findElement(By.name("Username"));
//        return element;
//    }
//
//
//
//
//
//    //  public static void fillOriginTextBox(WebDriver driver, String origin) {
//    public static void fillOriginTextBox(WebDriver driver, String origin) {
//        element = originTextBox(driver);
//        element.sendKeys(origin);
//    }
//
//    /**
//     * Returns the flight destination text box element
//     * @param driver
//     * @return
//     */
//    public static WebElement destinationTextBox(WebDriver driver) {
//        element = driver.findElement(By.name("Password"));
//        return element;
//    }
//
//    public static void filldestinationTextBox(WebDriver driver, String origin) {
//        element = destinationTextBox(driver);
//        element.sendKeys(origin);
//    }
//
//    /**
//     * Returns the search button box element
//     * @param driver
//     * @return
//     */
//
//
///*

    //
//    /**
//     * Returns the departure date text box element
//     * @param driver
//     * @return
//     */
//    public static WebElement departureDateTextBox(WebDriver driver) {
//        element = driver.findElement(By.id("flight-departing"));
//        return element;
//    }
//
//    /**
//     * Returns the return date text box element
//     * @param driver
//     * @return
//     */
//    public static WebElement returnDateTextBox(WebDriver driver) {
//        element = driver.findElement(By.id("flight-returning"));
//        return element;
//    }



    /**
     * Click on search button
     * @param driver
     */
  //  public static void clickOnSearchButton(WebDriver driver) {
  //      element = searchButton(driver);
   //     element.click();
   // }

    /**
     * Navigate to flights tab
     * @param driver
     */
//    public static void navigateToFlightsTab(WebDriver driver) {
//        driver.findElement(By.id("header-history")).click();
//        element = driver.findElement(By.id("tab-flight-tab"));
//        element.click();
//    }
}


