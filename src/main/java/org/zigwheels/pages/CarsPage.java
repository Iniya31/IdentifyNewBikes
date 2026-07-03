package org.zigwheels.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public CarsPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='MORE']")
    private WebElement moreMenu;

    @FindBy(xpath = "//a[contains(@href,'/used-car')]")
    private WebElement usedCars;

    @FindBy(xpath = "//input[contains(@placeholder,'Enter Your City')]")
    private WebElement cityTextBox;

    @FindBy(xpath = "//a[text()='Chennai']")
    private WebElement chennaiSuggestion;

    @FindBy(xpath = "//div[contains(text(),'Popular Models')]")
    private WebElement popularModelsHeader;

    @FindBy(xpath = "//div[contains(@class,'usedLoader')]")
    private WebElement usedLoader;

    @FindBy(xpath = "//label[@for='price1']")
    private WebElement upto2LakhLabel;

    @FindBy(id = "thatsAllFolks")
    private WebElement thatsAllFolks;

    @FindBy(xpath = "//div[contains(@class,'pl-30')]")
    private List<WebElement> carDetails;

    @FindBy(xpath = "//div[contains(@class,'pl-30')]//a[@data-track-component='used-car-listing']")
    private List<WebElement> carNames;

    @FindBy(xpath = "//span[contains(@class,'zw-cmn-price')]")
    private List<WebElement> carPrices;

    @FindBy(id = "websortbyusedcar")
    private WebElement sortByDropdown;

    @FindBy(xpath = "//span[text()='Km Driven']")
    private WebElement kmDrivenSection;

    @FindBy(xpath = "//span[text()='Km Driven']/preceding-sibling::span")
    private WebElement kmDrivenExpandButton;

    @FindBy(xpath = "//label[@for='km1']")
    private WebElement lessThan5KLabel;

    @FindBy(xpath = "//a[contains(@class,'zw-srch-logo')]")
    private WebElement zigwheelsLogo;


    public void hoverMoreMenu() {

        wait.until(ExpectedConditions.visibilityOf(moreMenu));
        actions.moveToElement(moreMenu).perform();
    }

    public void clickUsedCars() {

        wait.until(ExpectedConditions.elementToBeClickable(usedCars));
        usedCars.click();
    }

    public void selectChennaiCity() {

        wait.until(ExpectedConditions.visibilityOf(cityTextBox));
        cityTextBox.clear();
        cityTextBox.sendKeys("Chennai");
        wait.until(ExpectedConditions.elementToBeClickable(chennaiSuggestion));
        chennaiSuggestion.click();
    }

    public void scrollToPopularModels() {

        wait.until(ExpectedConditions.visibilityOf(popularModelsHeader));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", popularModelsHeader);
    }

    public int selectAllPopularModels() {

        By checkboxLocator = By.xpath("//input[contains(@class,'carmmCheck')]");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(checkboxLocator));
        int totalModels = driver.findElements(checkboxLocator).size();
        int selectedCount = 0;
        for (int i = 0; i < totalModels; i++) {
            List<WebElement> checkboxes = driver.findElements(checkboxLocator);
            if (i >= checkboxes.size()) {
                break;
            }
            WebElement checkbox = checkboxes.get(i);
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", checkbox);
            js.executeScript("arguments[0].click();", checkbox);
            selectedCount++;
            try {
                wait.until(ExpectedConditions.invisibilityOf(usedLoader));
            } catch (Exception e) {
            }
        }
        return selectedCount;
    }

    public boolean scrollTillAllCarsLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            wait.until(ExpectedConditions.invisibilityOf(usedLoader));
            if (thatsAllFolks.isDisplayed()) {
                return true;
            }
        }
    }

    public List<WebElement> getCarDetails() {
        return carDetails;
    }

    public List<WebElement> getCarNames() {
        return carNames;
    }

    public List<WebElement> getCarPrices() {
        return carPrices;
    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0);");
    }

    public void selectPriceLowToHigh() {

        wait.until(ExpectedConditions.visibilityOf(sortByDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(sortByDropdown));
        Select select = new Select(sortByDropdown);
        select.selectByVisibleText("Price : Low to High");
        wait.until(ExpectedConditions.urlContains("fieldName=price"));
    }

    public void scrollToKmDriven() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", kmDrivenSection);
        wait.until(ExpectedConditions.visibilityOf(kmDrivenSection));
    }

    public void expandKmDrivenFilter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", kmDrivenExpandButton);
    }

    public void selectLessThan5K() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", lessThan5KLabel);
        js.executeScript("arguments[0].click();", lessThan5KLabel);
        try {
            wait.until(ExpectedConditions.invisibilityOf(usedLoader));
        } catch (Exception e) {
        }
    }

    public void clickZigWheelsLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(zigwheelsLogo));
        zigwheelsLogo.click();
    }

}