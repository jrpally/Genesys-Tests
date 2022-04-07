package ryanaairlib;

import libraries.seleniumabstraction.WrapperWebBrowser;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;

class RemoteDriverTest {

    private IWebBrowser webBrowser;
    private RemoteWebDriver remoteWebDriver;
    private Capabilities session;

    @BeforeEach
    void setUp() throws MalformedURLException {
        session = new EdgeOptions();
        remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), session);
        webBrowser = new WrapperWebBrowser(remoteWebDriver);
    }

    @AfterEach
    void tearDown() {
        webBrowser.quit();
    }

    @Test
    void goTo() {
        webBrowser.goTo("https://www.google.com");
        WebDriver wd = webBrowser.getNativeDriver();
        String pageSource = wd.getPageSource();
        MatcherAssert.assertThat(pageSource, containsString("google"));
    }
}