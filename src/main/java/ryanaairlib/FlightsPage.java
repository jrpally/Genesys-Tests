package ryanaairlib;

import libraries.controls.*;

public class FlightsPage implements IWebPage {
    private IWebBrowser driver;
    private String basePage = "https://www.ryanair.com/";

    public FlightsPage(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        this.driver = driver;
    }

    public EditableControlFrom getFrom() {
        return new EditableControlFrom(this.driver);
    }

    public EditableControlTo getTo() {
        return new EditableControlTo(this.driver);
    }

    @Override
    public void gotoPage() {
        driver.goTo(basePage);
    }

    public DateControl getDepartDate() {
        return new DateControlDeparture(this.driver);
    }

    public DateControl getReturnDate() {
        return new DateControlReturn(this.driver);
    }

    public IPassengerInput getPassengerInput() {
        return new PassengerInput(this.driver);
    }

    public ISearchButton getSearchFlight() {
        return new SearchFlightButton(this.driver);
    }

    public ICookieButton getAcceptCookies() {
        return new CookieButton(this.driver);
    }
}
