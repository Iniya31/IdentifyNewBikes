package basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.DriverSetup;

public class BaseTest {
    public WebDriver driver;
    @Parameters("browser")
    @BeforeTest
    public void setup(String browser) {
        driver = DriverSetup.getDriver(browser);
        System.out.println("Browser Opened Successfully");
    }

    @AfterTest
    public void tearDown() {
        DriverSetup.quitDriver(driver);
        System.out.println("Browser Closed Successfully");
    }
}