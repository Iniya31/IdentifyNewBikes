package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;

public class TC_16_InvalidEmailValidation extends BaseTest {

    @Test
    public void verifyInvalidEmailError() {

        Log.info("TC_16 - Invalid Email Validation Started");

        LoginPage loginPage = new LoginPage(driver);

        // Open login popup and navigate to Google Sign-In
        loginPage.clickLoginRegister();
        loginPage.clickGoogleLoginAndSwitchWindow();

        // Enter invalid email and proceed
        loginPage.enterEmailOrPhoneAndNext("invalid_format_text@@xyz.com");

        // Capture validation message
        String errorMsg = loginPage.getCapturedErrorMessage();
        Log.info("Captured Error Message: " + errorMsg);

        try {
            // Validate error message
            Assert.assertTrue(
                    errorMsg.contains("Enter a valid") ||
                            errorMsg.contains("Couldn't find"),
                    "Unexpected error: " + errorMsg
            );

            Log.info("TC_16 - Invalid Email Validation Passed");

        } catch (AssertionError e) {
            Log.error("TC_16 - Invalid Email Validation Failed");
            throw e;
        }

        // Close login window and return to home page
        loginPage.closeOAuthAndReturnHome();
    }
}
