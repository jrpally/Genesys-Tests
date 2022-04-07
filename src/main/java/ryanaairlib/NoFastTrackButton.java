package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class NoFastTrackButton implements INoFastTrackButton {
    private IWebBrowser driver;

    public NoFastTrackButton(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("driver is null");
        }
        this.driver = driver;
    }

    @Override
    public void waitForText(String text) {
        IWebElement button = getButtonElement();
        button.waitForText(text);
    }

    @Override
    public void programmaticClick() {
        IWebElement button = getButtonElement();
        button.programmaticClick();
    }

    private IWebElement getButtonElement() {
        return driver.findElement(Criteria.byXpath("//*[contains(@class,'enhanced-takeover-beta__product-dismiss-cta')]"));
    }
}
