//final
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
        loginPage.clickGoogleLoginAndSwitchWindow();
        loginPage.enterEmailOrPhoneAndNext("12345");

        String errorMsg = loginPage.getCapturedErrorMessage();
        Log.info("Captured Error Message: " + errorMsg);

        try {
            Assert.assertFalse(
                    errorMsg == null || errorMsg.trim().isEmpty(),
                    "No validation message captured"
            );
            Log.info("Invalid Phone Number Validation PASSED");
        }
        finally {
            loginPage.closeOAuthAndReturnHome();
        }
    }

}