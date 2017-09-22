package com.excelhealth.page_objects;



import com.excelhealth.mytest_cases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPageObject extends BaseClass {
    public static WebElement element = null;

    /**
     * Returns the username text box element
     *
     * @param driver
     * @return
     */
    public static WebElement usernameTextBox(WebDriver driver) {
        element = driver.findElement(By.name("Username"));
        return element;
    }


    public static void fillUsernameTextBox(WebDriver driver, String origin) {
        element = usernameTextBox(driver);
        element.sendKeys(origin);

    }

    /**
     * Returns the password text box element
     *
     * @param driver
     * @return
     */

    public static WebElement passwordTextBox(WebDriver driver) {
        element = driver.findElement(By.name("Password"));
        return element;
    }

    public static void fillpasswordTextBox(WebDriver driver, String origin) {
        element = passwordTextBox(driver);
        element.sendKeys(origin);
    }

    /**
     * Returns the login button box element
     *
     * @param driver
     * @return
     */
    public static WebElement loginButton(WebDriver driver) {
        element = driver.findElement(By.name("Login"));
        return element;
    }




    /**
     * Click on Login button
     * @param driver
     */
    public static void clickOnLoginButton(WebDriver driver) {
        element = loginButton(driver);
        element.click();
    }


}
