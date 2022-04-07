package libraries.seleniumabstraction;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumWebElement implements IWebElement {
    private final WebDriver driver;
    private final WebElement webElement;
    private Duration timeoutInSeconds = Duration.ofSeconds(30);

    public SeleniumWebElement(WebDriver driver, WebElement webElement) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        if (webElement == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        this.driver = driver;
        this.webElement = webElement;
    }

    @Override
    public void sendKeys(String value) {
        this.webElement.sendKeys(value);
    }

    @Override
    public void click() {
        WaitForReady();
        this.webElement.click();
        WaitForReady();
    }

    private void WaitForReady() {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    @Override
    public String getText() {
        WaitForReady();
        //waitForText(this.webElement);
        return this.webElement.getText();
    }

    private void waitForText(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementValue(webElement, "")));
    }

    @Override
    public void programmaticClick() {
        WaitForReady();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", this.webElement);
        WaitForReady();
    }

    @Override
    public List<IWebElement> findElements(Criteria criteria) {
        WaitForReady();
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until( driver -> {
            List<WebElement> webElement = this.driver.findElements(criteria.getBy());
            return webElement.size() > 0;
        });
        List<IWebElement> webElements = new ArrayList<>();
        List<WebElement> webElementsNative = webElement.findElements(criteria.getBy());
        for (WebElement element : webElementsNative) {
            webElements.add(new SeleniumWebElement(driver, element));
        }
        return webElements;
    }

    @Override
    public IWebElement findElement(Criteria criteria) {
        WaitForReady();
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until( driver -> {
            List<WebElement> webElement = this.driver.findElements(criteria.getBy());
            return webElement.size() > 0;
        });
        WebElement element = webElement.findElement(criteria.getBy());
        return new SeleniumWebElement(driver, element);
    }

    @Override
    public void focus() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].focus()", this.webElement);
    }

    @Override
    public String getOuterHtml() {
        return this.webElement.getAttribute("outerHTML");
    }

    @Override
    public void waitForText(String s) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.textToBePresentInElement(this.webElement, s));
    }
}
