package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class SearchFlightButton implements ISearchButton {
    private IWebBrowser driver;

    public SearchFlightButton(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        this.driver = driver;
    }

    @Override
    public void click() {
        IWebElement searchButton = getSearchButton();
        searchButton.click();
    }

    private IWebElement getSearchButton() {
        IWebElement searchButton = this.driver.findElement(Criteria.byXpath("//*/button[contains(@data-ref,'flight-search')]"));
        return searchButton;
    }

    @Override
    public void programmaticClick() {
        IWebElement searchButton = getSearchButton();
        searchButton.programmaticClick();
    }
}
