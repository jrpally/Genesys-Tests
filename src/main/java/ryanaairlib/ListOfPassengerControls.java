package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

import java.util.ArrayList;
import java.util.List;

public class ListOfPassengerControls {
    private final IWebBrowser driver;

    public ListOfPassengerControls(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("driver is null");
        }
        this.driver = driver;
    }

    public List<IPassengerControl> getList() {
        List<IWebElement> passengerElements = this.driver.findElements(Criteria.byXpath("//*[name()='pax-passenger']"));
        List<IPassengerControl> passengerControls = new ArrayList<>();
        for (IWebElement passengerElement : passengerElements) {
            passengerControls.add(new PassengerControl(this.driver, passengerElement));
        }
        return passengerControls;
    }
}
