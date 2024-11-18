package country;


public class Country extends EastAsiaCountries {
    private String countryTerrain;

    public Country() {
    }

    public Country(String countryCode, String countryName, double totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        String formattedArea = String.format("%.2f", totalArea);
        System.out.printf("%-10s %-10s %-15s %-10s\n", countryCode, countryName, formattedArea, countryTerrain);
    }


}