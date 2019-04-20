package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertyManager;

import java.util.concurrent.TimeUnit;

public class TestBase extends WebDriverTestBase {

    PropertyManager propertyManager = new PropertyManager();

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void openBrowser(String browserName, String URL) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    propertyManager.getResourceBundle.getProperty("CHROME_DRIVER_PATH"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            openURL(URL);
            pause(7500);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    propertyManager.getResourceBundle.getProperty("GECKO_DRIVER_PATH"));
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            openURL(URL);
            pause(7500);
        }
    }

    @Override
    public void openURL(String url) {
        driver.get(url);
    }

    @Override
    public void pause(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeBrowser() {
        driver.quit();
    }

    @Override
    public void implicitWait(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @Override
    public void waitForElementToBeClickable(long timeout, WebElement element) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    public void waitForElementPresent(long timeout, String element) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }
}
