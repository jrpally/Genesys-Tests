package ryanaairlib;

import libraries.seleniumabstraction.IWebElement;

public class FareControl implements IFareControl {
    private final IWebBrowser driver;
    private final IWebElement fareControl;

    public FareControl(IWebBrowser driver, IWebElement fareControl) {
        if (driver == null) {
            throw new IllegalArgumentException("driver cannot be null");
        }
        if (fareControl == null) {
            throw new IllegalArgumentException("fareControl is null");
        }
        this.driver = driver;
        this.fareControl = fareControl;
    }

    @Override
    public String getText() {
        return this.fareControl.getText();
    }

    @Override
    public void programmaticClick() {
        this.fareControl.programmaticClick();
    }

    @Override
    public IFareButton getButton() {
        return new FareButton(this.driver, this.fareControl);
    }
}
