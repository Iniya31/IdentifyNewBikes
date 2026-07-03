package org.zigwheels.tests.upcomingbikes;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import utilities.Log;

public class TC_01_TitleValidation extends BaseTest {

    @Test
    public void verifyTitle() {

        Log.info("Title Validation Started");
        String actualTitle = driver.getTitle();
        Log.info("Page Title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains("ZigWheels"), "Title Validation Failed");
        Log.info("Title Validation Passed");
    }
}