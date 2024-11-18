package country;

import java.util.ArrayList;
import java.util.Comparator;

public class Controller {
    private final ArrayList<Country> listCountry = new ArrayList<>();
    public ArrayList<Country> getListCountry(){
        return listCountry;
    }

    public boolean checkExist(String Code) {
        for (Country loop : listCountry) {
            if (loop.getCountryCode().equalsIgnoreCase(Code)) {
                return true;
            }
        }
        return false;
    }

    //function 1
    public boolean addCountryInformation(String countryCode, String countryName, double totalArea, String countryTerrain) {
        Country newCountry = new Country(countryCode, countryName, totalArea, countryTerrain);
        if (this.checkExist(countryCode)) {
            return false;
        } else {
            listCountry.add(newCountry);
            return true;
        }
    }

    //function 2
    public ArrayList<Country> searchByName(String countryName) {
        ArrayList<Country> listCountryName = new ArrayList<>();
        for (Country loop : listCountry) {
            if (loop.getCountryName().equalsIgnoreCase(countryName)) {
                listCountryName.add(loop);
            }
        }
        return listCountryName;
    }

    //function 3
    public void sortCountriesByTotalArea(ArrayList<Country> list) {
        list.sort(new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                // Compare by total area
                return Double.compare(country1.getTotalArea(), country2.getTotalArea());
            }
        });
    }





}
