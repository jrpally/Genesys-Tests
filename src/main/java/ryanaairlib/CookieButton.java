package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class CookieButton implements ICookieButton {
    private IWebBrowser driver;

    public CookieButton(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver is null");
        }
        this.driver = driver;
    }

    @Override
    public void programmaticClick() {
        IWebElement cookieElement = driver.findElement(Criteria.byXpath("//button[@data-ref='cookie.accept-all']"));
        cookieElement.programmaticClick();
    }
}
