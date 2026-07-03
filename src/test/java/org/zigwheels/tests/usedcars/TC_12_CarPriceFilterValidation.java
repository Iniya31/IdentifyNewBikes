package org.zigwheels.tests.usedcars;

import org.testng.annotations.Test;

import basetest.BaseTest;
import utilities.ExcelUtils;
import utilities.Log;

public class TC_12_CarPriceFilterValidation extends BaseTest {

    @Test
    public void verifyCarsUnder3Lakh() throws Exception {
        String fileName = "src/test/resources/Details.xlsx";
        int lastRow = ExcelUtils.getLastRowNumber(fileName, "CarDetails");
        for (int i = 1; i <= lastRow; i++) {
            String carName = ExcelUtils.getCellValue(fileName, "CarDetails", i, 0);
            String price = ExcelUtils.getCellValue(fileName, "CarDetails", i, 1);
            if (price.isEmpty()) {
                continue;
            }
            try {
                double amount;
                if (price.contains("Lakh")) {
                    amount = Double.parseDouble(price.replace("Rs.", "").replace("Lakh", "").replace(",", "").trim());
                }
                else {
                    amount = Double.parseDouble(price.replace("Rs.", "").replace(",", "").trim()) / 100000;
                }
                if (amount < 3.0) {
                    ExcelUtils.appendUnder3LakhCar(fileName, "Under3LakhCars", carName);
                    Log.info("Under 3 Lakh Car : " + carName);
                }
            } catch (Exception e) {
                Log.info("Invalid Price : " + price);
            }
        }
        Log.info("Under3LakhCars Sheet Created Successfully");
    }
}