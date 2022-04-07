package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TitleControl implements ITitleControl {
    private IWebElement passengerElement;

    public TitleControl(IWebElement passengerElement) {
        if (passengerElement == null) {
            throw new IllegalArgumentException("PassengerElement is null");
        }
        this.passengerElement = passengerElement;
    }

    @Override
    public List<String> getTitlesText() {
        IWebElement titleControl = getTitleControl();
        List<IWebElement> titleElements = titleControl
                .findElements(Criteria.byXpath(".//*[contains(@data-ref,'title-item')]"));
        List<String> titleTexts = new ArrayList<>();
        for (IWebElement titleElement : titleElements) {
            titleTexts.add(titleElement.getText());
        }
        return titleTexts;
    }

    private IWebElement getTitleControl() {
        return passengerElement.findElement(Criteria.byXpath(".//*[@data-ref='pax-details__title']"));
    }

    @Override
    public void setTitle(String title) {
        IWebElement titleControl = getTitleControl();
        List<IWebElement> titleElements = titleControl
                .findElements(Criteria.byXpath(".//*[contains(@data-ref,'title-item')]"));
        for (IWebElement titleElement : titleElements) {
            if (title.equals(titleElement.getText())) {
                titleElement.click();
                return;
            }
        }
    }

    @Override
    public void programmaticClick() {
        IWebElement webElement = getButtonControl();
        webElement.focus();
        webElement.programmaticClick();
    }

    private IWebElement getButtonControl() {
        return passengerElement.findElement(Criteria.byXpath(".//button"));
    }
}
