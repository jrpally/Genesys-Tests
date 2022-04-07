package ryanaairlib;

import libraries.seleniumabstraction.IWebElement;

public abstract class EditableControl implements IWebEditableControl {
    protected IWebBrowser webBrowser;

    public EditableControl(IWebBrowser webBrowser) {
        if (webBrowser == null) {
            throw new IllegalArgumentException("webBrowser should not be null");
        }
        this.webBrowser = webBrowser;
    }

    @Override
    public void setValue(String value) {
        IWebElement webElement = getElementLocator();
        webElement.sendKeys(value);
    }

    protected abstract IWebElement getElementLocator();

    @Override
    public void click() {
        IWebElement webElement = getElementLocator();
        webElement.click();
    }

    @Override
    public void clickProgrammatically() {
        IWebElement webElement = getElementLocator();
        webElement.programmaticClick();
    }
}
