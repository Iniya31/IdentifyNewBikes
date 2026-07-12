package org.zigwheels.tests.upcomingbikes;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.BikesPage;
import utilities.Log;
import utilities.ReadProperties;

public class TC_07_AlertMeButtonValidation extends BaseTest {

    @Test
    public void verifyAlertMeButton() {

        Log.info("TC_07 - Alert Me Button Validation Started");

        BikesPage bikesPage = new BikesPage(driver);

        // Navigate to Honda Scooters section
        bikesPage.clickUpcomingBikes();
        bikesPage.scrollToUpcomingBikesByBrand();
        bikesPage.clickHondaBrand();
        bikesPage.clickScootersOnly();

        // Open Alert Me popup
        bikesPage.clickFirstAlertMeButton();

        // Enter user details
        bikesPage.enterPincode(ReadProperties.readProperty("user.pincode"));
        bikesPage.selectFirstPincodeSuggestion();
        bikesPage.enterFullName(ReadProperties.readProperty("user.name"));
        bikesPage.enterMobileNumber(ReadProperties.readProperty("user.mobile"));

        try {
            // Validate OTP field is displayed
            Assert.assertTrue(bikesPage.isOtpFieldDisplayed(), "OTP Field Not Displayed");
            Log.info("TC_07 - Alert Me Button Validation Passed");

        } catch (AssertionError e) {
            Log.error("TC_07 - Alert Me Button Validation Failed");
            throw e;

        } finally {
            // Close popup
            bikesPage.clickClosePopupButton();
        }
    }
}