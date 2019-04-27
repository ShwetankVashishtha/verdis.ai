package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {

    public Properties getResourceBundle;

    public PropertyManager() {
        try {
            File pageSrc = new File("./src/main/resources/page.properties");
            FileInputStream pageFIS = new FileInputStream(pageSrc);
            getResourceBundle = new Properties();

            File baseSrc = new File("./src/main/resources/base.properties");
            FileInputStream baseFIS = new FileInputStream(baseSrc);
            getResourceBundle = new Properties();

            getResourceBundle.load(pageFIS);
            getResourceBundle.load(baseFIS);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
