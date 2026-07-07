package org.zigwheels.tests.upcomingbikes;

import basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.BikesPage;
import utilities.ExcelUtils;
import utilities.Log;

import java.util.List;

public class TC_03_ManufacturerFilterValidation extends BaseTest {

    @Test
    public void verifyHondaManufacturerFilter() throws Exception {
        Log.info("Honda Manufacturer Filter Validation Started");
        BikesPage bikesPage = new BikesPage(driver);
        bikesPage.scrollToUpcomingBikesByBrand();
        Log.info("Scrolled To Upcoming Bikes By Brand Section");
        bikesPage.clickHondaBrand();
        Log.info("Honda Brand Clicked Successfully");
        Assert.assertTrue(driver.getCurrentUrl().contains("upcoming-honda-bikes"), "Honda bikes page not loaded");
        Log.info("Honda Bikes Page Loaded Successfully");
        List<WebElement> bikeNames = bikesPage.getBikeNames();
        List<WebElement> bikePrices = bikesPage.getBikePrices();
        List<WebElement> bikeLaunchDates = bikesPage.getBikeLaunchDates();
        int count = Math.min(bikeNames.size(), Math.min(bikePrices.size(), bikeLaunchDates.size()));
        Assert.assertTrue(count > 0, "No Honda Upcoming Bikes Found");
        String fileName = "src/test/resources/Details.xlsx";
        for (int i = 0; i < count; i++) {
            String bikeName = bikeNames.get(i).getText().trim();
            String price = bikePrices.get(i).getText().trim();
            String launchDate = bikeLaunchDates.get(i).getText().trim();
            if (bikeName.isEmpty() || price.isEmpty() || launchDate.isEmpty()) {
                continue;
            }
            ExcelUtils.appendBikeDetail(fileName, "HondaBikeDetails", bikeName, price, launchDate);
        }
        Log.info("Honda Bike Details Written To Excel Successfully");
    }
}