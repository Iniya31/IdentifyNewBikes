//final
package org.zigwheels.tests.upcomingbikes;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.BikesPage;
import utilities.Log;

public class TC_07_AlertMeButtonValidation extends BaseTest {

    @Test
    public void verifyAlertMeButton()  {

        Log.info("Alert Me Button Validation Started");
        BikesPage bikesPage = new BikesPage(driver);
        bikesPage.clickFirstAlertMeButton();
        Log.info("Alert Me Button Clicked Successfully");
        bikesPage.enterPincode("639111");
        Log.info("Pincode Entered Successfully");
        bikesPage.selectFirstPincodeSuggestion();
        Log.info("Pincode Suggestion Selected Successfully");
        bikesPage.enterFullName("Abarna");
        Log.info("Full Name Entered Successfully");
        bikesPage.enterMobileNumber("9379655918");
        Log.info("Mobile Number Entered Successfully");
//        Thread.sleep(3000);
        Assert.assertTrue(bikesPage.isOtpFieldDisplayed(), "OTP Field Not Displayed");
        Log.info("OTP Field Displayed Successfully");
        bikesPage.clickClosePopupButton();
        Log.info("Popup Closed Successfully");
    }
}