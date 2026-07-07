package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;

public class TC_19_InvalidPasswordValidation extends BaseTest {

    @Test
    public void verifyInvalidPasswordError() {
        Log.info("Invalid Password Validation Started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginRegister();
        Log.info("Login/Register Button Clicked Successfully");
        loginPage.clickGoogleLoginAndSwitchWindow();
        Log.info("Google Login Window Opened Successfully");
        loginPage.enterEmailOrPhoneAndNext("sabarnashinchu@gmail.com");
        Log.info("Valid Email Entered Successfully");
        try {
            loginPage.enterPasswordAndNext("IncorrectPasswordTry");
            Log.info("Invalid Password Entered Successfully");
            String errorMsg = loginPage.getCapturedErrorMessage();
            Log.info("Captured Error Message : " + errorMsg);
            Assert.assertTrue(errorMsg.contains("Wrong") || errorMsg.contains("Incorrect"), "Unexpected error message context: " + errorMsg);
            Log.info("Invalid Password Error Message Validated Successfully");
        } catch (Exception e) {
            String blockScreenText = loginPage.getCapturedErrorMessage();
            Log.info("Handled Email Account Blocked Verification State : " + blockScreenText);
            Assert.assertTrue(blockScreenText.contains("Couldn't find") || blockScreenText.contains("secure"), "Blocked by unexpected screen error: " + blockScreenText);
            Log.info("Blocked Email Verification State Validated Successfully");
        }
        loginPage.closeOAuthAndReturnHome();
        Log.info("Returned To Main Application Window Successfully");
        Log.info("Invalid Password Validation Passed");
    }
}