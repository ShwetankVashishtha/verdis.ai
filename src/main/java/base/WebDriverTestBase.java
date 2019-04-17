package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WebDriverTestBase {

    protected static WebDriver driver;

    public abstract void openBrowser(String browserName, String URL);

    public abstract void openURL(String url);

    public abstract void pause(long timeout);

    public abstract void closeBrowser();

    public abstract void implicitWait(long timeout);

    public abstract void waitForElementToBeClickable(long timeout, WebElement element);

    public abstract void waitForElementPresent(long timeout, String element);

}
