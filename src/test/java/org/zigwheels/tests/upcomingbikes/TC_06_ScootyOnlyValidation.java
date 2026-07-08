//final

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
        Log.info("Scooters Only Validation Started");
        BikesPage bikesPage = new BikesPage(driver);
        bikesPage.clickScootersOnly();
        Log.info("Scooters Only Filter Clicked Successfully");
        List<WebElement> scooterCards = bikesPage.getScooterCards();
        Assert.assertTrue(scooterCards.size() > 0, "No Scooters Found");
        for (WebElement card : scooterCards) {
            String details = card.getText().trim();
            if (details.isEmpty()) {
                continue;
            }
            Log.info(details);
            Log.info("================================");
        }
        Log.info("Scooters Details Printed Successfully");
    }
}
