package libraries.seleniumabstraction;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ryanaairlib.IWebBrowser;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WrapperWebBrowser implements IWebBrowser {
    private static Logger LOGGER = LoggerFactory.getLogger(WrapperWebBrowser.class);
    private WebDriver driver;
    private Duration timeoutInSeconds = Duration.ofSeconds(60);

    public WrapperWebBrowser(WebDriver remoteWebDriver) {
        if (remoteWebDriver == null) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        this.driver = remoteWebDriver;
    }

    @Override
    public void goTo(String url) {
        LOGGER.info("Navigate to url " + url);
        driver.navigate().to(url);
    }

    @Override
    public void quit() {
        LOGGER.info("quitting wrapped browser");
        driver.close();
        driver.quit();
        driver = null;
    }

    @Override
    public WebDriver getNativeDriver() {
        return driver;
    }

    @Override
    public List<IWebElement> findElements(Criteria by) {
        LOGGER.info("findElements with parameter " + by.toString());
        WaitPageLad();
        WaitForElements(by);
        List<WebElement> webElement = this.driver.findElements(by.getBy());
        List<IWebElement> result = new ArrayList<>();
        for (WebElement element : webElement) {
            result.add(new SeleniumWebElement(this.driver, element));
        }

        return result;
    }

    private void WaitForElements(Criteria by) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until( driver -> {
            List<WebElement> webElement = this.driver.findElements(by.getBy());
            return webElement.size() > 0;
        });
    }

    @Override
    public IWebElement findElement(Criteria by) {
        WaitPageLad();
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(by.getBy()));
        WebElement webElement = this.driver.findElement(by.getBy());
        return new SeleniumWebElement(this.driver, webElement);
    }

    private void WaitPageLad() {
        LOGGER.debug("WaitPageLoad");
        new WebDriverWait(driver, Duration.ofSeconds(30)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
