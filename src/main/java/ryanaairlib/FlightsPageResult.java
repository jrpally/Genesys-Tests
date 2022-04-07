package ryanaairlib;

import java.util.List;

public class FlightsPageResult {
    private IWebBrowser driver;

    public FlightsPageResult(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("driver is null");
        }
        this.driver = driver;
    }

    public List<IFlight> getOutboundFlights() {
        ListOfFlightsControl listOfFlights = new ListOfOutboundFlights(this.driver);
        return listOfFlights.getList();
    }

    public List<IFlight> getInboundFlights() {
        ListOfFlightsControl listOfFlights = new ListOfInboundFlights(this.driver);
        return listOfFlights.getList();
    }

    public IFareCard getFareCard() {
        return new FareCardControl(this.driver);
    }

    public ILoginLater getLoginInLater() {
        return new LoginLaterControl(this.driver);
    }

    public List<IPassengerControl> getPassengers() {
        ListOfPassengerControls listOfPassengerControls = new ListOfPassengerControls(this.driver);
        return listOfPassengerControls.getList();
    }

    public IContinueButton getContinueButton() {
        return new ContinueButton(this.driver);
    }
}
