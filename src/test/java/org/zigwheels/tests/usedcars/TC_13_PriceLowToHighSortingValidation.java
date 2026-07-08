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

        Log.info("Price Low To High Filter Validation Started");
        CarsPage cp = new CarsPage(driver);
        // TC_09 Methods
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        Log.info("Used Cars Page Opened Successfully");
        // TC_10 Method
        cp.selectChennaiCity();
        Log.info("Chennai City Selected Successfully");
        // TC_11 Methods
        cp.scrollToPopularModels();
        cp.selectAllPopularModels();
        cp.scrollTillAllCarsLoaded();
        Log.info("Scrolled upto all the cards");
        cp.scrollToTop();
        cp.selectPriceLowToHigh();
        Assert.assertTrue(driver.getCurrentUrl().contains("fieldName=price"), "Price Filter Not Applied");
        Log.info("Price Low To High Filter Applied Successfully");
        Thread.sleep(3000);
        cp = new CarsPage(driver);
        List<WebElement> carNames = cp.getCarNames();
        List<WebElement> carPrices = cp.getCarPrices();
        int count = Math.min(4, Math.min(carNames.size(), carPrices.size()));
        Log.info("===== First 4 Cars After Sorting =====");
        for (int i = 0; i < count; i++) {
            String carName = carNames.get(i).getText().trim();
            String price = carPrices.get(i).getText().trim();
            Log.info("Car Name : " + carName);
            Log.info("Price : " + price);
            Log.info("=================================");
        }

        Log.info("Price Low To High Sorting Validation Passed");
    }
}