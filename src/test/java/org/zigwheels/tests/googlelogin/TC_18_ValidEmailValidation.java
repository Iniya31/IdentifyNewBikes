package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;

public class TC_18_ValidEmailValidation extends BaseTest {

    @Test
    public void verifyValidEmailProceeds() {
        Log.info("Valid Email Validation Started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginRegister();
        Log.info("Login/Register Button Clicked Successfully");
        loginPage.clickGoogleLoginAndSwitchWindow();
        Log.info("Google Login Window Opened Successfully");
        loginPage.enterEmailOrPhoneAndNext("sabarnashinchu@gmail.com");
        Log.info("Valid Email Entered Successfully");
        loginPage.closeOAuthAndReturnHome();
        Log.info("Returned To Main Application Window Successfully");
        Log.info("Valid Email Validation Passed");

    }
}