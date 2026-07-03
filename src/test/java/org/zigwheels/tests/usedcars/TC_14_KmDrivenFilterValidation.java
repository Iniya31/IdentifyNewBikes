package org.zigwheels.tests.usedcars;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import org.zigwheels.pages.CarsPage;
import utilities.Log;

public class TC_14_KmDrivenFilterValidation
        extends BaseTest {

    @Test
    public void verifyKmDrivenFilter() {

        Log.info("KM Driven Filter Validation Started");
        CarsPage cp = new CarsPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("fieldName=price"), "Price Low To High Filter Not Applied");
        Log.info("Price Low To High Filter Already Applied");
        cp.scrollToKmDriven();
        cp.expandKmDrivenFilter();
        cp.selectLessThan5K();
        Log.info("Less Than 5K Filter Applied Successfully");
        Assert.assertTrue(driver.getCurrentUrl().contains("howmuchdriven=0-5000"), "Less Than 5K Filter Not Applied");
        Log.info("KM Driven Filter Validation Passed");
        cp.clickZigWheelsLogo();
        Log.info("ZigWheels Logo Clicked Successfully");
    }
}