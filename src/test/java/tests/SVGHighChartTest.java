package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SVGChartsPage;
import utilities.MongoDBConnection;
import utilities.PropertyManager;

public class SVGHighChartTest {

    TestBase base = new TestBase();
    PropertyManager propertyManager = new PropertyManager();
    MongoDBConnection mongoDBConnection = new MongoDBConnection();
    SVGChartsPage svgChartsPage;

    @BeforeSuite
    public void connectDatabase() {
        mongoDBConnection.openConnection(propertyManager.getResourceBundle.getProperty("MONGO.SERVER.URL"));
    }

    @AfterSuite
    public void closeDatabase() {
        mongoDBConnection.closeConnection();
    }

    @BeforeClass
    public void openBrowser() {
        base.openBrowser(propertyManager.getResourceBundle.getProperty("BROWSER"), propertyManager.getResourceBundle.getProperty("HIGH_CHARTS_AUT"));
    }

    @AfterClass
    public void closeBrowser() {
        base.closeBrowser();
    }

    @Test(description = "Capture bar line values: Manufacturing Employees Growth")
    public void readDataFromBarLineManufacturingEmployeesGrowth() {
        svgChartsPage = new SVGChartsPage(base.getDriver());
        Assert.assertTrue(svgChartsPage.getBarLineTextManufacturing().getText().contains(propertyManager.getResourceBundle.getProperty("BAR_LINE_TEXT_MANUFACTURING")));
    }

    @Test(description = "Verify High-Chart X-Axis Text")
    public void verifyHighChartText() {
        svgChartsPage = new SVGChartsPage(base.getDriver());

        Object object = mongoDBConnection.showContentInCollection().get(propertyManager.getResourceBundle.getProperty("KEY_ITEMS"));
        Assert.assertTrue(!svgChartsPage.getHighChartText().getText().equals(object));
    }

    @Test(description = "Verify High-Chart Graph Title")
    public void verifyHighChartGraphTitle() {
        svgChartsPage = new SVGChartsPage(base.getDriver());
        Assert.assertEquals(svgChartsPage.getHighChartGraphTitle().getText(), propertyManager.getResourceBundle.getProperty("HIGH_CHART_GRAPH_TITLE"));
    }

    @Test(description = "Read attributes from High-Chart")
    public void readAttributeFromHighChart() {
        JavascriptExecutor jse = (JavascriptExecutor) base.getDriver();
        Object object = jse.executeScript("return document.getElementsByTagName('svg')[0].getAttribute('class')");
        Assert.assertEquals((String) object, propertyManager.getResourceBundle.getProperty("DOM_ATTRIBUTE_CLASS"));
    }

    @Test(description = "Read data from High-Chart")
    public void readDataFromHighChart() {
        JavascriptExecutor jse = (JavascriptExecutor) base.getDriver();
        Object object = jse.executeScript("return document.getElementsByTagName('path')[0].getAttribute('d')");
        Assert.assertEquals((String) object, propertyManager.getResourceBundle.getProperty("DOM_ATTRIBUTE_COORDINATES"));
    }

    @Test(description = "Get tool tip data")
    public void getToolTipText() {
//        JavascriptExecutor jse = (JavascriptExecutor) base.getDriver();
//        base.implicitWait(10);
//        base.pause(3000);
//        String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false);"
//                + " arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
//        ((JavascriptExecutor) base.getDriver()).executeScript(mouseOverScript,
//                base.getDriver().findElement(By.xpath("//*[local-name()='svg']/*[name()='g' and contains(@class, 'highcharts-markers highcharts-series-0 highcharts-line-series highcharts-color-0 highcharts-tracker')]")));
//        base.pause(3000);
//        Object object = jse.executeScript("return document.getElementsByClassName('highcharts-point highcharts-color-0 highcharts-point-hover')[1]");
//        System.out.println((String) object);
//
//
//        svgChartsPage = new SVGChartsPage(base.getDriver());
////        System.out.println(svgChartsPage.getToolTipInstallation().getText());
//
//        JavascriptExecutor jse1 = (JavascriptExecutor) base.getDriver();
//        jse.executeScript("arguments[0].click();", base.getDriver().findElement(By.xpath("//*[local-name()='svg']/*[name()='g' and contains(@class, 'highcharts-markers highcharts-series-0 highcharts-line-series highcharts-color-0 highcharts-tracker')]")));
//        Object object1 = jse.executeScript("return document.getElementsByClassName('highcharts-label highcharts-tooltip                                                                                                                                                                                                                                                                                               highcharts-color-0')[0].getAttribute('class');");
//        System.out.println(object);
//        System.out.println((String) object);
base.pause(2000);
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false);"
                    + " arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            ((JavascriptExecutor) base.getDriver()).executeScript(mouseOverScript,
                    base.getDriver().findElement(By.cssSelector("g.highcharts-label highcharts-tooltip                                    highcharts-color-0 text tspan")));

        String tooltipText = base.getDriver().findElement(By.cssSelector("g.highcharts-label highcharts-tooltip                                    highcharts-color-0 text tspan")).getAttribute("textContent");
        System.out.println(tooltipText);
    }
}
