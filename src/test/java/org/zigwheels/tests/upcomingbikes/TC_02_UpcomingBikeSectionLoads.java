package org.zigwheels.tests.upcomingbikes;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.BikesPage;
import utilities.Log;

public class TC_02_UpcomingBikeSectionLoads extends BaseTest {

    @Test
    public void verifyUpcomingBikeSectionLoads() {

        Log.info("TC_02 - Upcoming Bikes Validation Started");
        BikesPage bikesPage = new BikesPage(driver);
        // Navigate to Upcoming Bikes page
        bikesPage.clickUpcomingBikes();
        try {
            // Validate Upcoming Bikes page is loaded
            Assert.assertTrue(driver.getCurrentUrl().contains("upcoming-bikes"), "Upcoming Bikes Page Not Loaded");
            Log.info("TC_02 - Upcoming Bikes Validation Passed");
        } catch (AssertionError e) {
            Log.error("TC_02 - Upcoming Bikes Validation Failed");
            throw e;
        }
    }
}