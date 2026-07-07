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

        Log.info("Upcoming Honda Bikes FAQs Validation Started");
        BikesPage bikesPage = new BikesPage(driver);
        bikesPage.scrollToUpcomingHondaBikesFAQs();
        Log.info("Scrolled To Upcoming Honda Bikes FAQs Section");
        List<WebElement> faqQuestions = bikesPage.getFaqQuestions();
        Assert.assertTrue(faqQuestions.size() > 0, "No FAQ Questions Found");
        for (WebElement question : faqQuestions) {
            String faq = question.getText().trim();
            if (faq.isEmpty()) {
                continue;
            }
            Log.info("FAQ : " + faq);
            Log.info("================================");
        }
        Log.info("All FAQ Questions Printed Successfully");
        bikesPage.clickZigWheelsLogo();

    }
}