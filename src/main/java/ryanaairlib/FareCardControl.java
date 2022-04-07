package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

import java.util.ArrayList;
import java.util.List;

public class FareCardControl implements IFareCard {
    private IWebBrowser driver;

    public FareCardControl(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver is null");
        }
        this.driver = driver;
    }

    @Override
    public List<IFareControl> getAllFares() {
        IWebElement fareElement = this.driver.findElement(Criteria.byXpath("//*[contains(name(),'fare-table-container')]"));
        List<IWebElement> fareControls = fareElement
                .findElements(Criteria.byXpath(".//div[contains(@class,'fare-card-item')]"));
        List<IFareControl> result = new ArrayList<>();
        for (IWebElement fareControl : fareControls) {
            result.add(new FareControl(this.driver, fareControl));
        }
        return result;
    }
}
