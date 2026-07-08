//changed
package org.zigwheels.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String rootWindow;

    @FindBy(id = "des_lIcon")
    private WebElement loginBtn;

    @FindBy(xpath = "//span[normalize-space()='Google']")
    private WebElement googleBtn;

    @FindBy(id = "identifierId")
    private WebElement emailBox;

    @FindBy(xpath = "//span[normalize-space()='Next']")
    private WebElement nextBtn;

    @FindBy(xpath = "//input[@name='Passwd']")
    private WebElement passBox;

    @FindBy(xpath = "//div[@class='Ekjuhf Jj6Lae']")
    private WebElement validationErrorContainer;

    @FindBy(xpath = "//span[contains(text(),'Wrong password. Try again or click \"Try another way')]")
    private WebElement passwordErrorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickLoginRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }

    public boolean isGoogleLoginButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(googleBtn));
        return googleBtn.isDisplayed();
    }

    public void clickGoogleLoginAndSwitchWindow() {
        rootWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.visibilityOf(googleBtn));
        googleBtn.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> subWindows = driver.getWindowHandles();
        for (String contextWindow : subWindows) {
            if (!contextWindow.equals(rootWindow)) {
                driver.switchTo().window(contextWindow);
                break;
            }
        }
    }

    public void enterEmailOrPhoneAndNext(String credentials) {
        wait.until(ExpectedConditions.visibilityOf(emailBox));
        emailBox.clear();
        emailBox.sendKeys(credentials);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        nextBtn.click();
    }

    public void enterPasswordAndNext(String textPass) {
        wait.until(ExpectedConditions.visibilityOf(passBox));
        passBox.clear();
        passBox.sendKeys(textPass);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        nextBtn.click();
    }

    public String getCapturedErrorMessage() {

        try {
            wait.until(ExpectedConditions.visibilityOf(validationErrorContainer));
            return validationErrorContainer.getText().trim();
        }
        catch (Exception e) {
            try {
                wait.until(ExpectedConditions.visibilityOf(passwordErrorMessage));
                return passwordErrorMessage.getText().trim();
            }
            catch (Exception ex) {
                return "Error Message Not Found";
            }
        }
    }


    public void closeOAuthAndReturnHome() {

        try {
            if (driver.getWindowHandles().size() > 1) {
                driver.close();
                driver.switchTo().window(rootWindow);
            }
            driver.navigate().refresh();
        } catch (Exception e) {
        }
    }
}