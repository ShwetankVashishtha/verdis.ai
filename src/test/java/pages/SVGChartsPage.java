package pages;

import base.PageBase;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = BAR_LINE_TEXT_MANUFACTURING)
    private WebElement barLineTextManufacturing;

    public WebElement getBarLineTextManufacturing() {
        return barLineTextManufacturing;
    }

    @FindBy(xpath = TOOL_TIP_INSTALLATION)
    private WebElement toolTipInstallation;

    public WebElement getToolTipInstallation() {
        return toolTipInstallation;
    }
}
