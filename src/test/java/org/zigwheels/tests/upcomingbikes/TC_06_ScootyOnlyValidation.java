package org.zigwheels.tests.upcomingbikes;

import basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.BikesPage;
import utilities.Log;

import java.util.List;

public class TC_06_ScootyOnlyValidation extends BaseTest {

    @Test
    public void verifyScootersOnlyDetails() {
        Log.info("TC_06 - Scooters Only Validation Started");
        BikesPage bikesPage = new BikesPage(driver);
        // Navigate to Honda Upcoming Bikes
        bikesPage.clickUpcomingBikes();
        bikesPage.scrollToUpcomingBikesByBrand();
        bikesPage.clickHondaBrand();
        // Apply Scooters Only filter
        bikesPage.clickScootersOnly();
        // Fetch scooter cards
        List<WebElement> scooterCards = bikesPage.getScooterCards();

        try {
            // Validate scooters are available
            Assert.assertTrue(scooterCards.size() > 0, "No Scooters Found");
            Log.info("TC_06 - Scooter Details Retrieved Successfully");

        } catch (AssertionError e) {
            Log.error("TC_06 - Scooters Only Validation Failed");
            throw e;
        }

        // Print scooter details
        for (WebElement card : scooterCards) {
            String details = card.getText().trim();
            if (!details.isEmpty()) {
                Log.info(details);
            }
        }
        Log.info("TC_06 - Scooters Only Validation Completed");
    }
}