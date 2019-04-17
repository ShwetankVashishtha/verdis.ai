package WebLocators;

public interface Locators {

    public interface SVGChartsLocators {
        String HIGH_CHART_TEXT = "//*[local-name()='svg']//*[local-name()='g']//*[name()='text']/*[name()='tspan']";
        String HIGH_CHART_GRAPH_TITLE = "//*[local-name()='svg']/*[name()='text']/*[name()='tspan']";
        String PIE_CHART_GRAPH_TITLE = "/*[local-name()='svg']/*[name()='g']//*[name()='text'][0]";
        String ACCEPT_COOKIE_BTN = "//a[@class='optanon-allow-all']";
    }
}
