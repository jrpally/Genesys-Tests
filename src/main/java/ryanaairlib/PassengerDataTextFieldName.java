package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class PassengerDataTextFieldName extends PassengerDataTextField {
    public PassengerDataTextFieldName(IWebElement passengerElement) {
        super(passengerElement);
    }

    @Override
    protected Criteria getChildPath() {
        return Criteria.byXpath(".//input[contains(@id,'.name')]");
    }
}
