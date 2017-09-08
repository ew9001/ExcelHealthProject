package com.excelhealth.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class MyPortalPage {

    WebDriver driver;

    By logout = By.linkText("Logout");

    By addtask = By.tagName("i");

    //  By addtask = By.xpath("//table[@id='reportmenutable2']/tbody/tr/td/span/i");


    public MyPortalPage(WebDriver driver){

        this.driver = driver;


    }


    /**
     *  Click Logout
     */

    public void clickLogout(){

        driver.findElement(logout).click();

    }
    /**
     *  Click Task to Do (+)
     */

    public void clickTaskstodo(){

        driver.findElement(addtask).click();

    }


    //  By password = By.name("Password");

    //  By titleText =By.className("barone");

    //  By login = By.name("Login");
}