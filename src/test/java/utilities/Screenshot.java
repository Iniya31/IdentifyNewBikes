//changed
package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

    public static String filePath = System.getProperty("user.dir") + "\\Screenshots\\";
    public static String takeScreenShot(WebDriver driver, String fileName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destination = filePath + fileName + "_" + timeStamp + ".png";
        File destFile = new File(destination);
        FileHandler.copy(srcFile, destFile);
        return destination;
    }
}