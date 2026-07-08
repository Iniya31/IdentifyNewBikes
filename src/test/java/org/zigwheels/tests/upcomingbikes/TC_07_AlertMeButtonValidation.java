//changed
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

        Log.info("TC_07 Started - Alert Me Button Validation");
        BikesPage bikesPage = new BikesPage(driver);
        bikesPage.clickUpcomingBikes();
        Log.info("Upcoming Bikes Menu Clicked Successfully");
        bikesPage.scrollToUpcomingBikesByBrand();
        Log.info("Scrolled To Upcoming Bikes By Brand Section");
        bikesPage.clickHondaBrand();
        Log.info("Honda Brand Clicked Successfully");
        bikesPage.clickScootersOnly();
        Log.info("Scooters Only Filter Clicked Successfully");
        bikesPage.clickFirstAlertMeButton();
        Log.info("Alert Me Button Clicked Successfully");
        bikesPage.enterPincode(ReadProperties.readProperty("user.pincode"));
        Log.info("Pincode Entered Successfully");
        bikesPage.selectFirstPincodeSuggestion();
        Log.info("Pincode Suggestion Selected Successfully");
        bikesPage.enterFullName(ReadProperties.readProperty("user.name"));
        Log.info("Full Name Entered Successfully");
        bikesPage.enterMobileNumber(ReadProperties.readProperty("user.mobile"));
        Log.info("Mobile Number Entered Successfully");
        Assert.assertTrue(bikesPage.isOtpFieldDisplayed(), "OTP Field Not Displayed");
        Log.info("OTP Field Displayed Successfully");
        bikesPage.clickClosePopupButton();
        Log.info("Popup Closed Successfully");
    }
}