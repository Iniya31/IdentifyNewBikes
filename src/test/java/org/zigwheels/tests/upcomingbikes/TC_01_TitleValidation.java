//changed
package org.zigwheels.tests.upcomingbikes;

import org.testng.Assert;
import org.testng.annotations.Test;
import basetest.BaseTest;

public class TC_01_TitleValidation extends BaseTest {
    @Test
    public void verifyTitle() {

        String actualTitle = driver.getTitle();
        System.out.println("Page Title : " + actualTitle);
        Assert.assertTrue(actualTitle.contains("ZigWheels"), "Title Validation Failed");
        System.out.println("Title Validation Passed");
    }

}
