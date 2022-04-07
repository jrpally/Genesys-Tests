package ryanaairlib;

import libraries.seleniumabstraction.IWebElement;

public class PassengerControl implements IPassengerControl {
    private final IWebBrowser driver;
    private final IWebElement passengerElement;

    public PassengerControl(IWebBrowser driver, IWebElement passengerElement) {
        if (driver == null) {
            throw new IllegalArgumentException("driver is not null");
        }
        if (passengerElement == null) {
            throw new IllegalArgumentException("PassengerElement is null");
        }
        this.driver = driver;
        this.passengerElement = passengerElement;
    }

    @Override
    public ITitleControl getTitle() {
        return new TitleControl(this.passengerElement);
    }

    @Override
    public void setFirstName(String name) {
        PassengerDataTextField passengerDataTextField = new PassengerDataTextFieldName(this.passengerElement);
        passengerDataTextField.setValue(name);
    }

    @Override
    public void setLastName(String lastName) {
        PassengerDataTextField passengerDataTextField = new PassengerDataTextFieldSurName(this.passengerElement);
        passengerDataTextField.setValue(lastName);
    }
}
