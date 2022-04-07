package ryanaairlib;

import libraries.controls.DisplayedCountriesCitiesControl;
import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class EditableControlTo extends EditableControl implements IDisplayCities {

    public EditableControlTo(IWebBrowser webBrowser) {
        super(webBrowser);
    }

    @Override
    protected IWebElement getElementLocator() {
        IWebElement webElement = webBrowser.findElement(Criteria.byId("input-button__destination"));
        return webElement;
    }

    @Override
    public IDisplayCountriesCitiesControl getDisplayedCountriesCities() {
        IWebElement webElement = webBrowser.findElement(Criteria.byXpath("//*[starts-with(name(), 'fsw-destination-container')]"));
        return new DisplayedCountriesCitiesControl(webBrowser, webElement);
    }
}
