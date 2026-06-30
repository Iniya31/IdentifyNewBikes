package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
    public static WebDriver getDriver(String browser) {
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else {
            throw new RuntimeException("Invalid Browser Name");
        }
        String url = ReadProperties.readProperty("baseUrl");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        System.out.println("Browser Opened Successfully");
        return driver;
    }

    public static void quitDriver(WebDriver driver) {
            driver.quit();
            System.out.println("Browser Closed Successfully");

    }
}