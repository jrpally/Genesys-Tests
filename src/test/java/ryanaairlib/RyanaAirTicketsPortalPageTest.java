package ryanaairlib;

import libraries.controls.ICityControl;
import libraries.controls.ICountryControl;
import libraries.controls.IDayControl;
import libraries.seleniumabstraction.WrapperWebBrowser;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

class RyanaAirTicketsPortalPageTest {

    private EdgeOptions options = new EdgeOptions();
    private IWebBrowser webBrowser;
    private WebDriver driver;
    private FlightsPage flightsPage;
    private FlightsPageResult flightsPageResult;

    @BeforeEach
    void setUp() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        webBrowser = new WrapperWebBrowser(driver);
        flightsPage = new FlightsPage(webBrowser);
    }

    @Test
    void test_iCanBookFlight() {
        flightsPage.gotoPage();
        flightsPage.getAcceptCookies().programmaticClick();
        // Choose an origin country
        flightsPage.getFrom().clickProgrammatically();
        List<ICountryControl> countriesFrom = flightsPage.getFrom().getDisplayedCountriesCities().getCountryList();
        ICountryControl countryControl = countriesFrom
                .stream()
                .filter(country -> country.getText().contains("Greece"))
                .findFirst()
                .orElse(null);
        MatcherAssert.assertThat(countryControl.getText(), containsString("Greece"));
        countryControl.programmaticClick();

        // Choosing an origin city
        List<ICityControl> citiesFrom = flightsPage.getFrom().getDisplayedCountriesCities().getCitiesList();
        ICityControl cityControl = citiesFrom
                .stream()
                .filter(city -> city.getText().contains("Athens"))
                .findFirst()
                .orElse(null);
        MatcherAssert.assertThat(cityControl.getText(), containsString("Athens"));
        cityControl.programmaticClick();

        // Destination Country
        flightsPage.getTo().clickProgrammatically();
        List<ICountryControl> countriesTo = flightsPage.getTo().getDisplayedCountriesCities().getCountryList();
        ICountryControl countryControlTo = countriesTo
                .stream()
                .filter(country -> country.getText().contains("Ireland"))
                .findFirst()
                .orElse(null);
        MatcherAssert.assertThat(countryControlTo.getText(), containsString("Ireland"));
        countryControlTo.programmaticClick();

        // Choosing a destination city
        List<ICityControl> citiesTo = flightsPage.getTo().getDisplayedCountriesCities().getCitiesList();
        ICityControl cityControlTo = citiesTo
                .stream()
                .filter(city -> city.getText().contains("Dublin"))
                .findFirst()
                .orElse(null);
        MatcherAssert.assertThat(cityControlTo.getText(), containsString("Dublin"));
        cityControlTo.programmaticClick();

        // Choose the first valid departure date
        flightsPage.getDepartDate().programmaticClick();
        List<IDayControl> dayControls = flightsPage.getDepartDate().getDays();
        IDayControl dayControl = dayControls.stream().findFirst().orElse(null);
        dayControl.programmaticClick();

        // Choose the valid return date
        flightsPage.getReturnDate().programmaticClick();
        List<IDayControl> returnDays = flightsPage.getReturnDate().getDays();
        IDayControl returnDayControl = returnDays.get(returnDays.size() - 1);
        returnDayControl.programmaticClick();

        // Choose two Adults passenger
        flightsPage.getPassengerInput().programmaticClick();
        List<IPassengerCategory> passengerCategories = flightsPage.getPassengerInput().getPassengerCategories();
        IPassengerCategory passengerCategory = passengerCategories
                .stream()
                .filter(passengerCategory1 -> passengerCategory1.getText().contains("Adults"))
                .findFirst()
                .orElse(null);
        passengerCategory.addPassenger();
        int numberOfPassengers = passengerCategory.getNumberOfPassengers();
        Assert.assertEquals("Number of Passengers", 2, numberOfPassengers);

        // Search Button
        flightsPage.getSearchFlight().programmaticClick();

        // Flight Result:
        flightsPageResult = new FlightsPageResult(webBrowser);
        List<IFlight> outboundFlights = flightsPageResult.getOutboundFlights();
        Assert.assertEquals("Number of entries", 1, outboundFlights.size());
        //Choose first outbound and first inbound
        ISelectButtonControl buttonControl = outboundFlights
                .stream()
                .findFirst()
                .orElse(null).getSelectButton();
        Assert.assertEquals("Button Text should be Select", buttonControl.getText(), "Select");
        buttonControl.programmaticClick();

        List<IFlight> inBoundFlights = flightsPageResult.getInboundFlights();
        ISelectButtonControl buttonControlInbound = inBoundFlights
                .stream()
                .findFirst()
                .orElse(null).getSelectButton();
        Assert.assertEquals("Button Text should be Select", buttonControlInbound.getText(), "Select");
        Assert.assertEquals("Number of entries", 1, inBoundFlights.size());
        buttonControlInbound.programmaticClick();
        
        IFareCard fareCard = flightsPageResult.getFareCard();
        List<IFareControl> fareControls = fareCard.getAllFares();
        Assert.assertEquals("Number of fares", 4, fareControls.size());
        IFareControl fareControl = fareControls.stream()
                .filter(fare -> fare.getText().contains("Regular"))
                .findFirst()
                .orElse(null);

        IFareButton fareButton = fareControl.getButton();
        MatcherAssert.assertThat(fareButton.getText(), containsString("per person on each flight"));
        fareButton.programaticClick();

        ILoginLater loginLater = flightsPageResult.getLoginInLater();
        loginLater.programmaticClick();

        // Fill Passenger Data
        List<IPassengerControl> passengerControls = flightsPageResult.getPassengers();
        Assert.assertEquals("Passengers expected", 2, passengerControls.size());
        IPassengerControl passenger1 =  passengerControls
                .stream()
                .findFirst()
                .orElse(null);
        ITitleControl control = passenger1.getTitle();
        control.programmaticClick();
        List<String> title = control.getTitlesText();
        control.setTitle(title.stream().findFirst().orElse(null));
        passenger1.setFirstName("Rene");
        passenger1.setLastName("Pally");

        // Second Passenger
        IPassengerControl passenger2 =  passengerControls
                .get(passengerControls.size() - 1);
        ITitleControl control1 = passenger2.getTitle();
        control1.programmaticClick();
        List<String> title1 = control1.getTitlesText();
        control1.setTitle(title1.stream().findFirst().orElse(null));
        passenger2.setFirstName("Luis");
        passenger2.setLastName("Perez");

        flightsPageResult.getContinueButton().programmaticClick();

        ChooseSeatPage chooseSeatPage = new ChooseSeatPage(webBrowser);
        List<ISeatControl> listOfSeats = chooseSeatPage.getSeats();
        // Choose First Seat
        ISeatControl freeSeat = listOfSeats.stream()
                .filter(seat -> seat.getSeatType() == SeatType.Standard)
                .findFirst()
                .orElse(null);
        freeSeat.programmaticClick();
        // Choose Second Standard Seat
        freeSeat = listOfSeats.stream()
                .filter(seat -> seat.getSeatType() == SeatType.Standard)
                .findFirst()
                .orElse(null);
        freeSeat.programmaticClick();

        chooseSeatPage.getNextButton().programmaticClick();

        // Wait to show element Continue
        chooseSeatPage.getContinueButton().waitForText("Continue");
        listOfSeats = chooseSeatPage.getSeats();

        // Choose First Seat
        freeSeat = listOfSeats.stream()
                .filter(seat -> seat.getSeatType() == SeatType.Standard)
                .findFirst()
                .orElse(null);
        freeSeat.programmaticClick();
        // Choose Second Standard Seat
        freeSeat = listOfSeats.stream()
                .filter(seat -> seat.getSeatType() == SeatType.Standard)
                .findFirst()
                .orElse(null);
        freeSeat.programmaticClick();

        //Continue flow
        chooseSeatPage.getContinueButton().programmaticClick();
        //chooseSeatPage.getNoFastTrackButton().waitForText("No, thanks");
        chooseSeatPage.getNoFastTrackButton().programmaticClick();
    }

    @AfterEach
    void tearDown() {
        webBrowser.quit();
    }
}