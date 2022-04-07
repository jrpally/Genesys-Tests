package libraries.controls;

import libraries.controls.DisplayedCountriesCitiesControl;
import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;
import ryanaairlib.EditableControl;
import ryanaairlib.IDisplayCities;
import ryanaairlib.IDisplayCountriesCitiesControl;
import ryanaairlib.IWebBrowser;

public class EditableControlFrom extends EditableControl implements IDisplayCities {
    public EditableControlFrom(IWebBrowser webBrowser) {
        super(webBrowser);
    }

    @Override
    protected IWebElement getElementLocator() {
       IWebElement webElement = webBrowser.findElement(Criteria.byId("input-button__departure"));
       return webElement;
    }

    @Override
    public IDisplayCountriesCitiesControl getDisplayedCountriesCities() {
        IWebElement webElement = webBrowser.findElement(Criteria.byXpath("//*[starts-with(name(), 'fsw-origin-container')]"));
        return new DisplayedCountriesCitiesControl(webBrowser, webElement);
    }
}
