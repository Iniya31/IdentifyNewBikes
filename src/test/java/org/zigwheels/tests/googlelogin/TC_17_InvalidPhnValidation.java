package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;

public class TC_17_InvalidPhnValidation extends BaseTest {

    @Test
    public void verifyInvalidPhoneError() {
        Log.info("Invalid Phone Number Validation Started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginRegister();
        Log.info("Login/Register Button Clicked Successfully");
        loginPage.clickGoogleLoginAndSwitchWindow();
        Log.info("Google Login Button Clicked And Switched To OAuth Window");
        loginPage.enterEmailOrPhoneAndNext("12345");
        Log.info("Invalid Phone Number Entered Successfully");
        String errorMsg = loginPage.getCapturedErrorMessage();
        Log.info("Captured Error Message : " + errorMsg);
        try {
            Assert.assertTrue(errorMsg.contains("valid") || errorMsg.contains("Couldn't find") || errorMsg.contains("characters you see in the image"), "Unexpected error: " + errorMsg);
        } finally {
            loginPage.closeOAuthAndReturnHome();
            Log.info("Returned To Main Application Window Successfully");
        }
    }
}