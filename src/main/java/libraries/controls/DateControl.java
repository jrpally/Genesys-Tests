package libraries.controls;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;
import ryanaairlib.IWebBrowser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class DateControl {
    private IWebBrowser webBrowser;

    public DateControl(IWebBrowser webBrowser) {
        if (webBrowser == null) {
            throw new IllegalArgumentException("webBrowser cannot be null");
        }
        this.webBrowser = webBrowser;
    }

    public void setValue(Date of) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public List<IDayControl> getDays() {
        IWebElement parentDayControl = this.webBrowser.findElement(getDaysCriteria());
        List<IWebElement> validDays = parentDayControl.findElements(Criteria.byXpath(".//*[starts-with(@class,'calendar-body__cell-wrap')]/div[not(contains(@class,'disabled'))]"));
        List<IDayControl> result = new ArrayList<>();
        for (IWebElement validDay : validDays) {
            result.add(new DayControl(this.webBrowser, validDay));
        }
        return result;
    }

    protected abstract Criteria getDaysCriteria();

    public void programmaticClick() {
        IWebElement element = this.webBrowser.findElement(getInputCriteria());
        element.programmaticClick();
    }

    protected abstract Criteria getInputCriteria();
}
