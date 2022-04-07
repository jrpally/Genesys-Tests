package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class PassengerDataTextFieldSurName extends PassengerDataTextField {
    public PassengerDataTextFieldSurName(IWebElement passengerElement) {
        super(passengerElement);
    }

    @Override
    protected Criteria getChildPath() {
        return Criteria.byXpath(".//input[contains(@id,'.surname')]");
    }
}
