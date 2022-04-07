package libraries.controls;

import libraries.seleniumabstraction.Criteria;
import ryanaairlib.IWebBrowser;

public class DateControlDeparture extends DateControl {
    public DateControlDeparture(IWebBrowser driver) {
        super(driver);
    }

    @Override
    protected Criteria getDaysCriteria() {
        return Criteria.byXpath("//*[contains(@class,'datepicker__calendar--left')]");
    }

    @Override
    protected Criteria getInputCriteria() {
        return Criteria.byXpath("//*[starts-with(@uniqueid, 'dates-from')]");
    }
}
