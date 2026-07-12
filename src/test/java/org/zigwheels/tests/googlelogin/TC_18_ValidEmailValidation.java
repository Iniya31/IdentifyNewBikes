package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;
import utilities.ReadProperties;

public class TC_18_ValidEmailValidation extends BaseTest {

    @Test
    public void verifyValidEmailProceeds() {

        Log.info("TC_18 - Valid Email Validation Started");

        LoginPage loginPage = new LoginPage(driver);

        // Open login popup and navigate to Google Sign-In
        loginPage.clickLoginRegister();
        loginPage.clickGoogleLoginAndSwitchWindow();

        // Enter valid email and proceed
        loginPage.enterEmailOrPhoneAndNext(
                ReadProperties.readProperty("google.email"));

        // Close login window and return to home page
        loginPage.closeOAuthAndReturnHome();

        Log.info("TC_18 - Valid Email Validation Completed");
    }
}
