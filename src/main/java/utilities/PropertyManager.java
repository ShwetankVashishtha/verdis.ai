package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {

    public Properties getResourceBundle;

    public PropertyManager() {
        try {
            File baseSrc = new File("./src/main/resources/base.properties");
            FileInputStream baseFIS = new FileInputStream(baseSrc);
            getResourceBundle = new Properties();

            getResourceBundle.load(baseFIS);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
