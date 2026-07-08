//final
package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;

public class TC_15_GoogleLoginButtonValidation extends BaseTest {

    @Test
    public void verifyGoogleLoginButton() {
        Log.info("Validating Google Login Button");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginRegister();

        boolean isVisible = loginPage.isGoogleLoginButtonVisible();

        if (isVisible) {
            Log.info("Google Login Button validation PASSED");
        } else {
            Log.error("Google Login Button validation FAILED");
        }

        Assert.assertTrue(isVisible, "Google sign-in button is not visible!");

        loginPage.closeOAuthAndReturnHome();
    }
}