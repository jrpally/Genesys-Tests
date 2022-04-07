package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class ContinueButton implements IContinueButton {
    private IWebBrowser driver;

    public ContinueButton(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver is null");
        }
        this.driver = driver;
    }

    @Override
    public void programmaticClick() {
        IWebElement element = this.driver
                .findElement(
                        Criteria.byXpath("//button[contains(@class,'continue-flow__button')]"));
        element.programmaticClick();
    }
}
