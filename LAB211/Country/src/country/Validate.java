package country;

import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);

    //input choice
    public int inputChoice(int min, int max) {
        int choice;
        while (true) {
            try {
                System.out.print("Please enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a choice from " + min + " to " + max);
                System.out.print("Enter again: ");
            }
        }
    }

    //input name of country
    public String inputCountryName() {
        String name;
        while (true) {
            try {
                System.out.println("Enter name of country: ");
                name = sc.nextLine();
                if (!name.isEmpty() && name.matches("[a-z A-Z\\s]+")) {
                    return name;
                } else {
                    System.out.println("Name cannot be empty and no contains digit");
                }
            } catch (Exception e) {
            }
        }
    }

    //input terrain of country
    public String inputCountryTerrain() {
        String terrain;
        while (true) {
            try {
                System.out.println("Enter terrain of country: ");
                terrain = sc.nextLine();
                if (!terrain.isEmpty() && terrain.matches("^[a-z A-Z\\s]+$")) {
                    return terrain;
                } else {
                    System.out.println("Terrain cannot be empty and no contains digit");
                }
            } catch (Exception e) {
            }
        }
    }

    //input code of country
    public String inputCountryCode() {
        String code;
        while (true) {
            try {
                System.out.println("Enter code of country");
                code = sc.nextLine().trim();
                if (!code.isEmpty()) {
                    return code;
                } else {
                    System.out.println("Country Code cannot be empty");
                }
            } catch (Exception e) {
            }
        }
    }


    //input area of country
    public double inputTotalArea() {
        double area;
        while (true) {
            try {
                System.out.println("Enter total area: ");
                area = Double.parseDouble(sc.nextLine().trim());
                if (area > 0) {
                    return area;
                }
                    System.out.println("Total Area must be greater than zero");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
    }


}
