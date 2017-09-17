//package com.excelhealth.mytest_cases;
//
//import java.io.FileInputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.text.SimpleDateFormat;
//
//import java.util.Calendar;
//
//import java.util.concurrent.TimeUnit;
//
//
//
//import jxl.Sheet;
//
//import jxl.Workbook;
//
//
//import org.openqa.selenium.WebDriver;
//
//@SuppressWarnings("unused")
//public class CloudRedirect {
//
//	public static final String USERNAME = "ewillis";
//	public static final String AUTOMATE_KEY = "vnKxs64wV8L1bcWxyzUg";
//	public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
//	private static final CharSequence urlname = null;
//	public WebDriver driver;
//
//
//	Sheet s;
//
//	private StringBuffer verificationErrors = new StringBuffer();
//
//	static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//
//	@BeforeClass
//	@org.testng.annotations.Parameters(value = {"browser", "version", "platform"})
//
//	public void beforeClass(String browser, String version, String platform) throws Exception {
//
//		DesiredCapabilities capability = new DesiredCapabilities();
//		capability.setCapability("platform", platform);
//		capability.setCapability("browserName", browser);
//		capability.setCapability("browserVersion", version);
//		capability.setCapability("Avonex", "P1");
//		capability.setCapability("build", "1.0");
//		capability.setCapability("browserstack.debug", "true");
//		System.out.println("Opening Browser - " + browser + version + platform);
//
//		try {
//			driver = new RemoteWebDriver(
//					new URL("http://adametline1:vnKxs64wV8L1bcWxyzUg@hub.browserstack.com/wd/hub"),
//					capability
//
//			);
//		} catch (MalformedURLException e) {
//
//			e.printStackTrace();
//		}
//
//	}
//
//
//	@Test
//
//	public void laodthepage() throws Exception {
//
//		FileInputStream fi = new FileInputStream("//Users/earl.willis/Desktop/allpagesjustpr.xls");
//
//		Workbook w = Workbook.getWorkbook(fi);
//
//		s = w.getSheet(0);
//
//		String myTitle = driver.getTitle();
//
//		try {
//
//			for (int row = 1; row <= s.getRows(); row++) {
//
//				String urlname = s.getCell(0, row).getContents();
//				String redirectname = s.getCell(1, row).getContents();
//
//				driver.get(urlname);
//
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//				String redirecturl = driver.getCurrentUrl();
//				System.out.println("URL name: " + urlname);
//
//				System.out.println("");
//
//
//				if (redirectname.equals(redirecturl)) {
//
//					System.out.println("------------------------------------------------------");
//					System.out.println("Redirect is working: " + urlname + " redirects to " + redirecturl);
//					System.out.println("------------------------------------------------------");
//
//				} else {
//					System.out.println("------------------------------------------------------");
//					System.out.println("Wrong Redirect: " + urlname + " should redirect to " + redirectname + ". It is currently redirecting to: " + redirecturl);
//					System.out.println("------------------------------------------------------");
//					System.out.println("");
//
//				}
//
//			}
//
//		} catch (Throwable T) {
//
//
//			// driver.quit();
//
//			System.out.println("End of the line");
//		}
//
//	}
//
//	@AfterTest
//
//	public void tearDown() throws Exception {
//
//
//		driver.quit();
//
//	}
//
//}
//
