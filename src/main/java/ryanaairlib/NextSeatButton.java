package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class NextSeatButton implements INextSeatButton {
    private final IWebBrowser driver;

    public NextSeatButton(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("driver is null");
        }
        this.driver = driver;
    }

    @Override
    public void programmaticClick() {
        IWebElement buttonElement = this.driver
                .findElement(
                        Criteria.byXpath("//button[@data-ref='seats-action__button-next']"));
        buttonElement.programmaticClick();
    }
}
