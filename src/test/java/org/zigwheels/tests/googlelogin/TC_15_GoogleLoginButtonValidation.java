package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;

public class TC_15_GoogleLoginButtonValidation extends BaseTest {

    @Test
    public void verifyGoogleLoginButton() {
        Log.info("Google Login Button Validation Started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginRegister();
        Log.info("Login/Register Button Clicked Successfully");
        Assert.assertTrue(loginPage.isGoogleLoginButtonVisible(), "Google sign-in button is not visible!");
        Log.info("Google Sign-In Button Displayed Successfully");
        Log.info("Google Login Button Validation Passed");
        loginPage.closeOAuthAndReturnHome();
        Log.info("Returned To Main Application Window Successfully");

    }
}