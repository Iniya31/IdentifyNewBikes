package org.zigwheels.tests.upcomingbikes;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.BikesPage;
import utilities.Log;

public class TC_02_UpcomingBikeSectionLoads extends BaseTest {

    @Test
    public void verifyUpcomingBikeSectionLoads() {
        Log.info("Upcoming Bikes Validation Started");
        BikesPage bikesPage = new BikesPage(driver);
        bikesPage.clickUpcomingBikes();
        Log.info("Upcoming Bikes Menu Clicked Successfully");
        Assert.assertTrue(driver.getCurrentUrl().contains("upcoming-bikes"));
        Log.info("Upcoming Bikes Page Loaded Successfully");
    }
}