//changed
package org.zigwheels.tests.Faq;

import basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.BikesPage;
import utilities.Log;

import java.util.List;

public class TC_21_UpcomingHondaBikesFAQsValidation extends BaseTest {

    @Test
    public void verifyUpcomingHondaBikesFAQs() {

        BikesPage bikesPage = new BikesPage(driver);
        bikesPage.clickUpcomingBikes();
        Log.info("Upcoming Bikes Menu Clicked Successfully");
        bikesPage.scrollToUpcomingBikesByBrand();
        Log.info("Scrolled To Upcoming Bikes By Brand Section");
        bikesPage.clickHondaBrand();
        Log.info("Honda Brand Clicked Successfully");
        bikesPage.scrollToUpcomingHondaBikesFAQs();
        Log.info("Scrolled To Upcoming Honda Bikes FAQs Section");
        List<WebElement> faqQuestions = bikesPage.getFaqQuestions();
        Assert.assertTrue(faqQuestions.size() > 0, "No FAQ Questions Found");
        Log.info("Total FAQ Questions Found : " + faqQuestions.size());
        int faqCount = 0;
        for (WebElement question : faqQuestions) {
            String faq = question.getText().trim();
            if (faq.isEmpty()) {
                continue;
            }
            faqCount++;
            Log.info("FAQ " + faqCount + " : " + faq);
            Log.info("=================================");
        }
        Log.info("Total FAQ Questions Printed : " + faqCount);
        Log.info("All FAQ Questions Printed Successfully");

        bikesPage.clickZigWheelsLogo();

        Log.info("ZigWheels Logo Clicked Successfully");
    }
}
