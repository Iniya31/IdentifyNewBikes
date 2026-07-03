package utilities;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverSetup {

    public static WebDriver getDriver(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-blink-features=AutomationControlled");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                edgeOptions.setExperimentalOption("useAutomationExtension", false);
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new RuntimeException("Invalid Browser Name : " + browser);
        }
        String url = ReadProperties.readProperty("baseUrl");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        return driver;
    }

    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}