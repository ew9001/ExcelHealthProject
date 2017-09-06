package com.excelhealth.mytest_cases;



import java.io.File;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.concurrent.TimeUnit;



import jxl.Sheet;

import jxl.Workbook;



import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;


@SuppressWarnings("unused")
public class AllPages{
	
	public static final String USERNAME = "testzilla1";
	public static final String AUTOMATE_KEY = "iMLp2LrR4yJmAz1wydtz";
	public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	
	
	
	public WebDriver driver;
	
	
Sheet s;

private StringBuffer verificationErrors = new StringBuffer();

static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());



@BeforeClass
@org.testng.annotations.Parameters(value={"browser","version","platform"})

public void beforeClass(String browser, String version, String platform) throws Exception {
    

	DesiredCapabilities capability = new DesiredCapabilities();
	capability.setCapability("platform", platform);
    capability.setCapability("browserName", browser);
    capability.setCapability("browserVersion", version);
    capability.setCapability("Avonex", "P1");
    capability.setCapability("build", "1.0");
    capability.setCapability("browserstack.debug", "true");
    
    
	System.out.println("Opening Browser  - " + browser + version + platform);
	
    try {
		driver = new RemoteWebDriver(
		  new URL("http://testzilla1:iMLp2LrR4yJmAz1wydtz@hub.browserstack.com/wd/hub"),
		  capability
		  
		);
	} catch (MalformedURLException e) {

		e.printStackTrace();
	}
   //  driver.manage().window().maximize();

}


@Test

public void laodthepage() throws Exception {

FileInputStream fi = new FileInputStream("all.xls");

Workbook w = Workbook.getWorkbook(fi);

s = w.getSheet(0);

String myTitle = driver.getTitle();

try {

for(int row=1; row <=s.getRows();row++) {

String urlname = s.getCell(0, row).getContents();

driver.get(urlname);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().setSize(new Dimension(405,1768));



System.out.println(urlname);

File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(scrFile1, new File("Y://Screenshots/PageLoads/" + timeStamp + "/" + row + "-" + myTitle + "-" + "-testpage.png"));

 //       (new Robot()).keyPress(java.awt.event.KeyEvent.VK_ENTER);
 //        (new Robot()).keyRelease(java.awt.event.KeyEvent.VK_ENTER);
 //        } catch (AWTException e) {
               // TODO Auto-generated catch block
 //               e.printStackTrace();
 //           }



}

} catch (Throwable T) {
    driver.quit();
	System.out.println("End of the line");
}

}


@AfterClass

public void tearDown()  {

 
    driver.quit();


  }


private void fail(String verificationErrorString) {
	// TODO Auto-generated method stub
	
}

}