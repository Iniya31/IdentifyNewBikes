//changed
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
        Log.info("Under 3 Lakh Cars Validation Started");
        CarsPage cp = new CarsPage(driver);
        // TC_09
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        Log.info("Used Cars Page Opened Successfully");
        // TC_10
        cp.selectChennaiCity();
        Log.info("Chennai City Selected Successfully");
        // TC_11
        cp.scrollToPopularModels();
        int totalSelected = cp.selectAllPopularModels();
        boolean allCarsLoaded = cp.scrollTillAllCarsLoaded();
        Assert.assertTrue(totalSelected > 0, "No Popular Models Selected");
        Assert.assertTrue(allCarsLoaded, "All Cars Not Loaded Successfully");
        List<WebElement> carNames = cp.getCarNames();
        List<WebElement> carPrices = cp.getCarPrices();
        String fileName = "src/test/resources/Details.xlsx";
        int count = Math.min(carNames.size(), carPrices.size());
        for (int i = 0; i < count; i++) {
            String carName = carNames.get(i).getText().trim();
            String price = carPrices.get(i).getText().trim();
            if (!carName.isEmpty()) {
                ExcelUtils.appendCarDetail(fileName, "CarDetails", carName, price);
            }
        }
        Log.info("Car Details Written To Excel Successfully");
        // TC_12
        int lastRow = ExcelUtils.getLastRowNumber(fileName, "CarDetails");
        for (int i = 1; i <= lastRow; i++) {
            String carName = ExcelUtils.getCellValue(fileName, "CarDetails", i, 0);
            String price = ExcelUtils.getCellValue(fileName, "CarDetails", i, 1);
            if (price.isEmpty()) {
                continue;
            }
            double amount;
            if (price.contains("Lakh")) {
                amount =Double.parseDouble(price.replace("Rs.", "").replace("Lakh", "").replace(",", "").trim());
            } else {
                amount = Double.parseDouble(price.replace("Rs.", "").replace(",", "").trim()) / 100000;
            }
            if (amount < 3.0) {
                ExcelUtils.appendUnder3LakhCar(fileName, "Under3LakhCars", carName);
                Log.info("Under 3 Lakh Car : " + carName);
            }
        }
        Log.info("Under3LakhCars Sheet Created Successfully");
    }
}