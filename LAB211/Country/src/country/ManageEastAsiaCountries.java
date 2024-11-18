package country;

import java.util.ArrayList;

public class ManageEastAsiaCountries {

    private final Validate validate = new Validate();
    private final Controller controller = new Controller();

    //display menu
    public int menu() {
        System.out.println("========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit ");
        System.out.println("========================================================================");
        int choice =  validate.inputChoice(1, 5);
        return choice;
    }


    //them 1 nuoc vao list
    public void addCountryInformation() {
        String countryCode = validate.inputCountryCode();
        String nameCountry = validate.inputCountryName();
        double totalArea = validate.inputTotalArea();
        String terrain = validate.inputCountryTerrain();
        if (controller.addCountryInformation(countryCode, nameCountry, totalArea, terrain)) {
            System.out.println("Add successful!");
        } else {
            System.out.println("Add fail!");
        }


    }

    //in ra all nuoc
    public void getRecentlyEnteredInformation(ArrayList<Country> listCountry) {
        System.out.printf("%-10s %-10s %-15s %-10s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country loop : listCountry) {
            loop.display();
        }
        System.out.println();
    }

    //tim kiem nuoc bang ten nuoc
    public void searchInformationByName() {
        String nameCountry = validate.inputCountryName();

        ArrayList<Country> result = controller.searchByName(nameCountry);
        if (!result.isEmpty()) {
            this.getRecentlyEnteredInformation(result);
        } else {
            System.out.println("List dont have country " + nameCountry);
        }
    }

    //sort theo thu tu nho den lon dua vao total area va in ra
    public void sortInformationByAscendingOrder() {
        controller.sortCountriesByTotalArea(getList());
        this.getRecentlyEnteredInformation(getList());
    }


    public ArrayList<Country> getList() {
        return controller.getListCountry();
    }
}


