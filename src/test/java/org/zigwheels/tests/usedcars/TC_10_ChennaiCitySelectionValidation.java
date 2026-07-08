//changed
package org.zigwheels.tests.usedcars;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import org.zigwheels.pages.CarsPage;
import utilities.Log;

public class TC_10_ChennaiCitySelectionValidation extends BaseTest {

    @Test
    public void verifyChennaiCitySelection() {
        Log.info("Chennai City Selection Validation Started");
        CarsPage cp = new CarsPage(driver);
        // TC_09 steps
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        Log.info("Used Cars Page Opened Successfully");
        // TC_10 step
        cp.selectChennaiCity();
        String currentUrl = driver.getCurrentUrl();
        Log.info("Current URL : " + currentUrl);
        Assert.assertTrue(currentUrl.toLowerCase().contains("chennai"), "Chennai City Selection Failed");
        Log.info("Chennai City Selected Successfully");
    }
}