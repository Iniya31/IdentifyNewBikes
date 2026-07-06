package org.zigwheels.tests.upcomingbikes;

import org.testng.annotations.Test;
import utilities.ExcelUtils;
import utilities.Log;

public class TC_04_BikesUnder4LakhsFilterValidation {

    @Test
    public void verifyBikesUnder4Lakhs() throws Exception {
        Log.info("Under 4 Lakhs Bikes Validation Started");
        String fileName = "src/test/resources/Details.xlsx";
        int rows = ExcelUtils.getLastRowNumber(fileName, "HondaBikeDetails");
        for (int i = 1; i <= rows; i++) {
            String bikeName = ExcelUtils.getCellValue(fileName, "HondaBikeDetails", i, 0);
            String price = ExcelUtils.getCellValue(fileName, "HondaBikeDetails", i, 1);
            String launchDate = ExcelUtils.getCellValue(fileName, "HondaBikeDetails", i, 2);
            if (price.isEmpty() || price.contains("Price To Be Announced")) {
                continue;
            }
            double actualPrice;
            if (price.contains("Lakh")) {
                actualPrice = Double.parseDouble(price.replace("Rs.", "").replace("Lakh", "").trim());
            } else {
                actualPrice = Double.parseDouble(price.replace("Rs.", "").replace(",", "").trim()) / 100000;
            }
            if (actualPrice < 4.0) {
                ExcelUtils.appendUnder4LakhBike(fileName, "BikesUnder4Lakhs", bikeName, price, launchDate);
            }
        }
        Log.info("Under 4 Lakhs Bikes Written To Excel Successfully");
    }
}