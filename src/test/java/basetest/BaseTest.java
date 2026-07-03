package basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import utilities.DriverSetup;
import utilities.Log;

public class BaseTest {

    public static WebDriver driver;
    @Parameters("browser")
    @BeforeSuite(alwaysRun = true)
    public void setup(String browser) {
        Log.info("============= Test Suite Started =============");
        if (driver == null) {
            driver = DriverSetup.getDriver(browser);
            Log.info("Browser Launched Successfully");
            Log.info("Browser : " + browser);
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Log.info("============= Test Suite Execution Completed =============");
        if (driver != null) {
            DriverSetup.quitDriver(driver);
            driver = null;
            Log.info("Browser Closed Successfully");
        }
    }
}