package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;

public class TC_17_InvalidPhnValidation extends BaseTest {

    @Test
    public void verifyInvalidPhoneError() {

        Log.info("TC_17 - Invalid Phone Number Validation Started");

        LoginPage loginPage = new LoginPage(driver);

        // Open login popup and navigate to Google Sign-In
        loginPage.clickLoginRegister();
        loginPage.clickGoogleLoginAndSwitchWindow();

        // Enter invalid phone number
        loginPage.enterEmailOrPhoneAndNext("12345");

        // Capture validation message
        String errorMsg = loginPage.getCapturedErrorMessage();
        Log.info("Captured Error Message: " + errorMsg);

        try {
            // Validate that an error message is displayed
            Assert.assertFalse(
                    errorMsg == null || errorMsg.trim().isEmpty(),
                    "No validation message captured"
            );

            Log.info("TC_17 - Invalid Phone Number Validation Passed");

        } catch (AssertionError e) {
            Log.error("TC_17 - Invalid Phone Number Validation Failed");
            throw e;

        } finally {
            // Close login window and return to home page
            loginPage.closeOAuthAndReturnHome();
        }
    }
}