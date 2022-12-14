package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//NOSONAR
public class PageBase {

    /**
     * The driver.
     */
    protected WebDriver driver = null;

    /**
     * Instantiates a new adds the feedback page.
     *
     * @param driver the driver
     */

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
