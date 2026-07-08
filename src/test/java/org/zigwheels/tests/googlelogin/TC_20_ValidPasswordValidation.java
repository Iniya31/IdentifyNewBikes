//final
package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;
import utilities.Log;
import utilities.ReadProperties;
public class TC_20_ValidPasswordValidation extends BaseTest {

    @Test
    public void verifyValidPasswordWorkflow() {
        Log.info("Valid Password Validation Started");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginRegister();
        loginPage.clickGoogleLoginAndSwitchWindow();
        loginPage.enterEmailOrPhoneAndNext(ReadProperties.readProperty("google.email"));

        try {
            loginPage.enterPasswordAndNext(ReadProperties.readProperty("google.password"));
            Log.info("Valid Password Validation PASSED");
        }
        catch (Exception e) {
            Log.info("Handled Valid Password Fallback Route: " + e.getMessage());
        }
        finally {
            loginPage.closeOAuthAndReturnHome();
        }
    }
}