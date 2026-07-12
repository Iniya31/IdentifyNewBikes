package org.zigwheels.tests.upcomingbikes;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import utilities.Log;

public class TC_01_TitleValidation extends BaseTest {

    @Test
    public void verifyTitle() {
        Log.info("TC_01 - Title Validation Started");
        // Get page title
        String actualTitle = driver.getTitle();
        Log.info("Page Title: " + actualTitle);
        try {
            // Validate title
            Assert.assertTrue(actualTitle.contains("ZigWheels"), "Title Validation Failed");
            Log.info("TC_01 - Title Validation Passed");
        } catch (AssertionError e) {
            Log.error("TC_01 - Title Validation Failed");
            throw e;
        }
    }
}
