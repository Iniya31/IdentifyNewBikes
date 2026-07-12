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

        Log.info("TC_03 - Honda Manufacturer Filter Validation Started");

        BikesPage bikesPage = new BikesPage(driver);

        // Navigate to Upcoming Bikes page
        bikesPage.clickUpcomingBikes();

        // Select Honda brand from Upcoming Bikes by Brand section
        bikesPage.scrollToUpcomingBikesByBrand();
        bikesPage.clickHondaBrand();

        // Fetch Honda bike details
        List<WebElement> bikeNames = bikesPage.getBikeNames();
        List<WebElement> bikePrices = bikesPage.getBikePrices();
        List<WebElement> bikeLaunchDates = bikesPage.getBikeLaunchDates();

        int count = Math.min(bikeNames.size(), Math.min(bikePrices.size(), bikeLaunchDates.size()));

        try {
            // Validate bike data is available
            Assert.assertTrue(count > 0, "No Honda Upcoming Bikes Found");
            Log.info("TC_03 - Honda Bikes Retrieved Successfully");
        } catch (AssertionError e) {
            Log.error("TC_03 - Honda Manufacturer Filter Validation Failed");
            throw e;
        }

        // Write bike details to Excel
        String fileName = "src/test/resources/Details_" + getBrowserName() + ".xlsx";
        for (int i = 0; i < count; i++) {
            String bikeName = bikeNames.get(i).getText().trim();
            String price = bikePrices.get(i).getText().trim();
            String launchDate = bikeLaunchDates.get(i).getText().trim();
            if (bikeName.isEmpty() || price.isEmpty() || launchDate.isEmpty()) {
                continue;
            }
            ExcelUtils.appendBikeDetail(fileName, "HondaBikeDetails", bikeName, price, launchDate);
        }
        Log.info("TC_03 - Honda Bike Details Written To Excel");
    }
}