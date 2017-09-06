package com.excelhealth.mytest_cases;
 
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.Sheet;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
@SuppressWarnings("unused")
public class AppiumiOSTest {

	private String baseUrl;
	private IOSDriver driver;
	static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	Sheet s;



	@BeforeMethod
	public void setUp() throws IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "9.3"); //Replace this with your iOS version
		caps.setCapability("deviceName", "iPhone 6"); //Replace this with your simulator/device version
		caps.setCapability("app", "safari"); //Replace this with app path in your system
		caps.setCapability("rotatable", true);
		// caps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");

		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		baseUrl = "http://www.cnn.com";


	}

	@Test
	public void testiOS() throws InterruptedException {
		// this.driver.get(baseUrl);


		}



	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}