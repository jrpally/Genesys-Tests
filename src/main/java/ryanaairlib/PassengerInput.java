package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

import java.util.ArrayList;
import java.util.List;

public class PassengerInput implements IPassengerInput {
    private final IWebBrowser driver;

    public PassengerInput(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        this.driver = driver;
    }

    @Override
    public void programmaticClick() {
        IWebElement passengerInput = getPassengerInput();
        passengerInput.programmaticClick();
    }

    private IWebElement getPassengerInput() {
        IWebElement passengerInput = this.driver.findElement(Criteria.byXpath("//*[contains(@uniqueid, 'passengers')]"));
        return passengerInput;
    }

    @Override
    public List<IPassengerCategory> getPassengerCategories() {
        List<IWebElement> passengerCategories = this.driver.findElements(Criteria.byXpath("//*[contains(@data-ref, 'passengers-picker__')]"));
        List<IPassengerCategory> result = new ArrayList<>();
        for (IWebElement passengerCategory : passengerCategories) {
            result.add(new PassengerCategoryControl(this.driver, passengerCategory));
        }
        return result;
    }

    @Override
    public void click() {
        getPassengerInput().click();
    }
}
