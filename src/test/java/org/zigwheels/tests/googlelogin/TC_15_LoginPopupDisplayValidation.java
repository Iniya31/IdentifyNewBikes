package org.zigwheels.tests.googlelogin;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.LoginPage;

public class TC_15_LoginPopupDisplayValidation extends BaseTest {

    @Test(description = "Verify that clicking the Login/Register button safely invokes the modal frame authentication overlay wrapper")
    public void verifyLoginPopupDisplay() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLoginRegister();

        boolean isPopupVisible = loginPage.isLoginPopupModalDisplayed();

        Assert.assertTrue(isPopupVisible, "Validation Failure: The Login/Register UI popup failed to display upon clicking header CTA element.");
    }
}