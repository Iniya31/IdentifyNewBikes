package org.zigwheels.tests.usedcars;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import org.zigwheels.pages.CarsPage;
import utilities.ExcelUtils;
import utilities.Log;

public class TC_11_PopularModelSectionAndDisplayValidation extends BaseTest {

    @Test
    public void verifyPopularModelsSection() throws Exception {

        Log.info("TC_11 - Popular Models Validation Started");
        CarsPage cp = new CarsPage(driver);
        // Navigate to Used Cars page
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        // Select Chennai city
        cp.selectChennaiCity();
        // Select all popular models and load all cars
        cp.scrollToPopularModels();
        int totalSelected = cp.selectAllPopularModels();
        boolean allCarsLoaded = cp.scrollTillAllCarsLoaded();
        try {
            // Validate model selection and car loading
            Assert.assertTrue(totalSelected > 0, "No Popular Models Selected");
            Assert.assertTrue(allCarsLoaded, "All Cars Not Loaded Successfully");
            Log.info("TC_11 - Popular Models Loaded Successfully");
        } catch (AssertionError e) {
            Log.error("TC_11 - Popular Models Validation Failed");
            throw e;
        }
        // Fetch and store car details in Excel
        List<WebElement> carNames = cp.getCarNames();
        List<WebElement> carPrices = cp.getCarPrices();
        int count = Math.min(carNames.size(), carPrices.size());
        String fileName = "src/test/resources/Details_" + getBrowserName() + ".xlsx";
        for (int i = 0; i < count; i++) {
            String carName = carNames.get(i).getText().trim();
            String price = carPrices.get(i).getText().trim();
            if (!carName.isEmpty()) {
                ExcelUtils.appendCarDetail(fileName, "CarDetails", carName, price);
            }
        }
        Log.info("TC_11 - Car Details Written To Excel");
    }
}