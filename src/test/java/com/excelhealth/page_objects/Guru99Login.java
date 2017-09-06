package com.excelhealth.page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class Guru99Login {

    WebDriver driver;

    By username = By.name("Username");

    By password = By.name("Password");

    By titleText =By.className("barone");

    By login = By.name("Login");




    public Guru99Login(WebDriver driver){

       this.driver = driver;


    }

    /**
     *  Set UserName
     */

    public void setUserName(String strUserName){

        driver.findElement(username).sendKeys(strUserName);


    }

    /**
     *  Set Password
     */

    //Set password in password textbox

    public void setPassword(String strPassword){

        driver.findElement(password).sendKeys(strPassword);

    }

    /**
     *  Click the Login button
     */

    //Click on login button

    public void clickLogin(){

        driver.findElement(login).click();

    }


    /**
     * Will Click the logout button
     */

    public void clickLogout(){

        driver.findElement(By.linkText("Logout")).click();

    }


    /**
     * Use this interface when you have a title on your home page. I'm asserting on the H5
     */


    /**
     * Assert Home Page H5  'Welcome to the Excel Health:'
     */

    public void assertHomePage (){


//        String actualTitle = driver.getTitle();

        String actualTitle = driver.findElement(By.cssSelector("h5")).getText();
        Assert.assertEquals(actualTitle, "Welcome to the Excel Health:");

    }



    //Get the title of Login Page

    public String getLoginTitle(){

        return    driver.findElement(titleText).getText();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginToGuru99(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();

       // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);





    }

}