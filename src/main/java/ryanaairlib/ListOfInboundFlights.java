package ryanaairlib;

import libraries.seleniumabstraction.Criteria;

public class ListOfInboundFlights extends ListOfFlightsControl {
    public ListOfInboundFlights(IWebBrowser driver) {
        super(driver);
    }

    @Override
    protected Criteria getXPathForFlightRows() {
        return Criteria.byXpath("//*[contains(name(),'flight-card') and contains(@data-e2e,'inbound')]");
    }

    @Override
    protected Criteria getXpathForParent() {
        return Criteria.byXpath("//*[contains(name(),'journey-container') and @data-ref='inbound']");
    }
}
