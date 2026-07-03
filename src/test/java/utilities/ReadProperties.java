package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    static Properties prop = new Properties();
    public static String readProperty(String key) {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}