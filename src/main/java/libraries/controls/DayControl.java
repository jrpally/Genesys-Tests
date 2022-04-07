package libraries.controls;

import libraries.seleniumabstraction.IWebElement;
import ryanaairlib.IWebBrowser;

public class DayControl implements IDayControl {
    private final IWebBrowser webBrowser;
    private final IWebElement validDay;

    public DayControl(IWebBrowser webBrowser, IWebElement validDay) {
        this.webBrowser = webBrowser;
        this.validDay = validDay;
    }

    @Override
    public String getText() {
        return validDay.getText();
    }

    @Override
    public void programmaticClick() {
        this.validDay.programmaticClick();
    }
}
