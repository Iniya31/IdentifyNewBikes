//final
package basetest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import utilities.DriverSetup;
import utilities.Log;

public class BaseTest {
    public static WebDriver driver;
    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(String browser) {
        Log.info("============= Test Suite Started =============");
        if (driver == null) {
            driver = DriverSetup.getDriver(browser);
            Log.info("Browser Launched Successfully");
            Log.info("Browser : " + browser);
        }
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Log.info("============= Test Suite Execution Completed =============");
        if (driver != null) {
            DriverSetup.quitDriver(driver);
            driver = null;
            Log.info("Browser Closed Successfully");
        }
    }
}