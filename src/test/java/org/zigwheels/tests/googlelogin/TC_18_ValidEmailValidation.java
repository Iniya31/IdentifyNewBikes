//final
package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;
import utilities.ReadProperties;

public class TC_18_ValidEmailValidation extends BaseTest {

    @Test
    public void verifyValidEmailProceeds() {
        Log.info("Valid Email Validation Started");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginRegister();
        loginPage.clickGoogleLoginAndSwitchWindow();
        loginPage.enterEmailOrPhoneAndNext(ReadProperties.readProperty("google.email"));

        loginPage.closeOAuthAndReturnHome();

        Log.info("Valid Email Validation PASSED");
    }
}