package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;

public class TC_15_GoogleLoginButtonValidation extends BaseTest {

    @Test
    public void verifyGoogleLoginButton() {

        Log.info("TC_15 - Google Login Button Validation Started");

        LoginPage loginPage = new LoginPage(driver);

        // Open login popup
        loginPage.clickLoginRegister();

        // Verify Google Sign-In button visibility
        boolean isVisible = loginPage.isGoogleLoginButtonVisible();

        try {
            Assert.assertTrue(isVisible, "Google sign-in button is not visible!");

            Log.info("TC_15 - Google Login Button Validation Passed");

        } catch (AssertionError e) {
            Log.error("TC_15 - Google Login Button Validation Failed");
            throw e;
        }

        // Close login popup and return to home page
        loginPage.closeOAuthAndReturnHome();
    }
}