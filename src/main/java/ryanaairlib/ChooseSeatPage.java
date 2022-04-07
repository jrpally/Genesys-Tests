package ryanaairlib;

import libraries.seleniumabstraction.Criteria;
import libraries.seleniumabstraction.IWebElement;

import java.util.ArrayList;
import java.util.List;

public class ChooseSeatPage {
    private final IWebBrowser driver;
    public ChooseSeatPage(IWebBrowser driver) {
        if (driver == null) {
            throw new IllegalArgumentException("driver is null");
        }
        this.driver = driver;
    }


    public List<ISeatControl> getSeats() {
        List<IWebElement> seatElements = this.driver
                .findElements(Criteria.byXpath("//*[contains(@id,'seat-') and contains(@class,'seatmap__seat')]"));
        List<ISeatControl> seatControls = new ArrayList<>();
        for (IWebElement seatElement : seatElements) {
            seatControls.add(new SeatControl(this.driver, seatElement));
        }
        return seatControls;
    }

    public INextSeatButton getNextButton() {
        return new NextSeatButton(this.driver);
    }

    public ILabel getReserveSeatLabel() {
        return new LabelControl(this.driver);
    }

    public IContinueSeatsButton getContinueButton() {
        return new ContinueSeatsButton(this.driver);
    }

    public INoFastTrackButton getNoFastTrackButton() {
        return new NoFastTrackButton(this.driver);
    }
}
