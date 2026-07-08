//final
package org.zigwheels.tests.usedcars;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import org.zigwheels.pages.CarsPage;
import utilities.Log;

public class TC_09_UsedCarsSectionLoadValidation extends BaseTest {

    @Test
    public void verifyUsedCarsSectionLoad() {
        Log.info("Used Cars Validation Started");
        CarsPage cp = new CarsPage(driver);
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        String currentUrl = driver.getCurrentUrl();
        Log.info("Current URL : " + currentUrl);
        Assert.assertTrue(currentUrl.contains("used-car"), "Used Cars page is not loaded");
        Log.info("Used Cars Section Loaded Successfully");
    }
}