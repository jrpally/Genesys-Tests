package libraries.controls;

import libraries.seleniumabstraction.IWebElement;
import ryanaairlib.IWebBrowser;

public class CountryControl implements ICountryControl {
    private final IWebBrowser webBrowser;
    private final IWebElement iWebElement;

    public CountryControl(IWebBrowser webBrowser, IWebElement iWebElement) {
        this.webBrowser = webBrowser;
        this.iWebElement = iWebElement;
    }

    @Override
    public void click() {
        this.iWebElement.click();
    }

    @Override
    public String getText() {
        return this.iWebElement.getText();
    }

    @Override
    public void programmaticClick() {
        this.iWebElement.programmaticClick();
    }
}
