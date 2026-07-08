//changed
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
        Log.info("Popular Models Validation Started");
        CarsPage cp = new CarsPage(driver);
        // TC_09 Steps
        cp.hoverMoreMenu();
        cp.clickUsedCars();
        Log.info("Used Cars Page Opened Successfully");
        // TC_10 Steps
        cp.selectChennaiCity();
        Log.info("Chennai City Selected Successfully");
        // TC_11 Steps
        cp.scrollToPopularModels();
        int totalSelected = cp.selectAllPopularModels();
        boolean allCarsLoaded = cp.scrollTillAllCarsLoaded();
        Assert.assertTrue(totalSelected > 0, "No Popular Models Selected");
        Assert.assertTrue(allCarsLoaded, "All Cars Not Loaded Successfully");
        List<WebElement> carNames = cp.getCarNames();
        List<WebElement> carPrices = cp.getCarPrices();
        int count = Math.min(carNames.size(), carPrices.size());
        String fileName = "src/test/resources/Details.xlsx";
        for (int i = 0; i < count; i++) {
            String carName = carNames.get(i).getText().trim();
            String price = carPrices.get(i).getText().trim();
            if (!carName.isEmpty()) {
                ExcelUtils.appendCarDetail(fileName, "CarDetails", carName, price);
            }
        }
        Log.info("Car Details Written To Excel Successfully");
    }
}