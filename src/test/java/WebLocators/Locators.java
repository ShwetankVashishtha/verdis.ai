package WebLocators;

public interface Locators {

    public interface SVGChartsLocators {
        String HIGH_CHART_TEXT = "//*[local-name()='svg']//*[local-name()='g']//*[name()='text']/*[name()='tspan']";
        String HIGH_CHART_GRAPH_TITLE = "//*[local-name()='svg']/*[name()='text']/*[name()='tspan']";
        String BAR_LINE_TEXT_MANUFACTURING = "//*[local-name()='svg']/*[name()='g' and contains(@class, 'highcharts-label highcharts-series-label highcharts-series-label-1')]/*[name()='text']";
        String TOOL_TIP_INSTALLATION = "//*[local-name()='svg']/*[name()='g' and contains(@class, 'highcharts-markers highcharts-series-0 highcharts-line-series highcharts-color-0 highcharts-tracker highcharts-series-hover')]";
    }
}
