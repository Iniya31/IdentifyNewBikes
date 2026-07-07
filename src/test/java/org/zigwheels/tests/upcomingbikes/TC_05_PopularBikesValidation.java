package org.zigwheels.tests.upcomingbikes;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.BikesPage;
import utilities.Log;

import java.util.List;

public class TC_05_PopularBikesValidation extends BaseTest {
    @Test
    public void verifyPopularBikes() {
        Log.info("Popular Bikes Validation Started");
        BikesPage bikesPage = new BikesPage(driver);
        List<WebElement> popularBikes = bikesPage.getPopularBikeCards();
        Assert.assertTrue(popularBikes.size() > 0, "No Popular Bikes Found");
        for (WebElement bike : popularBikes) {
            String bikeName = bike.findElement(By.tagName("a")).getText().trim();
            String bikePrice = bike.getText().replace(bikeName, "").trim();
            Log.info("Bike Name : " + bikeName);
            Log.info("Price : " + bikePrice);
            Log.info("=================================");
        }
        Log.info("Popular Bikes Printed Successfully");
    }
}