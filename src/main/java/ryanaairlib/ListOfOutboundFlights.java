package ryanaairlib;

import libraries.seleniumabstraction.Criteria;

public class ListOfOutboundFlights extends ListOfFlightsControl {
    public ListOfOutboundFlights(IWebBrowser driver) {
        super(driver);
    }

    @Override
    protected Criteria getXPathForFlightRows() {
        return Criteria.byXpath("//*[contains(name(),'flight-card') and contains(@data-e2e,'outbound')]");
    }

    @Override
    protected Criteria getXpathForParent() {
        return Criteria.byXpath("//*[contains(name(),'journey-container') and @data-ref='outbound']");
    }
}
