package com.amazon.configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class amazonConfigurationHW {

    public static WebDriver driver;
    public static void getDriver(String url) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    public static void driverClose() throws InterruptedException{
            driver.close();// to close the website from the browser
    }

    public static void driversleep() throws InterruptedException{
        Thread.sleep(1000);//use to keep wait the browser so i can input the code
    }


    }

