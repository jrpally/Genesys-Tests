package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class FlightOption implements IFlight {
    private final IWebBrowser driver;
    private final IWebElement flightsRow;

    public FlightOption(IWebBrowser driver, IWebElement flightsRow) {
        if (driver == null) {
            throw new IllegalArgumentException("driver is null");
        }
        if (flightsRow == null) {
            throw new IllegalArgumentException("flight row is null");
        }
        this.driver = driver;
        this.flightsRow = flightsRow;
    }

    @Override
    public String getText() {
        return this.flightsRow.getText();
    }

    @Override
    public void programmaticClick() {
        this.flightsRow.programmaticClick();
    }

    @Override
    public ISelectButtonControl getSelectButton() {
        IWebElement selectButtonElement = this.flightsRow.findElement(Criteria.byXpath(".//button[contains(@class,'card-price__button')]"));
        return new SelectButtonControl(this.driver, selectButtonElement);
    }
}
