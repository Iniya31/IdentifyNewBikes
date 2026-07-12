package basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import utilities.DriverSetup;
import utilities.Log;

public class BaseTest {

    protected WebDriver driver;
    protected String browserName;
    public WebDriver getDriver() {
        return driver;
    }

    public String getBrowserName() {
        return browserName;
    }

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(String browser) {
        browserName = browser;
        driver = DriverSetup.getDriver(browser);
        Log.info("Browser : " + browser);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            DriverSetup.quitDriver(driver);
        }
    }
}