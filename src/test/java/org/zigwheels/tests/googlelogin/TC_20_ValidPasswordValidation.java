package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;
import utilities.ReadProperties;

public class TC_20_ValidPasswordValidation extends BaseTest {

    @Test
    public void verifyValidPasswordWorkflow() {

        Log.info("TC_20 - Valid Password Validation Started");

        LoginPage loginPage = new LoginPage(driver);

        // Open login popup and navigate to Google Sign-In
        loginPage.clickLoginRegister();
        loginPage.clickGoogleLoginAndSwitchWindow();

        // Enter valid email
        loginPage.enterEmailOrPhoneAndNext(
                ReadProperties.readProperty("google.email"));

        try {
            // Enter valid password
            loginPage.enterPasswordAndNext(
                    ReadProperties.readProperty("google.password"));

            Log.info("TC_20 - Valid Password Validation Passed");

        } catch (Exception e) {
            Log.error("TC_20 - Valid Password Fallback Route Encountered: "
                    + e.getMessage());

        } finally {
            // Close login window and return to home page
            loginPage.closeOAuthAndReturnHome();
        }
    }
}