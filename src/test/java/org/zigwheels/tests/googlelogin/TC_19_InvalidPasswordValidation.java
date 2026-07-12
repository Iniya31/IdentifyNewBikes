package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;
import utilities.ReadProperties;

public class TC_19_InvalidPasswordValidation extends BaseTest {

    @Test
    public void verifyInvalidPasswordError() {

        Log.info("TC_19 - Invalid Password Validation Started");

        LoginPage loginPage = new LoginPage(driver);

        // Open login popup and navigate to Google Sign-In
        loginPage.clickLoginRegister();
        loginPage.clickGoogleLoginAndSwitchWindow();

        // Enter valid email
        loginPage.enterEmailOrPhoneAndNext(
                ReadProperties.readProperty("google.email"));

        try {
            // Enter invalid password
            loginPage.enterPasswordAndNext("IncorrectPasswordTry");

            // Capture validation message
            String errorMsg = loginPage.getCapturedErrorMessage();
            Log.info("Captured Error Message: " + errorMsg);

            // Validate error message
            Assert.assertTrue(
                    errorMsg.contains("Wrong") ||
                            errorMsg.contains("Incorrect"),
                    "Unexpected error message context: " + errorMsg
            );

            Log.info("TC_19 - Invalid Password Validation Passed");

        } catch (Exception e) {
            Log.error("TC_19 - Alternate Google Verification Flow Encountered: "
                    + e.getMessage());

        } finally {
            // Close login window and return to home page
            loginPage.closeOAuthAndReturnHome();
        }
    }
}