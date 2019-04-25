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
        mongoDBConnection.openConnection(propertyManager.getResourceBundle.getProperty("mongodb.server.url"));
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

    @Test(description = "Verify High-Chart X-Axis Text")
    public void verifyHighChartText() {
        svgChartsPage = new SVGChartsPage(base.getDriver());

        Object object = mongoDBConnection.showContentInCollection().get("item");
        Assert.assertTrue(!svgChartsPage.getHighChartText().getText().equals(object));
    }

    @Test(description = "Verify High-Chart Graph Title")
    public void verifyHighChartGraphTitle() {
        svgChartsPage = new SVGChartsPage(base.getDriver());
        Assert.assertEquals(svgChartsPage.getHighChartGraphTitle().getText(), "SOLAR EMPLOYMENT GROWTH BY SECTOR, 2010-2016");
    }

    @Test(description = "Read attributes from High-Chart")
    public void readAttributeFromHighChart() {
        JavascriptExecutor jse = (JavascriptExecutor) base.getDriver();
        Object object = jse.executeScript("return document.getElementsByTagName('svg')[0].getAttribute('class')");
        Assert.assertEquals((String) object, "highcharts-root");
    }

    @Test(description = "Read data from High-Chart")
    public void readDataFromHighChart() {
        JavascriptExecutor jse = (JavascriptExecutor) base.getDriver();
        Object object = jse.executeScript("return document.getElementsByTagName('path')[0].getAttribute('d')");
        Assert.assertEquals((String) object, "M 77.5 62 L 77.5 364");
    }
}
