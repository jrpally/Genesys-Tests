package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;
import org.openqa.selenium.WebDriver;

import java.util.List;

public interface IWebBrowser {
    void goTo(String url);

    void quit();

    WebDriver getNativeDriver();

    List<IWebElement> findElements(Criteria by);

    IWebElement findElement(Criteria by);
}
