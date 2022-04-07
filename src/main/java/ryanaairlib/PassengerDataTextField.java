package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public abstract class PassengerDataTextField {
    private IWebElement passengerElement;

    public PassengerDataTextField(IWebElement passengerElement) {
        if (passengerElement == null) {
            throw new IllegalArgumentException("passengerElement is null");
        }
        this.passengerElement = passengerElement;
    }

    public void setValue(String value) {
        IWebElement element = passengerElement.findElement(getChildPath());
        element.sendKeys(value);
    }

    protected abstract Criteria getChildPath();
}
