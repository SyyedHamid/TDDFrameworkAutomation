package com.amazon.pages;

import com.amazon.configurations.amazonConfigurationHW;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

public class amazonhwPage extends amazonConfigurationHW {


    public static void amazonHwHomepage() {
        //use Link Text for the locator
        String homePageVerify = "Best Sellers";
        String actualHomePageText = driver.findElement(By.linkText(homePageVerify)).getText();
        Assert.assertEquals(actualHomePageText, "Best Sellers", "Amazon Home Page not Found");

    }


    public static void typeInSearchBox(String TypeItem) {
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(TypeItem);


    }

    public static void clickOnSearching() {
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

    }

    public static void searchValidItem(String validItem) {
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(validItem);//fix it by call
        clickOnSearching();

    }

    public static void seeBestSellerItems() {
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")).click();

    }

    public static void seeTodaysDeal() {
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[7]")).click();

    }

    public static void SeeHolidaysDeal() {

        driver.findElement(By.xpath("//*[@id=\"nav-holiday\"]")).click();

    }

    public static void SeeMedicalCareService()  {

        driver.findElement(By.xpath("//*[@id=\"nav_link_allhealthingress\"]/span[1]")).click();

    }

    public static void SeeNewReleaseItems() {

        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/i")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[3]/a")).click();

    }

    public static void seeMoversShakers() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driversleep();
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[4]/a")).click();

    }

    public static void subscribeSave() throws InterruptedException{

        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/i")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driversleep();
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[28]/a")).click();

    }

    //*[@id="hmenu-content"]/ul[1]/li[3]/a
}

