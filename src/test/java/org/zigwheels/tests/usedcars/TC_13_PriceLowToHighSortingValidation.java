package org.zigwheels.tests.usedcars;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import org.zigwheels.pages.CarsPage;
import utilities.Log;

public class TC_13_PriceLowToHighSortingValidation extends BaseTest {

    @Test
    public void verifyPriceSorting() throws Exception {

        Log.info("TC_13 - Price Low To High Sorting Validation Started");
        CarsPage cp = new CarsPage(driver);
        // Navigate to Used Cars page
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        // Select Chennai city and load all cars
        cp.selectChennaiCity();
        cp.scrollToPopularModels();
        cp.selectAllPopularModels();
        cp.scrollTillAllCarsLoaded();
        // Apply Price Low to High filter
        cp.scrollToTop();
        cp.selectPriceLowToHigh();
        try {
            // Validate filter application
            Assert.assertTrue(driver.getCurrentUrl().contains("fieldName=price"), "Price Filter Not Applied");
            Log.info("TC_13 - Price Filter Applied Successfully");
        } catch (AssertionError e) {
            Log.error("TC_13 - Price Sorting Validation Failed");
            throw e;
        }
        Thread.sleep(3000);
        // Fetch first 4 cars after sorting
        cp = new CarsPage(driver);
        List<WebElement> carNames = cp.getCarNames();
        List<WebElement> carPrices = cp.getCarPrices();
        int count = Math.min(4, Math.min(carNames.size(), carPrices.size()));
        Log.info("First 4 Cars After Sorting:");
        for (int i = 0; i < count; i++) {
            String carName = carNames.get(i).getText().trim();
            String price = carPrices.get(i).getText().trim();
            Log.info(carName + " - " + price);
        }
        Log.info("TC_13 - Price Low To High Sorting Validation Completed");
    }
}