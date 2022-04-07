package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class ContinueSeatsButton implements IContinueSeatsButton {
    private final IWebBrowser driver;

    public ContinueSeatsButton(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        this.driver = driver;
    }

    @Override
    public void waitForText(String text) {
        IWebElement webElement = getButtonElement();
        webElement.waitForText(text);
    }

    private IWebElement getButtonElement() {
        IWebElement webElement = driver
                .findElement(Criteria
                        .byXpath("//button[@data-ref='seats-action__button-continue']"));
        return webElement;
    }

    @Override
    public void programmaticClick() {
        IWebElement buttonElement = getButtonElement();
        buttonElement.programmaticClick();
    }
}
