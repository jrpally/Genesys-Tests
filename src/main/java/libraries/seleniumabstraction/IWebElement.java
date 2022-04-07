package libraries.seleniumabstraction;

import java.util.List;

public interface IWebElement {
    void sendKeys(String value);

    void click();

    String getText();

    void programmaticClick();

    List<IWebElement> findElements(Criteria byXpath);

    IWebElement findElement(Criteria byXpath);

    void focus();

    String getOuterHtml();

    void waitForText(String s);
}
