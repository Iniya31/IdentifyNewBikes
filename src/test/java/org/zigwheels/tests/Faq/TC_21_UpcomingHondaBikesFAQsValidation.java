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

        Log.info("TC_21 - Upcoming Honda Bikes FAQs Validation Started");

        BikesPage bikesPage = new BikesPage(driver);

        // Navigate to Honda Upcoming Bikes FAQs section
        bikesPage.clickUpcomingBikes();
        bikesPage.scrollToUpcomingBikesByBrand();
        bikesPage.clickHondaBrand();
        bikesPage.scrollToUpcomingHondaBikesFAQs();

        // Fetch FAQ questions
        List<WebElement> faqQuestions = bikesPage.getFaqQuestions();
        try {
            // Validate FAQ questions are available
            Assert.assertTrue(faqQuestions.size() > 0, "No FAQ Questions Found");
            Log.info("Total FAQ Questions Found: " + faqQuestions.size());
        } catch (AssertionError e) {
            Log.error("TC_21 - Upcoming Honda Bikes FAQs Validation Failed");
            throw e;
        }
        // Print FAQ questions
        int faqCount = 0;
        for (WebElement question : faqQuestions) {
            String faq =question.getText().trim();
            if (faq.isEmpty()) {
                continue;
            }
            faqCount++;
            Log.info("FAQ " + faqCount + ": " + faq);
        }
        Log.info("TC_21 - Upcoming Honda Bikes FAQs Validation Completed");
        // Navigate back to home page
        bikesPage.clickZigWheelsLogo();
    }
}