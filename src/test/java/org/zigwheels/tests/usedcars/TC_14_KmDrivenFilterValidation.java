//changed
package org.zigwheels.tests.usedcars;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import org.zigwheels.pages.CarsPage;
import utilities.Log;

public class TC_14_KmDrivenFilterValidation extends BaseTest {
    @Test
    public void verifyKmDrivenFilter() {
        Log.info("KM Driven Filter Validation Started");
        CarsPage cp = new CarsPage(driver);
        // TC_09
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        Log.info("Used Cars Page Opened Successfully");
        // TC_10
        cp.selectChennaiCity();
        Log.info("Chennai City Selected Successfully");
        // TC_11
        cp.scrollToPopularModels();
        cp.selectAllPopularModels();
        cp.scrollTillAllCarsLoaded();
        Log.info("Scrolled upto all the cards");
        // TC_13
        cp.scrollToTop();
        cp.selectPriceLowToHigh();
        Log.info("Price Low To High Filter Applied");
        // TC_14
        cp.scrollToKmDriven();
        cp.expandKmDrivenFilter();
        cp.selectLessThan5K();
        Log.info("Less Than 5K Filter Applied Successfully");
        Assert.assertTrue(driver.getCurrentUrl().contains("howmuchdriven=0-5000"), "Less Than 5K Filter Not Applied");
        Log.info("KM Driven Filter Validation Passed");
        cp.clickZigWheelsLogo();
        Log.info("ZigWheels Logo Clicked Successfully");
    }
}