package ryanaairlib;

import libraries.controls.DateControl;
import libraries.seleniumabstraction.Criteria;

public class DateControlReturn extends DateControl {
    public DateControlReturn(IWebBrowser driver) {
        super(driver);
    }

    @Override
    protected Criteria getDaysCriteria() {
        return Criteria.byXpath("//*[contains(@class,'datepicker__calendar ng-star-inserted')]");
    }

    @Override
    protected Criteria getInputCriteria() {
        return Criteria.byXpath("//*[starts-with(@uniqueid, 'dates-to')]");
    }
}
