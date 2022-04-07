package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

public class LoginLaterControl implements ILoginLater {
    private IWebBrowser driver;

    public LoginLaterControl(IWebBrowser driver) {
        this.driver = driver;
        if (driver == null) {
            throw new IllegalArgumentException("Driver is null");
        }
    }

    @Override
    public void programmaticClick() {
        IWebElement element = this.driver.findElement(Criteria.byXpath("//*/button[@class='login-touchpoint__expansion-bar']"));
        element.programmaticClick();
    }
}
