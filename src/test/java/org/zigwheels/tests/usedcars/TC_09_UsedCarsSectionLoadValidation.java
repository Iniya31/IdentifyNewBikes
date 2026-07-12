package org.zigwheels.tests.usedcars;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import org.zigwheels.pages.CarsPage;
import utilities.Log;

public class TC_09_UsedCarsSectionLoadValidation extends BaseTest {

    @Test
    public void verifyUsedCarsSectionLoad() {

        Log.info("TC_09 - Used Cars Section Validation Started");
        CarsPage cp = new CarsPage(driver);
        // Navigate to Used Cars page
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        String currentUrl = driver.getCurrentUrl();
        try {
            // Validate Used Cars page is loaded
            Assert.assertTrue(currentUrl.contains("used-car"), "Used Cars page is not loaded");
            Log.info("TC_09 - Used Cars Section Validation Passed");

        } catch (AssertionError e) {
            Log.error("TC_09 - Used Cars Section Validation Failed");
            throw e;
        }
    }
}