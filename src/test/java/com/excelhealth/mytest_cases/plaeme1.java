package com.excelhealth.mytest_cases;


import java.awt.*;
import java.io.File;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class plaeme1 {
    public static ScreenRecorder screenRecorder;

     @BeforeTest
    public static void recording() throws Exception {

        System.setProperty("webdriver.chrome.driver", "chromedriver2");
        System.setProperty("webdriver.gecko.driver", "geckodriver");


        plaeme1 videoReord = new plaeme1();
        videoReord.startRecording();

//        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com");
//
//        WebElement element = driver.findElement(By.name("q"));
//        element.sendKeys("testing");
//        element.submit();
//        System.out.println("Page title is: " +driver.getTitle());
//        driver.quit();
        videoReord.stopRecording();
    }


    public void startRecording() throws Exception
    {

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        this.screenRecorder = new ScreenRecorder(gc,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null);
        this.screenRecorder.start();

    }



    public void stopRecording() throws Exception
    {
        this.screenRecorder.stop();
    }
}