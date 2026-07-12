package org.zigwheels.tests.usedcars;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import org.zigwheels.pages.CarsPage;
import utilities.ExcelUtils;
import utilities.Log;

import java.util.List;

public class TC_12_CarPriceFilterValidation extends BaseTest {

    @Test
    public void verifyCarsUnder3Lakh() throws Exception {
        Log.info("TC_12 - Under 3 Lakh Cars Validation Started");
        CarsPage cp = new CarsPage(driver);
        // Navigate to Used Cars page
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        // Select Chennai city and load all popular model cars
        cp.selectChennaiCity();
        cp.scrollToPopularModels();
        int totalSelected = cp.selectAllPopularModels();
        boolean allCarsLoaded = cp.scrollTillAllCarsLoaded();
        try {
            // Validate models selection and car loading
            Assert.assertTrue(totalSelected > 0, "No Popular Models Selected");
            Assert.assertTrue(allCarsLoaded, "All Cars Not Loaded Successfully");
            Log.info("TC_12 - Popular Models Loaded Successfully");
        } catch (AssertionError e) {
            Log.error("TC_12 - Popular Models Validation Failed");
            throw e;
        }
        // Store car details in Excel
        List<WebElement> carNames = cp.getCarNames();
        List<WebElement> carPrices = cp.getCarPrices();
        String fileName = "src/test/resources/Details_" + getBrowserName() + ".xlsx";
        int count = Math.min(carNames.size(), carPrices.size());
        for (int i = 0; i < count; i++) {
            String carName = carNames.get(i).getText().trim();
            String price = carPrices.get(i).getText().trim();
            if (!carName.isEmpty()) {
                ExcelUtils.appendCarDetail(fileName, "CarDetails", carName, price);
            }
        }
        Log.info("Car Details Written To Excel");
        // Identify cars priced below 3 lakh
        int lastRow = ExcelUtils.getLastRowNumber(fileName, "CarDetails");
        for (int i = 1; i <= lastRow; i++) {
            String carName = ExcelUtils.getCellValue(fileName, "CarDetails", i, 0);
            String price = ExcelUtils.getCellValue(fileName, "CarDetails", i, 1);
            if (price.isEmpty()) {
                continue;
            }
            double amount;
            if (price.contains("Lakh")) {
                amount = Double.parseDouble(price.replace("Rs.", "").replace("Lakh", "").replace(",", "").trim());
            } else {
                amount = Double.parseDouble(price.replace("Rs.", "").replace(",", "").trim()) / 100000;
            }
            // Store cars under 3 lakh
            if (amount < 3.0) {
                ExcelUtils.appendUnder3LakhCar(fileName, "Under3LakhCars", carName);
                Log.info("Under 3 Lakh Car: " + carName);
            }
        }
        Log.info("TC_12 - Under 3 Lakh Cars Validation Completed");
    }
}