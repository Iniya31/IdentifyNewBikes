package org.zigwheels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By loginRegisterButton = By.id("des_lIcon");
    private By loginPopupModel = By.xpath("//*[@id=\"myModal3-modal-content\"]/div[1]/div");
    private By googleLoginButton = By.xpath("//div//span[text()='Google']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Clicks on the Login/Register button located in the application header
     */
    public void clickLoginRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(loginRegisterButton)).click();
    }

    /**
     * Checks if the overall Authentication Dialog box modal framework is visible on screen
     * @return boolean tracking element visibility status
     */
    public boolean isLoginPopupModalDisplayed() {
        try {
            // Wait explicitly to ensure transitions/animations have finished rendering
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginPopupModel)).isDisplayed();
        } catch (Exception e) {
            // Secondary fallback verification logic if tracking frame is dynamically loaded
            return driver.findElement(googleLoginButton).isDisplayed();
        }
    }
}
