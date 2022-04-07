package ryanaairlib;

import libraries.controls.ICityControl;
import libraries.controls.ICountryControl;

import java.util.List;

public interface IDisplayCountriesCitiesControl {
    String getText();

    List<ICountryControl> getCountryList();

    List<ICityControl> getCitiesList();
}
