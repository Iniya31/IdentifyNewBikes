package org.zigwheels.tests.upcomingbikes;

import basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.BikesPage;
import utilities.Log;

import java.util.List;

public class TC_08_UpcomingBikesbyBodyTypeValidation extends BaseTest {

    @Test
    public void verifyUpcomingBikesByBodyType() {

        Log.info("TC_08 - Upcoming Bikes By Body Type Validation Started");
        BikesPage bikesPage = new BikesPage(driver);

        // Navigate to Upcoming Bikes by Body Type section
        bikesPage.clickUpcomingBikes();
        bikesPage.scrollToUpcomingBikesByBodyType();

        // Fetch bike body types
        List<WebElement> bodyTypes = bikesPage.getBikeBodyTypes();

        try {
            // Validate body types are available
            Assert.assertTrue(bodyTypes.size() > 0, "No Body Types Found");
            Log.info("Total Body Types Found: " + bodyTypes.size());

        } catch (AssertionError e) {
            Log.error("TC_08 - Upcoming Bikes By Body Type Validation Failed");
            throw e;
        }

        // Print body type names
        int typeCount = 0;
        for (WebElement bodyType : bodyTypes) {
            String type = bodyType.getText().trim();
            if (type.isEmpty()) {
                continue;
            }
            typeCount++;
            Log.info("Body Type " + typeCount + ": " + type);
        }
        Log.info("TC_08 - Upcoming Bikes By Body Type Validation Completed");
    }
}