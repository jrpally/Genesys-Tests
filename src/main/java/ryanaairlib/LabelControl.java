package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class LabelControl implements ILabel {
    private final IWebBrowser driver;

    public LabelControl(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("driver is null");
        }
        this.driver = driver;
    }

    @Override
    public String getText() {
        IWebElement control = this.driver.findElement(Criteria.byXpath("//p[@class='seats-prompt__title']"));
        return control.getText();
    }

    @Override
    public void waitForText(String s) {
        IWebElement control = this.driver.findElement(Criteria.byXpath("//p[@class='seats-prompt__title']"));
        control.waitForText(s);
    }
}
