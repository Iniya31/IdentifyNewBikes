//package org.zigwheels.tests.bikevalidations;
//
//import basetest.BaseTest;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.zigwheels.pages.BikesPage;
//import utilities.Log;
//
//import static basetest.BaseTest.driver;
//
//public class TC_06_ScootyOnlyValidation extends BaseTest{
//
//        @Test
//        public void verifyUpcomingHondaScootersDetails() {
//
//            Log.info("Upcoming Honda Scooters Validation Started");
//
//            BikesPage bikesPage = new BikesPage(driver);
//
//            bikesPage.clickUpcomingBikes();
//            Log.info("Upcoming Bikes Menu Clicked Successfully");
//
//            bikesPage.clickHondaBrand();
//            Log.info("Honda Brand Selected Successfully");
//
//            bikesPage.printScooterDetails();
//            Log.info("Scooter only option clicked Successfully");
//            Log.info("Scooter Details Printed Successfully");
//
//            Assert.assertTrue(true, "Unable to retrieve scooter details");
//
//            Log.info("Upcoming Honda Scooters Validation Passed");
//        }
//    }
//

package org.zigwheels.tests.bikevalidations;

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
