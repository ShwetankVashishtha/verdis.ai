package tests;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
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
}
