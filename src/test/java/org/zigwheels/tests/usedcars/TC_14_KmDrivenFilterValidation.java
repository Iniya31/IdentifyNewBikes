package org.zigwheels.tests.usedcars;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import org.zigwheels.pages.CarsPage;
import utilities.Log;

public class TC_14_KmDrivenFilterValidation extends BaseTest {

    @Test
    public void verifyKmDrivenFilter() {

        Log.info("TC_14 - KM Driven Filter Validation Started");
        CarsPage cp = new CarsPage(driver);
        // Navigate to Used Cars page
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        // Select Chennai city and load all cars
        cp.selectChennaiCity();
        cp.scrollToPopularModels();
        cp.selectAllPopularModels();
        cp.scrollTillAllCarsLoaded();
        // Apply Price Low to High filter
        cp.scrollToTop();
        cp.selectPriceLowToHigh();
        // Apply KM Driven filter - Less Than 5K
        cp.scrollToKmDriven();
        cp.expandKmDrivenFilter();
        cp.selectLessThan5K();
        try {
            // Validate KM Driven filter application
            Assert.assertTrue(driver.getCurrentUrl().contains("howmuchdriven=0-5000"), "Less Than 5K Filter Not Applied");
            Log.info("TC_14 - KM Driven Filter Validation Passed");
        } catch (AssertionError e) {
            Log.error("TC_14 - KM Driven Filter Validation Failed");
            throw e;
        }
        // Navigate back to home page
        cp.clickZigWheelsLogo();
    }
}