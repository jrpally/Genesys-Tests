package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class ListOfFlightsControl {
    protected final IWebBrowser driver;

    public ListOfFlightsControl(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("driver cannot be null");
        }
        this.driver = driver;
    }

    public List<IFlight> getList() {
        IWebElement element = this.driver.findElement(getXpathForParent());
        List<IWebElement> flightsRows = element.findElements(getXPathForFlightRows());
        List<IFlight> result = new ArrayList<>();
        for (IWebElement flightsRow : flightsRows) {
            result.add(new FlightOption(this.driver, flightsRow));
        }
        return result;
    }

    protected abstract Criteria getXPathForFlightRows();


    protected abstract Criteria getXpathForParent();
}
