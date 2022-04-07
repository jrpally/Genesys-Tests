package libraries.controls;

import libraries.controls.CountryControl;
import libraries.controls.ICountryControl;
import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;
import ryanaairlib.IDisplayCountriesCitiesControl;
import ryanaairlib.IWebBrowser;

import java.util.ArrayList;
import java.util.List;

public class DisplayedCountriesCitiesControl implements IDisplayCountriesCitiesControl {
    private final IWebBrowser webBrowser;
    private final IWebElement webElement;

    public DisplayedCountriesCitiesControl(IWebBrowser webBrowser, IWebElement webElement) {
        if (webBrowser == null) {
            throw new IllegalArgumentException("webBrowser cannot be null");
        }
        if (webElement == null) {
            throw new IllegalArgumentException("webElement cannot be null");
        }
        this.webBrowser = webBrowser;
        this.webElement = webElement;
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<ICountryControl> getCountryList() {
        List<IWebElement> webElementList = webElement.findElements(Criteria.byXpath("//*[starts-with(@class, 'countries__country-inner')]"));
        List<ICountryControl> result = new ArrayList<>();
        for (IWebElement iWebElement : webElementList) {
            result.add(new CountryControl(webBrowser, iWebElement));
        }
        return result;
    }

    @Override
    public List<ICityControl> getCitiesList() {
        List<IWebElement> webElementList = webElement.findElements(Criteria.byXpath("//*[contains(name(), 'airport-item')]"));
        List<ICityControl> result = new ArrayList<>();
        for (IWebElement iWebElement : webElementList) {
            result.add(new CityControl(webBrowser, iWebElement));
        }
        return result;
    }
}
