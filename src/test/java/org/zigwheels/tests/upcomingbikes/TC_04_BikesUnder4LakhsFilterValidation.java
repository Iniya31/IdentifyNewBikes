package org.zigwheels.tests.upcomingbikes;

import basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.BikesPage;
import utilities.ExcelUtils;
import utilities.Log;

import java.util.List;

public class TC_04_BikesUnder4LakhsFilterValidation extends BaseTest {

    @Test
    public void verifyBikesUnder4Lakhs() throws Exception {
        Log.info("TC_04 - Under 4 Lakhs Bikes Validation Started");
        BikesPage bikesPage = new BikesPage(driver);
        // Navigate to Upcoming Bikes page and select Honda brand
        bikesPage.clickUpcomingBikes();
        bikesPage.scrollToUpcomingBikesByBrand();
        bikesPage.clickHondaBrand();

        // Fetch Honda bike details
        List<WebElement> bikeNames = bikesPage.getBikeNames();
        List<WebElement> bikePrices = bikesPage.getBikePrices();
        List<WebElement> bikeLaunchDates = bikesPage.getBikeLaunchDates();

        int count = Math.min(bikeNames.size(), Math.min(bikePrices.size(), bikeLaunchDates.size()));
        try {
            Assert.assertTrue(count > 0, "No Honda Bikes Found");
            Log.info("TC_04 - Honda Bike Details Retrieved Successfully");
        } catch (AssertionError e) {
            Log.error("TC_04 - Honda Bike Data Retrieval Failed");
            throw e;
        }
        // Write Honda bike details to Excel
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

        Log.info("Honda Bike Details Written To Excel");
        // Identify bikes priced below 4 lakhs
        int rows = ExcelUtils.getLastRowNumber(fileName, "HondaBikeDetails");
        for (int i = 1; i <= rows; i++) {
            String bikeName = ExcelUtils.getCellValue(fileName, "HondaBikeDetails", i, 0);
            String price = ExcelUtils.getCellValue(fileName, "HondaBikeDetails", i, 1);
            String launchDate = ExcelUtils.getCellValue(fileName, "HondaBikeDetails", i, 2);
            if (price.isEmpty() || price.contains("Price To Be Announced")) {
                continue;
            }
            double actualPrice;
            if (price.contains("Lakh")) {actualPrice = Double.parseDouble(price.replace("Rs.", "").replace("Lakh", "").trim());
            } else {
                actualPrice = Double.parseDouble(price.replace("Rs.", "").replace(",", "").trim()) / 100000;
            }
            // Store bikes priced below 4 lakhs
            if (actualPrice < 4.0) {
                ExcelUtils.appendUnder4LakhBike(fileName, "BikesUnder4Lakhs", bikeName, price, launchDate);
            }
        }

        Log.info("TC_04 - Under 4 Lakhs Bikes Validation Completed");
    }
}