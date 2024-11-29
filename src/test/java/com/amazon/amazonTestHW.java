package com.amazon;

import org.testng.annotations.Test;

import static com.amazon.pages.amazonhwPage.*;
import static com.amazon.pages.amazonhwPage.amazonHwHomepage;


public class amazonTestHW {
    public static  String url = "https://www.amazon.com/";

    @Test(priority = 1)
    /*
    Given, User enter https://www.amazon.com/  in the Chrome browser.
    when, user hit enter, user land on amazon website
    then user verify Amazon Homepage by seeing "Amazon Basic"



     */
    public static void amazonTest() throws InterruptedException {

        getDriver(url);
        amazonHwHomepage();
    }
    @Test(priority = 2)
    /*
    Given, User enter https://www.amazon.com/  in the Chrome browser.
    when, user hit enter, user land on amazon website
    when, user enter valid item inside the Search box and hit enter
    then User able to verify the valid search item list



     */
    public static void searchValidation()throws InterruptedException{
        String validItem="cap";
        getDriver(url);
        driversleep();
        searchValidItem(validItem);
        driverClose();

 }
    @Test(priority = 3)

    /*
    Given, User enter https://www.amazon.com/  in the Chrome browser.
    when, user hit enter, user land on amazon website
    when, user enter valid item inside the Search box and hit enter
    then User able to verify the valid search item list



     */
    public static void searchIcon()throws InterruptedException{
        String TypeItem="pant";
        getDriver(url);
        driversleep();
        typeInSearchBox(TypeItem);
        clickOnSearching();
        driverClose();

    }
    @Test(priority = 4)

    /*
    Given, User enter https://www.amazon.com/  in the Chrome browser.
    when, user hit enter, user land on amazon website
    when, user click on the Best Sellers
    then User able to verify Best Sellers item list



     */
    public static void bestSeller()throws InterruptedException{
        getDriver(url);
        driversleep();
        seeBestSellerItems();
        driverClose();

    }

    @Test(priority = 5)

     /*
    Given, User enter https://www.amazon.com/  in the Chrome browser.
    when, user hit enter, user land on amazon website
    when, user click on the Today's Deal
    then User able to verify Today's Deal item list



     */
    public static void todaysDeal()throws InterruptedException{
        getDriver(url);
        driversleep();
        seeTodaysDeal();
        driverClose();

    }

    @Test(priority = 6)

      /*
    Given, User enter https://www.amazon.com/  in the Chrome browser.
    when, user hit enter, user land on amazon website
    when, user click on the Holiday's Deal
    then User able to verify Holiday's Deal item list



     */
    public static void HolidaysDeal()throws InterruptedException{
        getDriver(url);
        driversleep();
        SeeHolidaysDeal();
        driverClose();

    }
    @Test(priority = 7)

      /*
    Given, User enter https://www.amazon.com/  in the Chrome browser.
    when, user hit enter, user land on amazon website
    when, user click on the Medical Care
    then User able to verify Medical Care item list



     */
    public static void medicare()throws InterruptedException{
        getDriver(url);
        driversleep();
        SeeMedicalCareService();
        driverClose();

    }
    @Test(priority = 8)

      /*
    Given, User enter https://www.amazon.com/  in the Chrome browser.
    when, user hit enter, user land on amazon website
    when, user click on the Menu Icon and select New Release
    then User able to verify New Release item list



     */
    public static void newRelease()throws InterruptedException{
        getDriver(url);
        driversleep();
        SeeNewReleaseItems();
        driverClose();

    }

    @Test(priority = 9)

        /*
    Given, User enter https://www.amazon.com/  in the Chrome browser.
    when, user hit enter, user land on amazon website
    when, user click on the Menu Icon and select Mover & Shaker
    then User able to verify Mover & Shaker item list



     */
    public static void moverAndShaker()throws InterruptedException{
        getDriver(url);
        driversleep();
        seeMoversShakers();
        driverClose();

    }
    @Test(priority = 10)

        /*
    Given, User enter https://www.amazon.com/  in the Chrome browser.
    when, user hit enter, user land on amazon website
    when, user click on the Menu Icon and select subscribe & Save
    then User able to verify subscribe & Save item list



     */
    public static void subscribeAndSave()throws InterruptedException{
        getDriver(url);
        driversleep();
        subscribeSave();
        driverClose();

    }



}