package org.zigwheels.tests.bikevalidations;

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

        Log.info("Upcoming Bikes By Body Type Validation Started");

        BikesPage bikesPage = new BikesPage(driver);

        bikesPage.scrollToUpcomingBikesByBodyType();

        Log.info(
                "Scrolled To Upcoming Bikes By Body Type Section");

        List<WebElement> bodyTypes =
                bikesPage.getBikeBodyTypes();

        Assert.assertTrue(
                bodyTypes.size() > 0,
                "No Body Types Found");

        for (WebElement bodyType : bodyTypes) {

            String type =
                    bodyType.getText().trim();

            if (type.isEmpty()) {
                continue;
            }

            Log.info("Body Type : " + type);
            Log.info("==============================");
        }

        Log.info(
                "Upcoming Bikes By Body Type Printed Successfully");
    }
}