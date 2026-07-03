package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;

public class TC_16_InvalidEmailValidation extends BaseTest {
    @Test
    public void verifyInvalidEmailError() {
        Log.info("Invalid Email Validation Started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginRegister();
        Log.info("Login/Register Button Clicked Successfully");
        loginPage.clickGoogleLoginAndSwitchWindow();
        Log.info("Google Login Button Clicked And Switched To OAuth Window");
        loginPage.enterEmailOrPhoneAndNext("invalid_format_text@@xyz.com");
        Log.info("Invalid Email Entered Successfully");
        String errorMsg = loginPage.getCapturedErrorMessage();
        Log.info("Captured Error Message : " + errorMsg);
        Assert.assertTrue(errorMsg.contains("Enter a valid") || errorMsg.contains("Couldn't find"), "Unexpected error: " + errorMsg);
        Log.info("Invalid Email Error Message Validated Successfully");
        loginPage.closeOAuthAndReturnHome();
        Log.info("Returned To Main Application Window Successfully");
        Log.info("Invalid Email Validation Passed");

    }
}