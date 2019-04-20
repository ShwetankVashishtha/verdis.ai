package pages;

import base.PageBase;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import WebLocators.Locators.SVGChartsLocators;

public class SVGChartsPage extends PageBase implements SVGChartsLocators {

    public SVGChartsPage(WebDriver driver) {
        super(driver);
    }

    TestBase base = new TestBase();

    @FindBy(xpath = HIGH_CHART_TEXT)
    private WebElement highChartText;

    public WebElement getHighChartText() {
        return highChartText;
    }

    @FindBy(xpath = HIGH_CHART_GRAPH_TITLE)
    private WebElement highChartGraphTitle;

    public WebElement getHighChartGraphTitle() {
        return highChartGraphTitle;
    }
}
