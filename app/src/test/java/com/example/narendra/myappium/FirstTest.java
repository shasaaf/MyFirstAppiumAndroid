package com.example.narendra.myappium;

import java.net.MalformedURLException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
// Created object of DesiredCapabilities class.

        capabilities.setCapability("deviceName", "Pixel 2 XL API 27");
// Set android deviceName desired capability. Set your device name.

        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
// Set BROWSER_NAME desired capability. As we are running on Android Emulator, It's Android.

        capabilities.setCapability(CapabilityType.VERSION, "8.1");
// Set Android's OS VERSION @ desired capability.

        capabilities.setCapability("platformName", "Android");
// Set platformName desired capability to Android.

        capabilities.setCapability("appPackage", "com.android.calculator2");
// Set your application's package.

        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
// Set your application's MainActivity.

        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
// Create driver, set the Appium Server details.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void testFirstCalculator() {

        driver.findElement(By.id("digit_4")).click(); // Click on Number 4
        driver.findElement(By.id("op_add")).click(); // Click on Number +
        driver.findElement(By.id("digit_7")).click(); // Click on Number 7
        driver.findElement(By.id("eq")).click(); // Click on Number 11

        driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
    }


    @Test
    public void Sum() {

        System.out.println("Calculate sum of two numbers");
        //Locate elements using By.name() to enter data and click +/= buttons
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("eq")).click();

        // Get the result text
        WebElement sumOfNumbersEle = driver.findElement(By.id("result"));
        String sumOfNumbers = sumOfNumbersEle.getText();

        //verify if result is 3
        Assert.assertTrue(sumOfNumbers.endsWith("3"));
    }

    @After
    public void End() {
        driver.quit();
    }

}