package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class PassengerCategoryControl implements IPassengerCategory {
    private final IWebBrowser driver;
    private final IWebElement passengerCategory;

    public PassengerCategoryControl(IWebBrowser driver, IWebElement passengerCategory) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver is null");
        }
        if (passengerCategory == null) {
            throw new IllegalArgumentException("Passenger Category element is null");
        }
        this.driver = driver;
        this.passengerCategory = passengerCategory;
    }

    @Override
    public String getText() {
        return this.passengerCategory.getText();
    }

    @Override
    public void addPassenger() {
        IWebElement incrementElement = this
                .passengerCategory
                .findElement(Criteria.byXpath("//*[contains(@data-ref, 'counter.counter__increment')]"));
        incrementElement.programmaticClick();

    }

    @Override
    public int getNumberOfPassengers() {
        IWebElement passengerCounter = this
                .passengerCategory
                .findElement(Criteria.byXpath("//*[contains(@data-ref, 'counter.counter__value')]"));
        int i = Integer.parseInt(passengerCounter.getText());
        return i;
    }
}
