package basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.DriverSetup;

public class BaseTest {
    public WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        driver = DriverSetup.getDriver(browser);
        System.out.println("Browser Opened Successfully");
    }

    @AfterClass
    public void tearDown() {
        DriverSetup.quitDriver(driver);
        System.out.println("Browser Closed Successfully");
    }
}