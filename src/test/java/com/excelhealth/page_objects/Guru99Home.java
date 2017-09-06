package com.excelhealth.page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Guru99Home {

    /**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;

    @FindBy(id=("btn_home"))
    WebElement logout;

   // loginError = (By.XPATH,'//*[@id="app-wrapper"]/div/div[3]')



    public Guru99Home(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    //Click on logout button

    public void clickLogout(){

       // driver.findElement(logout).click();
        this.logout.click();
      //  logout.click();



    }

    public void logoutGuru99(){
/*
        System.out.print("Right before clicking logout");

        this.clickLogout();
        System.out.print(logout);
        System.out.print("AFTER before clicking logout");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

*/



    }


}