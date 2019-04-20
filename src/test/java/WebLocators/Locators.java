package WebLocators;

public interface Locators {

    public interface SVGChartsLocators {
        String HIGH_CHART_TEXT = "//*[local-name()='svg']//*[local-name()='g']//*[name()='text']/*[name()='tspan']";
        String HIGH_CHART_GRAPH_TITLE = "//*[local-name()='svg']/*[name()='text']/*[name()='tspan']";
    }
}
