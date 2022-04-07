package libraries.controls;

import libraries.seleniumabstraction.IWebElement;
import ryanaairlib.IWebBrowser;

public class CityControl implements ICityControl {
    private final IWebBrowser webBrowser;
    private final IWebElement iWebElement;

    public CityControl(IWebBrowser webBrowser, IWebElement iWebElement) {
        if (webBrowser == null) {
            throw new IllegalArgumentException("webBrowser cannot be null");
        }
        if (webBrowser == null) {
            throw new IllegalArgumentException("Web Element cannot be null");
        }
        this.webBrowser = webBrowser;
        this.iWebElement = iWebElement;
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
