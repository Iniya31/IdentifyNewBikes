//changed
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
        BikesPage bikesPage = new BikesPage(driver);
        bikesPage.clickUpcomingBikes();
        Log.info("Upcoming Bikes Menu Clicked Successfully");
        bikesPage.scrollToUpcomingBikesByBodyType();
        Log.info("Scrolled To Upcoming Bikes By Body Type Section");
        List<WebElement> bodyTypes = bikesPage.getBikeBodyTypes();
        Assert.assertTrue(bodyTypes.size() > 0, "No Body Types Found");
        Log.info("Total Body Types Found : " + bodyTypes.size());
        int typeCount = 0;
        for (WebElement bodyType : bodyTypes) {
            String type = bodyType.getText().trim();
            if (type.isEmpty()) {
                continue;
            }
            typeCount++;
            Log.info("Body Type " + typeCount + " : " + type);
            Log.info("==============================");
        }
        Log.info("Total Body Types Printed : " + typeCount);
        Log.info("Upcoming Bikes By Body Type Printed Successfully");
        Log.info("TC_08 Completed Successfully");
    }
}