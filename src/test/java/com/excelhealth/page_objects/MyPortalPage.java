package com.excelhealth.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyPortalPage {

    WebDriver driver;

    By logout = By.linkText("Logout");


    public MyPortalPage(WebDriver driver){

        this.driver = driver;


    }


    /**
     *  Click Logout
     */

    public void clickLogout(){

    driver.findElement(logout).click();

 }


  //  By password = By.name("Password");

  //  By titleText =By.className("barone");

  //  By login = By.name("Login");
}
