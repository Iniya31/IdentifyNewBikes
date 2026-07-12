package org.zigwheels.tests.usedcars;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import org.zigwheels.pages.CarsPage;
import utilities.Log;

public class TC_10_ChennaiCitySelectionValidation extends BaseTest {

    @Test
    public void verifyChennaiCitySelection() {

        Log.info("TC_10 - Chennai City Selection Validation Started");
        CarsPage cp = new CarsPage(driver);
        // Navigate to Used Cars page
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        // Select Chennai city
        cp.selectChennaiCity();
        String currentUrl = driver.getCurrentUrl();
        try {
            // Validate Chennai city selection
            Assert.assertTrue(currentUrl.toLowerCase().contains("chennai"), "Chennai City Selection Failed");
            Log.info("TC_10 - Chennai City Selection Validation Passed");
        } catch (AssertionError e) {
            Log.error("TC_10 - Chennai City Selection Validation Failed");
            throw e;
        }
    }
}