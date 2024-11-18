package country;


public class Main {
    public static void main(String[] args) {
        ManageEastAsiaCountries management = new ManageEastAsiaCountries();

        while (true) {
            int choice = management.menu();

            switch (choice) {
                case 1:
                    management.addCountryInformation();
                    break;
                case 2:
                    management.getRecentlyEnteredInformation(management.getList());
                    break;
                case 3:
                    management.searchInformationByName();
                    break;
                case 4:
                    management.sortInformationByAscendingOrder();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
