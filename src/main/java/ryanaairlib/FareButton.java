package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;
import org.openqa.selenium.By;

public class FareButton implements IFareButton {
    private final IWebBrowser driver;
    private final IWebElement fareControl;

    public FareButton(IWebBrowser driver, IWebElement fareControl) {
        this.driver = driver;
        this.fareControl = fareControl;
    }

    @Override
    public String getText() {
        IWebElement button = this.fareControl.findElement(Criteria.byXpath(".//button"));
        return button.getText();
    }

    @Override
    public void programaticClick() {
        IWebElement button = this.fareControl.findElement(Criteria.byXpath(".//button"));
        button.programmaticClick();
    }
}
