//changed
package org.zigwheels.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BikesPage {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//span[contains(text(),'NEW BIKES')]")
    private WebElement newBikesMenu;

    @FindBy(xpath = "//a[@title='Upcoming Bikes']")
    private WebElement upcomingBikesLink;


    @FindBy(xpath = "//h3[contains(text(),'Upcoming Bikes by Brand')]")
    private WebElement upcomingBikesByBrandSection;

    @FindBy(xpath = "//a[@title='upcoming Honda bikes']")
    private WebElement hondaBrand;


    @FindBy(xpath = "//strong")
    private List<WebElement> bikeNames;

    @FindBy(xpath = "//div[contains(@class,'fnt-15')]")
    private List<WebElement> bikePrices;

    @FindBy(xpath = "//div[contains(text(),'Expected Launch')]")
    private List<WebElement> bikeLaunchDates;

    @FindBy(xpath = "//h2[contains(text(),'Popular Bikes in India')]/following-sibling::ul/li")
    private List<WebElement> popularBikeCards;

    @FindBy(id = "Scooters")
    private WebElement scootersOnlyFilter;

    @FindBy(xpath = "//ul[@id='modelList']/li")
    private List<WebElement> scooterCards;

    @FindBy(xpath = "(//span[contains(text(),'Alert Me When Launched')])[1]")
    private WebElement firstAlertMeButton;

    @FindBy(id = "popupcityName")
    private WebElement pincodeTextBox;

    @FindBy(xpath = "//li[contains(@class,'gs_ta_choice')][1]")
    private WebElement firstPincodeSuggestion;

    @FindBy(xpath = "//input[contains(@name,'userName')]")
    private WebElement fullNameTextBox;

    @FindBy(xpath = "//input[contains(@name,'mobileNo')]")
    private WebElement mobileNumberTextBox;

    @FindBy(xpath = "//div[contains(@class,'otpBox')]")
    private WebElement otpSection;

    @FindBy(id = "usedcar_lead_popup")
    private WebElement closePopupButton;

    @FindBy(xpath = "//h2[contains(text(),'Upcoming Bikes by Body Type')]")
    private WebElement upcomingBikesByBodyTypeSection;

    @FindBy(xpath = "//ul[contains(@class,'subsnav-list')]/li")
    private List<WebElement> bikeBodyTypes;

    @FindBy(xpath = "//h2[contains(text(),'Upcoming Honda Bikes FAQs')]")
    private WebElement upcomingHondaBikesFaqSection;

    @FindBy(xpath = "//div[@class='accordion']//h3")
    private List<WebElement> faqQuestions;

    @FindBy(xpath = "//a[contains(@class,'zw-srch-logo')]")
    private WebElement zigWheelsLogo;

    public BikesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickUpcomingBikes() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(newBikesMenu));
        actions.moveToElement(newBikesMenu).perform();
        WebElement upcomingBike = wait.until(ExpectedConditions.elementToBeClickable(upcomingBikesLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", upcomingBike);
    }


    public void scrollToUpcomingBikesByBrand() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.visibilityOf(upcomingBikesByBrandSection));
    }

    public void clickHondaBrand() {

        wait.until(ExpectedConditions.visibilityOf(hondaBrand));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hondaBrand);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-200)");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hondaBrand);
    }

    public List<WebElement> getBikeNames() {
        wait.until(ExpectedConditions.visibilityOfAllElements(bikeNames));
        return bikeNames;
    }
    public List<WebElement> getBikePrices() {
        wait.until(ExpectedConditions.visibilityOfAllElements(bikePrices));
        return bikePrices;
    }

    public List<WebElement> getBikeLaunchDates() {

        wait.until(ExpectedConditions.visibilityOfAllElements(bikeLaunchDates));
        return bikeLaunchDates;
    }


    public List<WebElement> getPopularBikeCards() {
        wait.until(ExpectedConditions.visibilityOfAllElements(popularBikeCards));
        return popularBikeCards;
    }


    public void clickScootersOnly() {
        wait.until(ExpectedConditions.visibilityOf(scootersOnlyFilter));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", scootersOnlyFilter);
        wait.until(ExpectedConditions.elementToBeClickable(scootersOnlyFilter));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", scootersOnlyFilter);
    }

    public List<WebElement> getScooterCards() {
        return scooterCards;
    }

    public void clickFirstAlertMeButton() {
        wait.until(ExpectedConditions.visibilityOf(firstAlertMeButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", firstAlertMeButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstAlertMeButton);
    }

    public void enterPincode(String pincode) {
        wait.until(ExpectedConditions.visibilityOf(pincodeTextBox));
        pincodeTextBox.clear();
        pincodeTextBox.sendKeys(pincode);
    }

    public void selectFirstPincodeSuggestion() {
        wait.until(ExpectedConditions.elementToBeClickable(firstPincodeSuggestion));
        firstPincodeSuggestion.click();
    }

    public void enterFullName(String fullName) {
        wait.until(ExpectedConditions.visibilityOf(fullNameTextBox));
        fullNameTextBox.clear();
        fullNameTextBox.sendKeys(fullName);
    }

    public void enterMobileNumber(String mobileNumber) {
        wait.until(ExpectedConditions.visibilityOf(mobileNumberTextBox));
        mobileNumberTextBox.clear();
        mobileNumberTextBox.sendKeys(mobileNumber);
    }


    public boolean isOtpFieldDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(otpSection));
        return otpSection.isDisplayed();
    }

    public void clickClosePopupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closePopupButton));
        closePopupButton.click();
    }

    public void scrollToUpcomingBikesByBodyType() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", upcomingBikesByBodyTypeSection);
        wait.until(ExpectedConditions.visibilityOf(upcomingBikesByBodyTypeSection));
    }

    public List<WebElement> getBikeBodyTypes() {
        return bikeBodyTypes;
    }

    public void scrollToUpcomingHondaBikesFAQs() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", upcomingHondaBikesFaqSection);
        wait.until(ExpectedConditions.visibilityOf(upcomingHondaBikesFaqSection));
    }

    public List<WebElement> getFaqQuestions() {
        return faqQuestions;
    }

    public void clickZigWheelsLogo() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
        wait.until(ExpectedConditions.visibilityOf(zigWheelsLogo));
        Actions actions = new Actions(driver);
        actions.moveToElement(zigWheelsLogo).click().perform();
    }
}