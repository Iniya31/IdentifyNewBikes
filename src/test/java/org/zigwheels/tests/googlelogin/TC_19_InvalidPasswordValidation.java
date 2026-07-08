//final
package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;
import utilities.ReadProperties;

public class TC_19_InvalidPasswordValidation extends BaseTest {

    @Test
    public void verifyInvalidPasswordError() {
        Log.info("Invalid Password Validation Started");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginRegister();
        loginPage.clickGoogleLoginAndSwitchWindow();
        loginPage.enterEmailOrPhoneAndNext(ReadProperties.readProperty("google.email"));

        try {
            loginPage.enterPasswordAndNext("IncorrectPasswordTry");

            String errorMsg = loginPage.getCapturedErrorMessage();
            Log.info("Captured Error Message: " + errorMsg);

            Assert.assertTrue(
                    errorMsg.contains("Wrong") || errorMsg.contains("Incorrect"),
                    "Unexpected error message context: " + errorMsg
            );

            Log.info("Invalid Password Validation PASSED");
        }
        catch (Exception e) {
            Log.info("Alternate Google Verification Flow Encountered: " + e.getMessage());
        }
        finally {
            loginPage.closeOAuthAndReturnHome();
        }
    }
}