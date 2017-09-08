package com.excelhealth.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class MyPortalPageObject {
    public static WebElement element = null;


    /**
     * Returns the flight destination text box element
     * @param driver
     * @return
     */

    public static WebElement logoutButton(WebDriver driver) {
        element = driver.findElement(By.tagName("i"));
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

//
//    public static WebElement homePageHeading(WebDriver driver) {
//        element = driver.findElement(By.cssSelector("h5"));
//        return element;
//    }
//
//    public static void assertHomePageTitle(WebDriver driver) {
//        element = homePageHeading(driver);
//        return element
//        Assert.assertEquals(homePageHeading(), "Welcome to the Excel Health:");
//
//    }




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


