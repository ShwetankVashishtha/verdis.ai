package tests;

import base.TestBase;
import org.testng.annotations.*;
import pages.SVGChartsPage;
import utilities.MongoDBConnection;
import utilities.PropertyManager;

public class SVGPieChartTest {

    TestBase base = new TestBase();
    PropertyManager propertyManager = new PropertyManager();
    MongoDBConnection mongoDBConnection = new MongoDBConnection();
    SVGChartsPage svgChartsPage;

    @BeforeSuite
    public void connectDatabase() {
        mongoDBConnection.connectDatabase(propertyManager.getResourceBundle.getProperty("mongodb.server.url"), 27017);
    }

    @AfterSuite
    public void closeDatabase() {
        mongoDBConnection.closeDatabase();
    }

    @BeforeClass
    public void openBrowser() {
        base.openBrowser(propertyManager.getResourceBundle.getProperty("BROWSER"), propertyManager.getResourceBundle.getProperty("PIE_CHARTS_AUT"));
        base.pause(7500);
    }

    @AfterClass
    public void closeBrowser() {
        base.closeBrowser();
    }

    @Test(description = "Verify Pie-Chart Title")
    public void verifyPieChartTitle() {
        svgChartsPage = new SVGChartsPage(base.getDriver());
        svgChartsPage.acceptCookies();
    }
}
