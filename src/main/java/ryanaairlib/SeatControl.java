package ryanaairlib;

import libraries.seleniumabstraction.IWebElement;

public class SeatControl implements ISeatControl {
    private final IWebBrowser driver;
    private final IWebElement seatElement;

    public SeatControl(IWebBrowser driver, IWebElement seatElement) {
        if (driver == null) {
            throw new IllegalArgumentException("driver is null");
        }
        if (seatElement == null) {
            throw new IllegalArgumentException("seatElement is null");
        }
        this.driver = driver;
        this.seatElement = seatElement;
    }

    @Override
    public SeatType getSeatType() {
        if (seatElement.getOuterHtml().contains("--extraleg")) {
            return SeatType.ExtraLeg;
        }
        if (seatElement.getOuterHtml().contains("seatmap__seat--priority")) {
            return SeatType.Priority;
        }
        if (seatElement.getOuterHtml().contains("seatmap__seat--standard")) {
            return SeatType.Standard;
        }
        if (seatElement.getOuterHtml().contains("seatmap__seat--unavailable")) {
            return SeatType.NotAvailable;
        }

        return SeatType.Undefined;
    }

    @Override
    public void click() {
        this.seatElement.click();
    }

    @Override
    public void programmaticClick() {
        this.seatElement.programmaticClick();
    }
}
