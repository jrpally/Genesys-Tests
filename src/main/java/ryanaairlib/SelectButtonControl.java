package ryanaairlib;

import libraries.seleniumabstraction.IWebElement;

public class SelectButtonControl implements ISelectButtonControl {
    private final IWebBrowser driver;
    private final IWebElement flightsRow;

    public SelectButtonControl(IWebBrowser driver, IWebElement flightsRow) {
        if (driver == null) {
            throw new IllegalArgumentException("driver cannot be null");
        }
        if (flightsRow == null) {
            throw new IllegalArgumentException("FLightRow cannot be null");
        }
        this.driver = driver;
        this.flightsRow = flightsRow;
    }

    @Override
    public void programmaticClick() {
        this.flightsRow.programmaticClick();
    }

    @Override
    public String getText() {
        return this.flightsRow.getText();
    }
}
